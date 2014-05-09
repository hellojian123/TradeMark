<%--
  Created by IntelliJ IDEA.
  User: hejian
  Date: 14-5-6
  Time: 上午9:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//Dtd Xhtml 1.0 transitional//EN" "http://www.w3.org/tr/xhtml1/Dtd/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>中国商标网</title>
	<link rel="stylesheet" href="${ctx}/matter/css/style.css" media="screen"  type="text/css"/>
	<link rel="stylesheet" href="${ctx}/matter/css/reset.css" media="screen"  type="text/css"/>
	<style type="text/css">
		.detail:hover{
			TEXT-DECORATION: underline;
			color: #ff0000;
		}
	</style>
	<script type="text/javascript">
		function getTademarkDetail(id){
			window.open('${ctx}/page/detail?id='+id,'datail','width=700 height=710 left=160 top=0 scrollbars=1 resizable=1');
		}
	</script>
</head>
<body>
<div id="query-results">
	<table class="query-results" border="0" cellspacing="0" cellpadding="0" >
		<tr>
			<td colspan="5" > 查询结果(查到1条记录)（点击注册号/申请号或类号可以看详细信息）<br>
				查询内容是: 类号是：${classificationNum};注册号是：${applyNum}; </td>
		</tr>
		<tr class="result">
			<td > 序号 </td>
			<td > 注册号/申请号 </td>
			<td > 类号 </td>
			<td > 商标 </td>
			<td > 申请人 </td>
		</tr>
		<tr class="result">
			<c:if test="${trademark!=null}">
				<td > 1 </td>
				<td ><a class="detail" href="javascript:getTademarkDetail('${trademark.id}')" style="cursor:hand;">${trademark.applyNum}</a></td>
				<td ><a class="detail" href="javascript:getTademarkDetail('${trademark.id}')" style="cursor:hand;">${trademark.classificationNum}</a></td>
				<td ><a class="detail" href="javascript:getTademarkDetail('${trademark.id}')" style="cursor:hand;">${trademark.trademarkName}</a></td>
				<td ><a class="detail" href="javascript:getTademarkDetail('${trademark.id}')" style="cursor:hand;">${trademark.applicantNameZh}</a></td>
			</c:if>
			<c:if test="${trademark==null}">
				<td  colspan="5"><span class="font-color">没有查询结构</span></td>
			</c:if>
		</tr>
		<tr>
			<td  colspan="5"><span class="font-color">仅供参考，无任何法律效力，请核实后使用</span></td>
		</tr>
		<tr>
			<td  colspan="5"><input type="button" value=" 打 印 " title=" 打 印 " onclick="window.print()">
				<input type="button" value=" 关 闭" title=" 关 闭 " onclick="window.close()"></td>
		</tr>
	</table>
</div>
</body>
</html>
