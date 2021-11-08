<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>p2aquiz_login</title>
</head>
<body>
<h1>P2AQuiz</h1>
<form action="UserLoginServlet" method="post">
ユーザー名：<input type="text" name="userid"><br>
パスワード：<input type="password" name="password"><br>
<input type="submit" value="ログイン">
</form>

<%
    String error = (String)request.getAttribute("error");
    if (error != null) {
%>
    <p style="color:red; font-size: larger;"><%= error %></p>
<%   } %>
<br>

<br>
<form action="sentaku01" method="post">
<button type="submit" name="upUser">ユーザー登録へ</button>
</form>
<br>
<br>


<form action="sentaku03" method="get">
<button type="submit" name="kanri">管理者画面へ</button>
</form>
<br>
<br>


<a href="index.html">入口へ</a>
</body>
</html>