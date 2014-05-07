<%--
  Created by IntelliJ IDEA.
  User: hejian
  Date: 14-5-5
  Time: 下午4:51
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
</head>
<body>
	<table class="detail-outer" cellSpacing="0" cellPadding="3" >
	<tr>
		<td >
			<table class="detail-middle" cellspacing="0" cellpadding="0" >
				<tr>
					<td  colspan="4">
						<strong>商标的详细信息</strong>
					</td>
				</tr>

				<tr>
					<td colspan="4">
						<table  class="detail-inner1">
							<tr>
								<td >
									注册号/申请号 </td>
								<td  >
									${tm.applyNum}</td>
								<td >
									国际分类号 </td>
								<td  >
									${tm.classificationNum}</td>
								<td  >
									申请日期</td>
								<td>
									<fmt:formatDate value="${tm.applyDate}" pattern="yyyy-MM-dd"></fmt:formatDate></td>
							<tr>
						</table>
					</td>
				</tr>
				<tr>
					<td  >
						申请人名称(中文)</td>
					<td  >
						${tm.applicantNameZh}</td>
					<td  >
						申请人地址(中文)</td>
					<td  >
                        ${tm.applicantAddressZh}</td>
				</tr>
				<tr>
					<td  >
						申请人名称(英文)</td>
					<td  >
                        ${tm.applicantNameEn}
					</td>
					<td  >
						申请人地址(英文)</td>
					<td  >
                        ${tm.applicantAddressEn}
					</td>
				</tr>
				<tr>
					<td colspan="4" >
						<table class="detail-inner2">
							<tr>
								<td class="detail-inner2-w1" >
									商标图像</td>
								<td  class="detail-inner2-w2">
									<a href="" target="_blank">
										<img  src="${tm.imgPath}"alt="商标名图像">
									</a>
								</td>
								<td class="detail-inner2-w1">
									商品 ／ 服务列表</td>
								<td class="detail-inner2-w3">
                                    <c:if test="${fn:length(ht:delHTMLTag(tm.servicesList))>18 }" >
                                        ${fn:substring(ht:delHTMLTag(tm.servicesList),0,18) }...
                                    </c:if>
                                    <c:if test="${fn:length(ht:delHTMLTag(tm.servicesList))<=18 }" >
                                        ${ht:delHTMLTag(tm.servicesList)}
                                    </c:if>
									<br >
									<a href="#" target="_blank">
										<span class="font-color">查看详细信息 ...</span></a>

								</td>
								<td class="detail-inner2-w1">
									类似群</td>
								<td  class="detail-inner2-w1">

									${tm.similarGroup}

								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td  >
						初审公告期号</td>
					<td  >
                        ${tm.firstNoticeNum}
				    </td>
					<td  >
						注册公告期号</td>
					<td  >
                        ${tm.registerNoticeNum}
				    </td>

				</tr>
				<tr>
					<td  >
						初审公告日期</td>
					<td  >
                        <fmt:formatDate value="${tm.firstNoticeDate}" pattern="yyyy-MM-dd"></fmt:formatDate>
					</td>
					<td  >
						注册公告日期</td>
					<td  >
					    <fmt:formatDate value="${tm.registerNoticeDate}" pattern="yyyy-MM-dd"></fmt:formatDate>
                    </td>

				</tr>
				<tr>
					<td   >
						专用权期限</td>
					<td colspan=2  >

						<fmt:formatDate value="${tm.exclusiveRightStartDate}" pattern="yyyy-MM-dd"/>    至    <fmt:formatDate value="${tm.exclusiveRightEndDate}" pattern="yyyy-MM-dd"/></td>
					<td>
						年
					</td>

				</tr>
				<tr>
					<td  >
						后期指定日期</td>
					<td  >
                        <fmt:formatDate value="${tm.afterNamedDate}" pattern="yyyy-MM-dd"></fmt:formatDate>
					</td>
					<td  >
						国际注册日期</td>
					<td  >
                        <fmt:formatDate value="${tm.internationalRegisterDate}" pattern="yyyy-MM-dd"></fmt:formatDate>
					</td>

				</tr>

				<tr>
					<td >
						优先权日期</td>
					<td >
                        <c:if test="${empty tm.priorityDate}">无</c:if>
                        <c:if test="${!empty tm.priorityDate}">
                            <fmt:formatDate value="${tm.priorityDate}" pattern="yyyy-MM-dd"></fmt:formatDate>
                        </c:if>
					</td>
					<td >
						代理人名称</td>
					<td  >
					    ${tm.agentName}
                    </td>

				</tr>
				<tr>
					<td >
						指定颜色</td>
					<td  >&nbsp;
                        ${tm.specifyColor}
					</td>
					<td  >
						商标类型</td>
					<td  >
                           ${tm.trademarkType}
				    </td>

				</tr>
				<tr>
					<td>
						是否共有商标</td>
					<td  >
                        <c:if test="${tm.share==true}">是</c:if>
                        <c:if test="${tm.share==false}">否</c:if>

					</td>
					<td  >
						备注</td>
					<td  >
							<span class="font-color">
                                ${tm.remarks}
							</span>
					</td>

				</tr>
				<tr>
					<td  >
						商标流程

					</td>
					<td colspan=3  >
						<a  href="">
                            ${tm.trademarkProcess}
						</a>
					</td>

				</tr>

			</table>
		</td>
	</tr>
	<tr>
		<td>


		</td>
	</tr>
	<tr><td><span class="font-color">仅供参考，无任何法律效力，请核实后使用</span></td></tr>
	<tr>
		<td >
			<input type="button"value=" 打 印 " title=" 打 印 " onclick="window.print()" >
			<input type="button"value=" 关 闭 " title=" 关 闭 " onclick="window.close()">
		</td>
	</tr>
	</table>




</body>
</html>
