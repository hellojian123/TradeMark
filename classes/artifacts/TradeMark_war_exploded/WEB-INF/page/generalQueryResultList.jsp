<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/taglibs.jsp"%>

<html>
<head>
    <meta http-equiv="Content-Language" content="zh-cn">
    <meta http-equiv="Content-Type" content="text/html; charset=gbk">
    <meta content="MSHTML 6.00.2800.1400" name="GENERATOR">
    <title>中国商标网</title>
    <link href="${ctx}/matter/css/categoriesHelpStyle.css" type="text/css" rel="stylesheet">
	<link href="${ctx}/matter/css/fenye.css" type="text/css" rel="stylesheet">
	<script type="text/javascript" src="${ctx}/matter/js/jquery-1.8.3.min.js"></script>
	<script src="${ctx}/matter/js/fenyeScript.js" type="text/javascript"></script>
	<script language="JavaScript">
		function openWindow(regNum,classNum){
			//left=100,top=20,width=820,height=700,scrollbars=yes,resizable=yes,location=no,status=no,resizable=no
			window.open('${ctx}/queryResultList?applyNum='+regNum+'&selectTN=${type}&selectCHPN=${type}&selectENGPN=${type}&classificationNum='+classNum,'_blank','width=900 height=500 left=50 top=180  scrollbars=1 resizable=1');
		}
    </script>
</head>

<body leftmargin="0" topmargin="0" marginheight="0" marginwidth="0" >
<table align="center" border="0" width="610" cellpadding="0" cellspacing="1" height="100%">
<tbody><tr>
<td align="center">
<form name="ResForm">

<table border="0" width="600" cellpadding="0" cellspacing="1" class="tbg2">

<tbody>
<tr>
    <td height="17" colspan="2" align="center">查询结果如下（点击
	    <c:if test="${!empty applicantNameEn}">申请人名称</c:if>
	    <c:if test="${!empty applicantNameZh}">申请人名称</c:if>
	    <c:if test="${!empty trademarkName}">商标名称</c:if>
	    可以得到具体信息）
        <br>
        查询内容是:
        <c:if test="${!empty applicantNameEn}">申请人名称（英文）是:${applicantNameEn}</c:if>
        <c:if test="${!empty applicantNameZh}">申请人名称（中文）是:${applicantNameZh}</c:if>
        <c:if test="${!empty trademarkName}">商标名称是:${trademarkName}</c:if>
        选择的是:
        <c:if test="${type==1}">精确</c:if>
        <c:if test="${type==0}">前包含</c:if>
        <c:if test="${type==2}">包含</c:if>
    </td>
</tr>

<tr>
    <td align="center" colspan="2">
        查询到的页数共：${pm.maxPage}页；
	    当前是第${pm.curPage}页
    </td>
</tr>
<tr>
    <td align="center" colspan="2">
        <div id="page" class="yahoo2">
        </div>
		<script type="text/javascript">
			$("#page").html(fenyeComment("${pm.maxPage}","${pm.curPage}","${ctx}/queryResultList",
					"trademarkName=${trademarkName}&applicantNameZh=${applicantNameZh}&applicantNameEn=${applicantNameEn}"+
					"&selectTN=${type}&selectCHPN=${type}&selectENGPN=${type}"));
		</script>
    </td>
</tr>

<tr>
    <td align="center" colspan="1" width="10%">序号</td>
    <td align="center" colspan="1" width="25%">
        <c:if test="${!empty applicantNameEn}">申请人名称（英文）</c:if>
        <c:if test="${!empty applicantNameZh}">申请人名称（中文）</c:if>
        <c:if test="${!empty trademarkName}">商标名称</c:if>
    </td>
</tr>

<c:forEach var="tm" items="${pm.result}" varStatus="status">
<tr>
    <td align="center" colspan="1" width="10%">
        ${status.index+1}
    </td>
    <td align="center" colspan="1" width="25%">
        <a href="javascript:openWindow('${tm.applyNum}','${tm.classificationNum}')" style="cursor:hand;" >
            <c:if test="${!empty applicantNameEn}">${tm.applicantNameEn}</c:if>
            <c:if test="${!empty applicantNameZh}">${tm.applicantNameZh}</c:if>
            <c:if test="${!empty trademarkName}">${tm.trademarkName}</c:if>
        </a>
    </td>
</tr>
</c:forEach>
<tr>
	<td align="center" colspan="2">
		查询到的页数共：${pm.maxPage}页；
		当前是第${pm.curPage}页
	</td>
</tr>
<tr>
	<td align="center" colspan="2">
		<div id="page2" class="yahoo2">
		</div>
		<script type="text/javascript">
			$("#page2").html(fenyeComment("${pm.maxPage}","${pm.curPage}","${ctx}/queryResultList",
					"trademarkName=${trademarkName}&applicantNameZh=${applicantNameZh}&applicantNameEn=${applicantNameEn}"+
							"&selectTN=${type}&selectCHPN=${type}&selectENGPN=${type}"));
		</script>
	</td>
</tr>
<tr><td align="center" colspan="2"><font color="red">仅供参考，无任何法律效力，请核实后使用</font></td></tr>
<tr>
    <td width="99%" colspan="2" align="center">
        <input type="button" value=" 打 印 " title=" 打 印 "  onclick="window.print()">
        &nbsp;&nbsp;&nbsp;&nbsp;
        <input type="button" value=" 关 闭 " title=" 关 闭 " name="B1" onclick="window.close()">
    </td>
</tr>

</tbody></table>
</form>
</td>
</tr></tbody></table>
</body>
</html>

