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
	<style type="text/css">
		body{background-color: #391884;
		}
	</style>
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
			<div class="main-title"><img src="images/1_0.jpg" /></div>
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
										<a href="" target="_blank">商品分类帮助</a></td>
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
										<input type="button" value="查 询" onClick="doConfirm()">
										<input type="reset" value="重 填" name="B2"></td>
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
