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

</head>
<body>

<div id="header">
    <div class="logo"><a href="" target="_self"><img src="${ctx}/matter/images/logo1.png"  alt="" /></a></div>
    <span class="la"><a href="#" target="_blank">English</a></span>
    <div class="ad">
        <object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" width="465" height="59" id="FlashID" title="ad">
            <param name="movie" value="images/ad.swf" />
            <param name="quality" value="high" />
            <param name="wmode" value="opaque" />
            <param name="swfversion" value="15.0.0.0" />
            <!-- 此 param 标签提示使用 Flash Player 6.0 r65 和更高版本的用户下载最新版本的 Flash Player。如果您不想让用户看到该提示，请将其删除。 -->
            <!-- <param name="expressinstall" value="Scripts/expressInstall.swf" />-->
            <!-- 下一个对象标签用于非 IE 浏览器。所以使用 IECC 将其从 IE 隐藏。 -->
            <!--[if !IE]>-->
            <object type="application/x-shockwave-flash" data="${ctx}/matter/images/ad.swf" width="465" height="59">
                <!--<![endif]-->
                <param name="quality" value="high" />
                <param name="wmode" value="opaque" />
                <param name="swfversion" value="15.0.0.0" />
                <!--<param name="expressinstall" value="Scripts/expressInstall.swf" />-->
                <!-- 浏览器将以下替代内容显示给使用 Flash Player 6.0 和更低版本的用户。 -->
                <div>
                    <h4>此页面上的内容需要较新版本的 Adobe Flash Player。</h4>
                    <p><a href="http://www.adobe.com/go/getflashplayer"><img src="http://www.adobe.com/images/shared/download_buttons/get_flash_player.gif" alt="获取 Adobe Flash Player" width="112" height="33" /></a></p>
                </div>
                <!--[if !IE]>-->
            </object>
            <!--<![endif]-->
        </object>
    </div>

    <div class="clear"></div>
</div>
<div class="nav">
    <ul>
        <li><a href="${ctx}/errorpage.jsp" >首页</a></li>
        <li><a href="${ctx}/errorpage.jsp" > 商标近似查询</a></li>
        <li><a href="${ctx}/index">商标综合查询</a></li>
        <li><a href="${ctx}/errorpage.jsp" >商标状态查询</a></li>
        <li><a href="${ctx}/errorpage.jsp" >错误信息反馈</a></li>
        <li><a href="${ctx}/errorpage.jsp" >操作指南</a></li>
    </ul>
</div>

<!--end header -->
<div id="main" style="height: 361px">
    <div class="main-title"><img src="${ctx}/matter/images/1_0.jpg" /></div>
    <div style="margin-top: 100px;padding-left: 74px;padding-right: 74px">
        Sorry! a server error. you visit the page does not exist.
        We will fix as soon as possible.
        To give you the inconvenience, please understand.
    </div>
</div>

<div id="footer">
    <p> “商标查询网”是国家工商行政管理总局商标局主办的在线查询商标注册信息的网站，免费向公众开通商标网上查询。
        网址：http://www.xxx.com
        中华人民共和国国家工商行政管理总局 国家工商总局经济信息中心技术支持</p>
</div>

</body>
</html>
