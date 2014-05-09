package com.isoft.util;

import com.google.gson.Gson;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;

/**
 * Created by hejian on 14-5-4.
 * ajax文件上传servlet类
 */
public class FileUpload extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String dirName = request.getParameter("dir");
		//定义允许上传的文件扩展名
		HashMap<String, String> extMap = new HashMap<String, String>();
		extMap.put("image", "gif,jpg,jpeg,png,bmp");
		extMap.put("flash", "swf,flv");
		extMap.put("media", "swf,flv,mp3,wav,wma,wmv,mid,avi,mpg,asf,rm,rmvb");
		extMap.put("file", "doc,docx,xls,xlsx,ppt,htm,html,txt,zip,rar,gz,bz2");
		//定义最大文件大小（单位M）
		int mediaMaxSize=20;//视频文件上传大小限制
		int flashMaxSize=10;//flash文件上传大小限制
		int imageMaxSize=2;//图片文件上传大小限制
		int fileMaxSize=10;//一般类型文件大小限制
		//为保证服务器安全，上传文件应该放在外界无法直接访问的目录
		String savePath = request.getServletContext().getRealPath("/attached");
		checkDir(savePath,out);//检查目录是否存在且可写。否则生成目录或置为可写
		if (dirName == null || dirName.trim().equals("")) {
			dirName = "image";
		}
		if(!extMap.containsKey(dirName)){
			out.println(str2Json("目录名不正确。", 1));
			return;
		}
		try {
			DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setHeaderEncoding("UTF-8"); //解决上传文件名中文乱码
			if(!upload.isMultipartContent(request)){//如果不是Multipart类型，则为传统数据。
				out.println(str2Json("请选择文件!", 1));
				return;
			}
			//upload.setFileSizeMax(1024*1024);//设置单个文件大小限制为1M
			List<FileItem> list = upload.parseRequest(request);
			for(FileItem item:list){
				if(item.isFormField()){//fileitem中封装的是普通输入项的数据
					String name = item.getFieldName(); //字段名称
					String value = item.getString("UTF-8");//字段的值(以utf-8编码获得，解决乱码)
				}else{//fileitem中封装的是上传文件
					long fileSize = item.getSize();
					String filename = item.getName();
					if(filename==null || filename.trim().equals("")){
						continue;
					}
					filename = filename.substring(filename.lastIndexOf("\\")+1);//不同的浏览器提交的文件是不一样  c:\a\b\1.txt   1.txt,所以需要截取
					long maxSize = 1000000;
					String fileType="";
					int tempFileSize=0;
					if(dirName.equals("media")){//上传的是一个视频文件 按照视频文件标准限制文件大小
						maxSize=mediaMaxSize*1024*1024;
						fileType="视频";
						tempFileSize=mediaMaxSize;
					}
					if(dirName.equals("flash")){//上传的是一个flash文件 按照flash文件标准限制文件大小
						maxSize=flashMaxSize*1024*1024;
						fileType="flash";
						tempFileSize=flashMaxSize;
					}
					if(dirName.equals("image")){//上传的是一个图片文件 按照图片文件标准限制文件大小
						maxSize=imageMaxSize*1024*1024;
						fileType="图片";
						tempFileSize=imageMaxSize;
					}
					if(dirName.equals("file")){//上传的是一个一般类型的文件 按照一般类型文件标准限制文件大小
						maxSize=fileMaxSize*1024*1024;
						fileType="一般类型文件";
						tempFileSize=fileMaxSize;
					}
					//检查文件大小
					if(fileSize> maxSize){
						out.println(str2Json("上传的" + fileType + "文件大小不能超过" + tempFileSize + "M。", 1));
						return;
					}
					//检查扩展名
					String fileExt = filename.substring(filename.lastIndexOf(".") + 1).toLowerCase();
					if(!Arrays.asList(extMap.get(dirName).split(",")).contains(fileExt)){
						out.println(str2Json("上传文件扩展名是不允许的扩展名。\n只允许" + extMap.get(dirName) + "格式。",1));
						return;
					}
					String saveFileName = makeFileName(filename);//得到文件保存的名称
					String realSavePath = makePath(savePath,saveFileName);//得到文件的实际保存目录
					InputStream in = item.getInputStream();
					FileOutputStream fileout = new FileOutputStream(realSavePath+"/"+saveFileName);
					byte[] buffer = new byte[1024];
					int len = 0;
					while ((len=in.read(buffer))>0){
						fileout.write(buffer,0,len);
					}
					in.close();
					fileout.close();

					String saveUrlP = makePath(request.getContextPath()+"/attached",saveFileName);
					String saveUrl = saveUrlP+"/"+saveFileName;
					out.println(str2Json(saveUrl,0));//文件上传成功，将文件web路径的url地址以json返回去
				}

			}
		}catch (Exception e) { //web层一般不再往外抛异常，后台记录打印异常即可
			e.printStackTrace();
			out.println(str2Json("上传文件失败",1));
		}

	}

	/**
	 * 检查目录
	 * @param savePath
	 * @return
	 */
	private void checkDir(String savePath,PrintWriter out) {
		File uploadDir = new File(savePath);
		if(!uploadDir.exists()){
			if(!uploadDir.mkdirs()){//如果创建失败
				out.println(str2Json("上传目录不存在",1));
			}
		}

		if(!uploadDir.canWrite()){
			if(!uploadDir.setWritable(true)){  //如果用户没有权限更改写权限
				out.println(str2Json("上传目录没有写权限",1));
			}
		}
	}

	/**
	 * 制作保存用随机文件名
	 * @param filename 上传的原始文件名
	 * @return
	 */
	private String makeFileName(String filename) {
		return UUID.randomUUID().toString()+"_"+filename;
	}

	/**
	 * 制作实际存储文件的路径(用hash算法将文件存放位置打散，提高性能)
	 * @param
	 * @param
	 * @return
	 */
	private String makePath(String savePath, String fileName) {
		int hashcode = fileName.hashCode();
		int dir1 = hashcode&0xf;  //用hash值的第0到4位产生文件保存的第一级目录
		int dir2 = (hashcode&0xf0)>>4; //用hash值的第5到8位产生文件保存的第二级目录
		String dir = savePath + "/" + "image" + "/" + dir1 + "/" + dir2;  //上传图片的实际位置
		File file = new File(dir);
		if(!file.exists()){  //判断目录是否存在，如果不存在则创建目录
			file.mkdirs();
		}
		return dir;
	}

	/**
	 * 将对象转换成json对象返回
	 * @para 
	 * @return
	 */
	private String str2Json(String message,Integer errorType){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("error",errorType);
		if(errorType==1){
			map.put("message",message);
		}
		if(errorType==0){
			map.put("url",message);
		}

		Gson gson = new Gson();
		return gson.toJson(map);
	}


}
