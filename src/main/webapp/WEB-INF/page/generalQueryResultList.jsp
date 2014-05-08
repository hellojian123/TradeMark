<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/taglibs.jsp"%>

<html>
<head>
    <meta http-equiv="Content-Language" content="zh-cn">
    <meta http-equiv="Content-Type" content="text/html; charset=gbk">
    <meta content="MSHTML 6.00.2800.1400" name="GENERATOR">
    <title>中国商标网</title>
    <link href="${ctx}/matter/css/categoriesHelpStyle.css" type="text/css" rel="stylesheet">
    <script language="JavaScript">

    </script>
</head>

<body leftmargin="0" topmargin="0" marginheight="0" marginwidth="0" >
<table align="center" border="0" width="610" cellpadding="0" cellspacing="1" height="100%">
<tbody><tr>
<td align="center">
<form name="ResForm">

<input type="hidden" name="SelectContent" value="申请人名称（英文）是：f;选择的是:前包含">
<input type="hidden" name="RegNO" value="">
<input type="hidden" name="IntCls" value="">
<input type="hidden" name="TradName" value="">
<input type="hidden" name="selectTN" value="0">
<input type="hidden" name="PeoNameCH" value="">
<input type="hidden" name="selectCHPN" value="0">
<input type="hidden" name="PeoNameENG" value="f">
<input type="hidden" name="selectENGPN" value="0">
<input type="hidden" name="codeShow" value="4zac">
<input type="hidden" name="path" value="/trssearch">

<table border="0" width="600" cellpadding="0" cellspacing="1" class="tbg2">

<tbody><tr>
    <td height="17" colspan="2" align="center">查询结果如下（点击申请人名称可以得到具体信息）
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
        查询到的页数共：${pm.maxPage}页

        <font color="red">1</font>

        <a onclick="connect(1)" target="_self" style="cursor:hand;">
            2</a>

        <a onclick="connect(2)" target="_self" style="cursor:hand;">
            3</a>

        <a onclick="connect(3)" target="_self" style="cursor:hand;">
            4</a>

        <a onclick="connect(4)" target="_self" style="cursor:hand;">
            5</a>

        <a onclick="connect(5)" target="_self" style="cursor:hand;">
            6</a>

        <a onclick="connect(6)" target="_self" style="cursor:hand;">
            7</a>

        <a onclick="connect(7)" target="_self" style="cursor:hand;">
            8</a>

        <a onclick="connect(8)" target="_self" style="cursor:hand;">
            9</a>

        <a onclick="connect(9)" target="_self" style="cursor:hand;">
            10</a>

    </td>
</tr>
<tr>
    <td align="center" colspan="2">
        当前是第1页

        &nbsp;&nbsp;
        <font color="red">首  页</font>
        &nbsp;&nbsp;
        <font color="red">前一页</font>


        &nbsp;&nbsp;
        <a onclick="connect(1)" target="_self" style="cursor:hand;">后一页</a>
        &nbsp;&nbsp;
        <a onclick="connect(727)" target="_self" style="cursor:hand;">末 页</a>

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
        <a onclick="javascript:window.open('')" style="cursor:hand;">
            <c:if test="${!empty applicantNameEn}">${tm.applicantNameEn}</c:if>
            <c:if test="${!empty applicantNameZh}">${tm.applicantNameZh}</c:if>
            <c:if test="${!empty trademarkName}">${tm.trademarkName}</c:if>
        </a>
    </td>
</tr>
</c:forEach>

<tr>
    <td align="center" colspan="2">
        查询到的页数共：${pm.maxPage}页

        <font color="red">1</font>

        <a onclick="connect(1)" target="_self" style="cursor:hand;">
            2</a>

        <a onclick="connect(2)" target="_self" style="cursor:hand;">
            3</a>
    </td>
</tr>
<tr>
    <td align="center" colspan="2">
        当前是第1页

        &nbsp;&nbsp;
        <font color="red">首  页</font>
        &nbsp;&nbsp;
        <font color="red">前一页</font>


        &nbsp;&nbsp;
        <a onclick="connect(1)" target="_self" style="cursor:hand;">后一页</a>
        &nbsp;&nbsp;
        <a onclick="connect(727)" target="_self" style="cursor:hand;">末 页</a>

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



</body></html>