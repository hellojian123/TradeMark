<%--
  Created by IntelliJ IDEA.
  User: hejian
  Date: 14-5-6
  Time: 下午3:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/taglibs.jsp"%>

<html>
<head>
	<title>中国商标网网上查询</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="${ctx}/matter/js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript">
		var validateCode="";
		function validation(){
			validateCode = $("#imagecode").val();
			if(validateCode == null || validateCode == ""){
				alert("验证码不能为空!");
				return false;
			}
			return true;
		}

		$(function(){
			click_vcode();
			$("#codeBut").click(function(){
				if(validation()){
					$.post("${ctx}/doValidateSearchCode",{"validateCode":validateCode},function(data){
						if(data==1){
							$("#imagecode").val("");
							click_vcode();
							alert("验证码输入错误!");
							return;
						}
						window.returnValue=1;   //向原父窗口传值，表示已成功验证并关闭窗口。而不是直接点击窗口右上角的关闭按钮关闭的。
						window.close();
					});
				}
			});
			$("body").keydown(function(event){
				if(event.keyCode==13){ //回车键
					$("#codeBut").click();
				}
			});
		});

		/**加载验证码**/
		function click_vcode(){
			$("#validateCode").attr("src","${ctx}/getValidationCode?d="+new Date());
		}
	</script>
</head>

<body>
	<table align="center" width="100%">
		<tbody><tr>
			<td width="25%"><br>
				<font style="color: #666;" size="2">请输入验证码：</font>
			</td>
			<td width="75%"><br>
				<input  style="vertical-align:middle;width: 70px"  type="text" id="imagecode" >
				<img id="validateCode" style="vertical-align:middle;cursor: hand"  src="" onclick="click_vcode();">
				<font style="color: #666; font-size: 12px;">看不清楚？
					<a href="javascript:click_vcode();">点击刷新</a>
				</font>
			</td>
		</tr>
		<tr>
			<td>
				&nbsp;
			</td>
			<td colspan="2" align="left">
				<font style="color:red; font-size: 12px;">注:验证码不区分大小写</font>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<br>
				<input type="button" value="确定"  id="codeBut" class="btn01">
			</td>
		</tr>
		</tbody>
	</table>

</body>
</html>
