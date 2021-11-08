<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ログインフォーム</title>

</head>
<body>
<h1>ユーザ登録</h1>
<form action="UserRegServlet" method="post">
 ID<input type="text" name="userid"><br>
 パスワード<input type="password" name="password"><br>
<input type="submit" value="登録">

</form>
<%
    String error = (String)request.getAttribute("error");
    if (error != null) {
%>
    <p style="color:red; font-size: larger;"><%= error %></p>
<%   } %>
<br>

<br>
<br>

<a href="index.html">入口へ</a>
</form>
</body>
</html>