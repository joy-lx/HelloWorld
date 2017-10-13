<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@page import="com.cloudlife.util.*" %>
<%
   if(CheckMobile.check(request,response))
	   //response.sendRedirect("http://ys.vjero.cn/wap/html/index.html");
	   response.sendRedirect("http://www.yssh2017.com/ysproject/wap/html/index.html");
   else
		//response.sendRedirect("http://ys.vjero.cn/portal/html/index.html");
	   response.sendRedirect("http://www.yssh2017.com/ysproject/portal/html/index.html");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>云上生活官网</title>
</head>
<body>
您好，欢迎大家光临云上生活官网。<br><br>
</body>
</html>