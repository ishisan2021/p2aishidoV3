<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ログインフォーム</title>

</head>
<body>
<h1>ユーザ削除</h1>
<form action="UserDelServlet" method="post">

ユーザー名：<input type="text" name="userid"><br>
パスワード：<input type="password" name="password"><br>
<input type="submit" value="削除">
</form>
<br>
<br>
<%
    String error = (String)request.getAttribute("error");
    if (error != null) {
%>
    <p style="color:red; font-size: larger;"><%= error %></p>
<%   } %>
<br>

<form action="sentaku02" method="post">
<button type="submit" name="admain">管理画面へ</button>
</form>
</body>
</html>