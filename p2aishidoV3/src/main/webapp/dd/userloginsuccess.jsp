<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="logintest03.UserDto" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ユーザログイン成功</title>
</head>
<body>
<h1>ユーザログイン成功</h1>
<hr>
<%
String username = (String)request.getAttribute("username");
   if (username != null) {
%>
   <p style="color:blue; font-size: larger;">ようこそ<%= username %>さん！</p>
<% } %>
<br>
<hr>
<form action="login_main.jsp" method="post">
    <button type="submit"><pre><big>戻る</big></pre></button>
</form>
</body>
</html>