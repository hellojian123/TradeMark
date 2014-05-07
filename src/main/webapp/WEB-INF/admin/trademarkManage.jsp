<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<style type="text/css">
			body{
				display: none;
			}
		</style>
		<title>商标管理</title>
		<%@include file="/common/common.jsp"%>
		<script type="text/javascript" src="${ctx}/js/page.js"></script>
		<script type="text/javascript" src="${ctx}/js/FilterHtml.js"></script>
		<script type="text/javascript" src="${ctx}/date/WdatePicker.js"></script>
		<script type="text/javascript" src="${ctx}/js/ajaxfileupload.js"></script>
		<script type="text/javascript">
		var objId=-1;
        var applyNum="";
		var classificationNum="";
		var trademarkName="";
		var applyDate="";
		var applicantNameZh="";
		var applicantAddressZh="";
		var imgPath="";
		var servicesList="";
		var similarGroup="";
		var firstNoticeNum="";
		var registerNoticeNum="";
		var firstNoticeDate="";
		var registerNoticeDate="";
		var exclusiveRightStartDate="";
		var exclusiveRightEndDate="";
		var agentName="";
		var trademarkType="";

		function validate(){
            applyNum=$("#applyNum").val();
            classificationNum=$("#classificationNum").val();
            trademarkName=$("#trademarkName").val();
            applyDate=$("#applyDate").val();
            applicantNameZh=$("#applicantNameZh").val();
            applicantAddressZh=$("#applicantAddressZh").val();
            imgPath=$("#imgUrlAddress").attr("src");
            servicesList=$("#servicesList").val();
            similarGroup=$("#similarGroup").val();
            firstNoticeNum=$("#firstNoticeNum").val();
            registerNoticeNum=$("#registerNoticeNum").val();
            firstNoticeDate=$("#firstNoticeDate").val();
            registerNoticeDate=$("#registerNoticeDate").val();
            exclusiveRightStartDate=$("#exclusiveRightStartDate").val();
            exclusiveRightEndDate=$("#exclusiveRightEndDate").val();
            agentName=$("#agentName").val();
            trademarkType=$("#trademarkType").val();
            if($.trim(applyNum)==""){
				alert("注册号/申请号不能为空！");
				return false;
			}
            if($.trim(classificationNum)==""){
                alert("国际分类号不能为空！");
                return false;
            }
            if($.trim(trademarkName)==""){
                alert("商标名称不能为空！");
                return false;
            }
            if($.trim(applyDate)==""){
                alert("请选择申请日期！");
                return false;
            }
            if($.trim(applicantNameZh)==""){
                alert("申请人名称（中文）不能为空！");
                return false;
            }
            if($.trim(applicantAddressZh)==""){
                alert("申请人地址（中文）不能为空！");
                return false;
            }
            if($.trim(firstNoticeNum)==""){
                alert("初审公告期号不能为空！");
                return false;
            }
            if($.trim(registerNoticeNum)==""){
                alert("注册公告期号不能为空！");
                return false;
            }
            if($.trim(firstNoticeDate)==""){
                alert("请选择初审公告日期！");
                return false;
            }
            if($.trim(registerNoticeDate)==""){
                alert("请选择注册公告日期！");
                return false;
            }
            if($.trim(trademarkType)==""){
                alert("商标类型不能为空！");
                return false;
            }
            if($.trim(similarGroup)==""){
                alert("类似群不能为空！");
                return false;
            }
            if($.trim(exclusiveRightStartDate)==""){
                alert("请选择专用权期限开始日期！");
                return false;
            }
            if($.trim(exclusiveRightEndDate)==""){
                alert("请选择专用权期限结束日期！");
                return false;
            }
            if($.trim(servicesList)==""){
                alert("商品/服务列表不能为空！");
                return false;
            }
            if($.trim(imgPath)==""){
                alert("请选择并上传商标图片！");
                return false;
            }
			return true;
		}
		
		function saveOrUpdate(){
			if(validate()){
				$.post("${ctx}/admin/AdminAddOrUpdateTrademarkServlet",
                {"id":objId,"applyNum":applyNum,"classificationNum":classificationNum,
                    "trademarkName":trademarkName,"applyDate":applyDate,
                    "applicantNameZh":applicantNameZh,"applicantNameEn":$("#applicantNameEn").val(),
                    "applicantAddressZh":applicantAddressZh,"applicantAddressEn":$("#applicantAddressEn").val(),
                    "imgPath":imgPath,"servicesList":servicesList,
                    "similarGroup":similarGroup,"firstNoticeNum":firstNoticeNum,
                    "registerNoticeNum":registerNoticeNum,"firstNoticeDate":firstNoticeDate,
                    "registerNoticeDate":registerNoticeDate,"exclusiveRightStartDate":exclusiveRightStartDate,
                    "exclusiveRightEndDate":exclusiveRightEndDate,"afterNamedDate":$("#afterNamedDate").val(),
                    "internationalRegisterDate":$("#internationalRegisterDate").val(),"priorityDate":$("#priorityDate").val(),
                    "agentName":agentName,"specifyColor":$("#specifyColor").val(),
                    "trademarkType":trademarkType,"share":$(":input:radio:checked").val(),
                    "remarks":$("#remarks").val(),"trademarkProcess":$("#trademarkProcess").val()
                },function(msg){
					alert(msg);
                    window.location.reload();
                    $("html, body").animate({ scrollTop: 0 }, 100);
				});

			}
		}
		
		$(document).ready(function(){
				$(window.parent.document.getElementById("childIframe")).height(1900);
				$('.content-box .content-box-content div.tab-content').hide();
				$('ul.content-box-tabs li a.default-tab').addClass('current');
				$('.content-box-content div.default-tab').show(); 
				$('.content-box ul.content-box-tabs li a').click( // When a tab is clicked...
					function() { 
						$(this).parent().siblings().find("a").removeClass('current'); // Remove "current" class from all tabs
						$(this).addClass('current'); // Add class "current" to clicked tab
						var currentTab = $(this).attr('href'); // Set variable "currentTab" to the value of href of clicked tab
						$(currentTab).siblings().hide(); // Hide all content divs
						$(currentTab).show(); // Show the content div with the id equal to the id of clicked tab
						//$("#role").html("添加新商标");
						return false; 
					}
				);
				$('tbody tr:even').addClass("alt-row");
				$('.check-all').click(
					function(){
						$(this).parent().parent().parent().parent().find("input[type='checkbox']").attr('checked', $(this).is(':checked'));   
					}
				);
				
				$(".close").click(
					function () {
						$(this).parent().fadeTo(400, 0, function () { // Links with the class "close" will close parent
							$(this).slideUp(400);
						});
						return false;
					}
				);
				//给导航名赋值   使其选中
				$("#selectobjType").val(${menuTypeId});
				$(".deleteobj").click(function(){
					var objId=$(this).attr("objId");
					var objTitle=$(this).attr("objTitle");
			    	var sure=confirm("确认删除标题为"+objTitle+"的商标吗？");
					if(sure){
						$.post("${ctx}/admin/obj/deleteobjById",{objId:objId},function(data){
								if(data=="0"){
									alert("删除成功！");
									location.href="${ctx}/admin/obj?currentPage=${currentPage}";
								}else{
									alert("删除失败！");
								}
						});
					}
					return false;
				});
				
				$("#objType").change(function(){
					var type=$(this).val();
					if(type==7||type==8){//显示预览图地址
						$("#previewImgP").css("display","block");
						$("#gqdiv").css("display","none");
					}else if(type==2||type==3){//供求信息
						$("#gqdiv").css("display","block");
						$("#previewImgP").css("display","block");
						$("#hyzx").css("display","none");
					}else if(type==4){//行业资讯
						$("#hyzx").css("display","block");
						$("#gqdiv").css("display","none");
						$("#previewImgP").css("display","none");
					}else{//隐藏预览图地址
						$("#previewImgP").css("display","none");
						$("#gqdiv").css("display","none");
						$("#hyzx").css("display","none");
					}
				});
				document.body.style.display="block";
			});	
			
			function edit(id){
				var url="${ctx}/admin/AdminGetTrademarkByIdServlet";
				$.getJSON(url,{"id":id},function(data){
                        objId=id;
						/*data=$.parseJSON(data);*/
						var a = $('.content-box ul.content-box-tabs li a');
						$(a).parent().siblings().find("a").removeClass('current');
						$(a).addClass('current');
						$("#role").html("修改商标");
						$(".default-tab").removeClass('current');
						$("#tab1").hide(); 
						$("#tab2").show();
				});
			}

        function uploadimage(file){
            $.ajaxFileUpload({
                url:'${ctx}/fileupload',
                secureuri:false,
                fileElementId:"imgPath",
                dataType: 'json',
                success: function (data, status)
                {
                    if(data.error==0){//成功
                        $("#imgUrlAddress").attr("src",data.url);
                        alert("上传成功！");
                    }else{//失败
                        alert(data.message);
                    }
                },
                error: function (data, status, e)
                {
                    alert(e);
                }
            });
            return false;
        }

            $(function(){
                // 给 window 对象绑定 scroll 事件
                $(window).bind("scroll", function(){

                    // 获取网页文档对象滚动条的垂直偏移
                    var scrollTopNum = $(document).scrollTop(),
                    // 获取浏览器当前窗口的高度
                            winHeight = $(window).height(),
                            returnTop = $("div.returnTop");

                    // 滚动条的垂直偏移大于 0 时显示，反之隐藏
                    (scrollTopNum > 0) ? returnTop.fadeIn("fast") : returnTop.fadeOut("fast");

                    // 给 IE6 定位
                    if (!-[1,] && !window.XMLHttpRequest) {
                        returnTop.css("top", scrollTopNum + winHeight - 200);
                    }

                });
            });

		</script>
		<style type="text/css">
			label{
				float: left;
			}
		</style>
	</head>
	<body style="background-image: none;">
			<div id="main-content" style="width: 100%;height: 100%;margin-left: 0px;">
				<div class="content-box">
					<div class="content-box-header">
						<h3>
							商标管理
						</h3>
						<ul class="content-box-tabs">
							<li>
								<a href="#tab1" class="default-tab">商标信息列表</a>
							</li>
							<li>
								<a href="#tab2" id="role">添加新商标</a>
							</li>
						</ul>
						<div class="clear"></div>
					</div>
					<div class="content-box-content">
						<div class="tab-content default-tab" id="tab1">
							<div class="notification attention png_bg">
								<a href="#" class="close"><img
										src="${ctx}/images/icons/cross_grey_small.png"
										title="Close this notification" alt="close" />
								</a>
								<div>
								<form action="${ctx}/admin/likeSearchTrademarkNameServlet" method="get">
									<input type="hidden" name="currentPage" value="${currentPage}">
									商标名
                                        <input class="Medium-input" type="text"  id="trademarkNameSearchVal" />
										<input type="submit" value="  查  询 " class="button"/>
									</form>
									</input>
								</div>
							</div>

							<table>

								<thead>
									<tr>
										<th>
											<input class="check-all" type="checkbox" />
										</th>
										<th>
											序号
										</th>
										<th>
											注册号/申请号
										</th>
                                        <th>
                                            商标名称
										</th>
										<th>
                                            国际分类号
										</th>
										<th>
											申请人名称（中文）
										</th>
										<th>
                                            申请人名称（英文）
										</th>
										<th>
											操作
										</th>
									</tr>

								</thead>

								<tfoot>
									<tr>
										<td colspan="7">
											<div class="bulk-actions align-left">
												<a class="button" href="javascript:delByIds('${ctx}');">删除选定</a>
											</div>
											<!-- 分页信息 -->
											<div class="pagination"> 
												<c:if test="${pm.result ne null}">
												<script>
													var pg = new showPages('pg');
													pg.pageCount = ${pm.maxPage};
													pg.argName = 'currentPage';
													pg.printHtml();  
												</script>
												</c:if>
											</div>
											<!-- End .pagination -->
											<div class="clear"></div>
										</td>
									</tr>
								</tfoot>
								<!-- 数据展示 -->
								<tbody id="datalist">
									<c:choose>
										<c:when test="${pm.result eq null}">
											<tr>
												<td colspan="7">没有商标信息，请先添加</td>
											</tr>
										</c:when>
										<c:otherwise>
											<c:forEach var="obj" items="${pm.result}" varStatus="status">
												<tr id="r${obj.id}">
													<td><input type="checkbox" name="xidx" value="${obj.id}"/></td>
													<td>${status.index+1}</td>
                                                    <td>${obj.applyNum}</td>
                                                    <td>${obj.trademarkName}</td>
                                                    <td>${obj.classificationNum}</td>
													<td>${fn:substring(obj.applicantNameZh,0,10)}</td>
													<td>${fn:substring(obj.applicantNameEn,0,15)}</td>
													<td>
														<a href="javascript:void(0)" class="deleteObj" objId="${obj.id}" objName="${obj.trademarkName}" title="删除商标">
															<img src="${ctx}/images/icons/cross.png" alt="删除商标" />
														</a>
														<a href="javascript:edit(${obj.id})" title="修改商标"><img src="${ctx}/images/icons/hammer_screwdriver.png" alt="修改商标" /></a>
													</td>
												</tr>
											</c:forEach>
										</c:otherwise>
									</c:choose>
								</tbody>
							</table>
						</div>
						<!-- End #tab1 -->

						<div class="tab-content" id="tab2">
								<fieldset>
                                    <center>（注：黄色背景叹号为必填项，蓝色为选填项）</center><br/>
								<form action="${ctx}/admin/obj/add" method="post" id="mainform">
									<p>
										<label>
                                            &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  注册号/申请号：
										</label>
										<input class="text-input small-input" type="text" id="applyNum" name="applyNum" />
										<span class="input-notification attention png_bg">输入注册号/申请号信息</span>
									</p>
									<p>
										<label>
                                            &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;国际分类号：
										</label>
                                        <input class="text-input small-input" type="text" id="classificationNum" name="classificationNum"
                                               onkeyup="value=value.replace(/[^\d]/g,'') "
                                               onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))"/>
										<span class="input-notification attention png_bg">输入国际分类号信息</span>
									</p>
                                    <p>
										<label>
                                            &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 商标名称：
										</label>
                                        <input class="text-input small-input" type="text" id="trademarkName" name="trademarkName" />
										<span class="input-notification attention png_bg">输入商标名称信息</span>
									</p>
                                    <p>
										<label>
                                            &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 申请日期：
										</label>
                                        <input class="text-input small-input" type="text" onClick="WdatePicker()" id="applyDate" name="applyDate" size="8"/>
										<span class="input-notification attention png_bg">选择申请日期</span>
									</p>
                                    <p>
                                        <label>
                                            申请人名称（中文）：
                                        </label>
                                        <input class="text-input small-input" type="text" id="applicantNameZh" name="applicantNameZh"/>
                                        <span class="input-notification attention png_bg">输入申请人名称（中文）信息</span>
                                    </p>
                                    <p>
                                        <label>
                                            申请人名称（英文）：
                                        </label>
                                        <input class="text-input small-input" type="text" id="applicantNameEn" name="applicantNameEn" />
                                        <span class="input-notification information png_bg">输入申请人名称（英文）信息</span>
                                    </p>
                                    <p>
                                        <label>
                                            申请人地址（中文）：
                                        </label>
                                        <input class="text-input small-input" type="text" id="applicantAddressZh" name="applicantAddressZh" />
                                        <span class="input-notification attention png_bg">输入申请人地址（中文）信息</span>
                                    </p>
                                    <p>
                                        <label>
                                            申请人地址（英文）：
                                        </label>
                                        <input class="text-input small-input" type="text" id="applicantAddressEn" name="applicantAddressEn" />
                                        <span class="input-notification information png_bg">输入申请人地址（英文）信息</span>
                                    </p>
                                    <p>
                                        <label>
                                            &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;初审公告期号：
                                        </label>
                                        <input class="text-input small-input" type="text" id="firstNoticeNum" name="firstNoticeNum" />
                                        <span class="input-notification attention png_bg">输入初审公告期号信息</span>
                                    </p>
                                    <p>
                                        <label>
                                            &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;注册公告期号：
                                        </label>
                                        <input class="text-input small-input" type="text" id="registerNoticeNum" name="registerNoticeNum" />
                                        <span class="input-notification attention png_bg">输入注册公告期号信息</span>
                                    </p>
                                    <p>
                                        <label>
                                            &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;初审公告日期：
                                        </label>
                                        <input class="text-input small-input" type="text" onClick="WdatePicker()" id="firstNoticeDate" name="firstNoticeDate" size="8"/>
                                        <span class="input-notification attention png_bg">选择初审公告日期</span>
                                    </p>
                                    <p>
                                        <label>
                                            &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;注册公告日期：
                                        </label>
                                        <input class="text-input small-input" type="text" onClick="WdatePicker()" id="registerNoticeDate" name="registerNoticeDate" size="8"/>
                                        <span class="input-notification attention png_bg">选择注册公告日期</span>
                                    </p>

                                    <p>
                                        <label>
                                            &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;后期指定日期：
                                        </label>
                                        <input class="text-input small-input" type="text" onClick="WdatePicker()" id="afterNamedDate" name="afterNamedDate" size="8"/>
                                        <span class="input-notification information png_bg">选择后期指定日期</span>
                                    </p>
                                    <p>
                                        <label>
                                            &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;国际注册日期：
                                        </label>
                                        <input class="text-input small-input" type="text" onClick="WdatePicker()" id="internationalRegisterDate" name="internationalRegisterDate" size="8"/>
                                        <span class="input-notification information png_bg">选择国际注册日期</span>
                                    </p>
                                    <p>
                                        <label>
                                            &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;优先权日期：
                                        </label>
                                        <input class="text-input small-input" type="text" onClick="WdatePicker()" id="priorityDate" name="priorityDate" size="8"/>
                                        <span class="input-notification information png_bg">选择优先权日期</span>
                                    </p>
                                    <p>
                                        <label>
                                            &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;代理人名称：
                                        </label>
                                        <input class="text-input small-input" type="text" id="agentName" name="agentName" />
                                        <span class="input-notification information png_bg">输入代理人名称信息</span>
                                    </p>
                                    <p>
                                        <label>
                                            &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 指定颜色：
                                        </label>
                                        <input class="text-input small-input" type="text" id="specifyColor" name="specifyColor" />
                                        <span class="input-notification information png_bg">输入指定颜色信息</span>
                                    </p>
                                    <p>
                                        <label>
                                            &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 商标类型：
                                        </label>
                                        <input class="text-input small-input" type="text" id="trademarkType" name="trademarkType" />
                                        <span class="input-notification attention png_bg">输入商标类型信息</span>
                                    </p>
                                    <p>
                                        <label>
                                            &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;类似群：
                                        </label>
                                        <input class="text-input small-input" type="text" id="similarGroup" name="similarGroup"
                                               onkeyup="value=value.replace(/[^\d]/g,'') "
                                               onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))"/>
                                        <span class="input-notification attention png_bg">输入类似群信息</span>
                                    </p>
                                    <p>
                                        <label>
                                            &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 专用权期限：
                                        </label>
                                        <input class="text-input Medium-input" type="text" onClick="WdatePicker()" id="exclusiveRightStartDate" name="exclusiveRightStartDate" size="8"/>
                                        到
                                        <input class="text-input Medium-input" type="text" onClick="WdatePicker()" id="exclusiveRightEndDate" name="exclusiveRightEndDate" size="8"/>
                                        <span class="input-notification attention png_bg">选择专用权期限开始日期和结束日期</span>
                                    </p>
                                    <p>
                                        <label>
                                            &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;是否共有商标：
                                        </label>
                                           是<input type="radio" id="shareYes" name="share" value="1"/>
                                           否<input type="radio" id="shareNo" name="share" checked="checked" value="0"/>
                                        <span class="input-notification information png_bg">选择是否为共有商标</span>
                                    </p>
                                    <br/>
                                    <div style="border-bottom: 1px dashed #000000"></div>
                                    <br/>
                                    <p>
                                        <label>
                                            商品/服务列表：
                                        </label>
                                        <textarea rows="3" cols="8" id="servicesList" name="servicesList"></textarea>
                                        <span class="input-notification attention png_bg">输入商品/服务列表信息，多个以 ; 分开</span>
                                    </p>
                                    <p>
                                        <label>
                                            商标流程：
                                        </label>
                                        <textarea rows="3" cols="8" id="trademarkProcess" style="width: 50%" name="trademarkProcess"></textarea>
                                        <span class="input-notification information png_bg">输入商标流程信息</span>
                                    </p>
                                    <p>
                                        <label>
                                            备注：
                                        </label>
                                        <textarea rows="3" cols="8" id="remarks" name="remarks"></textarea>
                                        <span class="input-notification information png_bg">输入备注信息</span>
                                    </p>
                                    <P>
                                        <label>
                                            上传商标图片：
                                        </label>
                                        <input style="width:137px;"  class="testInput" name="imgPath" id="imgPath" type="file"/>
                                        <input class="button setBtnWidth" type="button" value="上传" onclick="uploadimage()" style="width:50px;" id="uploadImg"/>
                                        <span class="input-notification attention png_bg">选择要上传的图片</span>
                                        <br/>
                                        <img src="" width="200px" height="200px" style="border:1px #555 solid;" id="imgUrlAddress"  />
                                    </P>
                                    <p>
											<input class="button" type="button" style="width:90px;margin-left:70px;" onclick="saveOrUpdate()" value="保存"/>
									</p>
									</form>
								</fieldset>
								<div class="clear"></div>
						</div>
					</div>
				</div>
				<jsp:include page="bottom.jsp" />
			</div>
			<script type="text/javascript">
				load('${ctx}');
			</script>
	</body>
</html>
