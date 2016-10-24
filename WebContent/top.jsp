<%@page import="at.danicoz.user.po.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>普通用户</title>
<link href="css/css.css" rel="stylesheet" type="text/css">
</head>
<script type="text/JavaScript" src="js/common.js"></script>

<%
User user = (User)session.getAttribute("user");
%>

<body class="topbody">
<form action="" method="get">
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="1411" colspan="2" background="images/ny_top_img_bg.gif"><img src="images/ny_top_img.gif" width="650" height="108"></td>
    </tr>
</table>
<table width="100%" border="0" cellspacing="0">
  <tr>
    <td width="75" height="25" bgcolor="#deedf8"></td>
    <td width="1122" align="left" valign="top" bgcolor="#deedf8"><span class="text_cray1">当前位置: 所有用户管理</span></td>
    <td width="140" valign="top" bgcolor="#deedf8" class="text_cray1">
    <marquee behavior="scroll" direction="right">欢迎您<%= user.getUsername() %></marquee></td>
    <td width="64" align="left" valign="top" bgcolor="#deedf8"><a href="Logout" target="_blank" class="cray">退出</a></td>
  </tr>
</table>

</form>

</body>
</html>