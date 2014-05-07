<%--
  Created by IntelliJ IDEA.
  User: hejian
  Date: 14-5-5
  Time: 下午4:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//Dtd XHTML 1.0 transitional//EN" "http://www.w3.org/tr/xhtml1/Dtd/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>商标查询</title>
	<link rel="stylesheet" href="${ctx}/matter/css/style.css" media="screen"  type="text/css"/>
	<link rel="stylesheet" href="${ctx}/matter/css/reset.css" media="screen"  type="text/css"/>
	<script type="text/javascript" src="${ctx}/matter/js/jquery-1.8.3.min.js"></script>
	<style type="text/css">
		body{background-color: #391884;}
		#helpinfo:hover{color: #ff0000;}
	</style>
	<script type="text/javascript">
		/******************************************************
		 * 检测输入是否合法
		 1.类号:	可以为空，值在1-45之间
		 2.注册号: 可以为空，如果不为空，则下面的其他输入无效。
		 3.商标名称：	可以为空，
		 4.商标申请人名称：可以为空。
		 5.除了类号外，不可以都为空，也不可以同时填写任意的2个
		******************************************************/
		var classificationNum; 	//国际分类号
		var applyNum;			//注册号/申请号
		var trademarkName;		//商标名称
		var applicantNameZh;	//申请人名称(中文)
		var applicantNameEn;	//申请人名称(英文)
		var selectTN;           //商品名称的模糊查询类型(0前包含,1精确,2包含)
		var selectCHPN;         //申请人名称(中文)的模糊查询类型(0前包含,1精确,2包含)
		var selectENGPN;        //申请人名称(英文)的模糊查询类型(0前包含,1精确,2包含)

		function doValidate(){
			classificationNum = $("input[name='IntCls']").val();
			applyNum = $("input[name='RegNO']").val();
			trademarkName = $("input[name='tradName']").val();
			applicantNameZh = $("input[name='PeoNameCH']").val();
			applicantNameEn = $("input[name='PeoNameENG']").val();
			selectTN = $("select[name='selectTN']").val();
			selectCHPN = $("select[name='selectCHPN']").val();
			selectENGPN = $("select[name='selectENGPN']").val();

			if($.trim(applyNum)=="" && $.trim(trademarkName)=="" && $.trim(applicantNameZh)=="" && $.trim(applicantNameEn)==""){
				alert("请填写查询条件(只填写类号是不能查询的)");
				return false;
			}

			if(!($.trim(classificationNum)=="")){
				var reg = new RegExp(/^[1-4][0-5]{0,1}$/);
				if(!reg.test(classificationNum)){
					alert("请正确输入1-45之间的类号,或则可以不输入!");
					$("input[name='IntCls']").val("");
					return false;
				}
			}

			if(!($.trim(applyNum)=="")){
				if(!($.trim(trademarkName)=="")||!($.trim(applicantNameZh)=="")||!($.trim(applicantNameEn)=="")){
					alert("注册号/申请号不为空,只能按注册号/申请号查询!");
					$("input[name='tradName']").val("");
					$("input[name='PeoNameCH']").val("");
					$("input[name='PeoNameENG']").val("");
					return false;
				}
			}

			if(!($.trim(trademarkName)=="")){
				if(!($.trim(applicantNameZh)=="")||!($.trim(applicantNameEn)=="")){
					alert("商标名称不为空,只能按商标名称查询!");
					$("input[name='PeoNameCH']").val("");
					$("input[name='PeoNameENG']").val("");
					return false;
				}
			}

			var regex = new RegExp(/^[\u4e00-\u9fa5]+$/);
			if(!($.trim(applicantNameZh)=="")){
				if(!regex.test(applicantNameZh)){
					alert("申请人(中文)需正确输入中文字符!");
					return false;
				}
				if(!($.trim(applicantNameEn)=="")){
					alert("申请人(中文)不为空,只能按申请人(中文)查询!");
					$("input[name='PeoNameENG']").val("");
					return false;
				}
			}

			var patten = new RegExp(/^[a-zA-z]+$/);
			if(!($.trim(applicantNameEn)=="")){
				if(!patten.test(applicantNameEn)){
					alert("申请人(英文)需输入英文字符!");
					return false;
				}
			}
			return true;
		}

		$(function(){
			$("#search").click(function(){
				if(doValidate()){
					var codeFlag = window.showModalDialog("${ctx}/searchValidateCode.jsp",window,"dialogWidth=420px;dialogHeight=150px;status=no;resizable=no");
					if(codeFlag==undefined || codeFlag==''){
						alert("操作失误!");
						return;
					}
					/*校验成功，打开查询页面，然后在显示查询页面向后台请求相应的查询数据*/
					var popupwindow = window.open("${ctx}/queryResultList?classificationNum="+classificationNum+
					    "&applyNum="+applyNum+
					    "&trademarkName="+trademarkName+
					    "&applicantNameZh="+applicantNameZh+
					    "&applicantNameEn="+applicantNameEn+
					    "&selectTN="+selectTN+
					    "&selectCHPN="+selectCHPN+
					    "&selectENGPN="+selectENGPN,"list",
					    "left=100,top=20,width=820,height=700,scrollbars=yes,resizable=yes,location=no,status=no,resizable=no"
					);




				}
			});
			$("#refill").click(function(){
				$("input[name='IntCls']").val("");
				$("input[name='RegNO']").val("");
				$("input[name='tradName']").val("");
				$("input[name='PeoNameCH']").val("");
				$("input[name='PeoNameENG']").val("");
			});
		});
	</script>
</head>
<body>
	<div id="warper">
		<div id="header">
			<div class="logo"><a href="" target="_self"><img src="${ctx}/matter/images/logo.png"  alt="" /></a></div>
			<span class="la"><a href="#" target="_blank">English</a></span>
			<div class="ad"><img src="${ctx}/matter/images/1-2.gif"/></div>

			<div class="clear"></div>
		</div>
		<div class="nav">
			<ul>
				<li>首页</li>
				<li>商标近似查询</li>
				<li><a href="#" target="_self">商标综合查询</a></li>
				<li>商标状态查询</li>
				<li>错误信息反馈</li>
				<li>操作指南</li>
			</ul>
		</div>

		<!--end header -->
		<div id="main">
			<div class="main-title"><img src="${ctx}/matter/images/1_0.jpg" /></div>
			<table class="table-wrap">
				<tbody>
				<tr>
					<td><span class="title">商标综合查询</span></td>
				</tr>
				<tr>
					<td><table class="table-middle">
						<tbody>
						<tr>
							<td><table class="table-inside" border="1" >
								<tbody>
								<tr >
									<td  colspan="1" > 国际分类号 </td>
									<td colspan="1"><input name="IntCls" size="30" maxlength="2">
										<a id="helpinfo" href="javascript:void(0)" style="TEXT-DECORATION: underline;" onclick="javascript:window.open('${ctx}/categoriesHelp.jsp','','width=650 height=400 left=200 top=30 menubar=0 toolbar=0 location=no status=no directories=0 scrollbars=1 resizable=no')" >商品分类帮助</a></td>
								</tr>
								<tr>
									<td colspan="1"> 注册号/申请号</td>
									<td colspan="1" ><INPUT name="RegNO" size="30" maxlength="15"></td>
								</tr>
								<tr>
									<td colspan="1">商标名称</td>
									<td colspan="1"><INPUT name="tradName" size="30">
										<select name="selectTN" size="0">
											<option value="0">前包含</option>
											<option value="1">精确</option>
											<option value="2">包含</option>
										</select></td>
								</tr>
								<tr>
									<td colspan="1"> 申请人名称(中文) </td>
									<td colspan="1"><input name="PeoNameCH" size="30">
										<select name="selectCHPN" size="0">
											<option value="0">前包含</option>
											<option value="1">精确</option>
											<option value="2">包含</option>
										</select></td>
								</tr>
								<tr>
									<td colspan="1"> 申请人名称(英文) </td>
									<td colspan="1"><input name="PeoNameENG" size="30">
										<select name="selectENGPN" size="0">
											<option value="0">前包含</option>
											<option value="1">精确</option>
											<option value="2">包含</option>
										</select></td>
								</tr>
								<tr class="bt">
									<td colspan="2"><input type="hidden" name="SelectContent">
										<input id="search" type="button" value="查 询" >
										<input id="refill" type="reset" value="重 填" name="B2">
									</td>
								</tr>
								<tr class="bt">
									<td  colspan="2">输入相关内容提交查询，只输入类号是不可以查询的。
									</td>
								</tr>
								</tbody>
							</table></td>
						</tr>
						</tbody>
					</table></td>
				</tr>
				</tbody>
			</table>
		</div>
		<div id="footer">
			<p> “中国商标网”是国家工商行政管理总局商标局主办的唯一在线查询商标注册信息的网站V1.017，免费向公众开通商标网上查询。<br />
				网址：http://www.ctmo.gov.cn或http://sbj.saic.gov.cn<br />
				中华人民共和国国家工商行政管理总局 北京市西城区三里河东路八号.100820 国家工商总局经济信息中心技术支持</p>
		</div>
	</div>
</body>
</html>
