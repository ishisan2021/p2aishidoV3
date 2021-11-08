<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ユーザ登録成功</title>
</head>
<body>
<h1>ユーザ登録成功</h1>

<%
    String username = (String)request.getAttribute("username");
    if (username != null) {
%>
    <p style="color:blue; font-size: larger;"><%= username %>さんの登録が完了しました。</p>
<%   } %>
<br>

<form action="sentaku01" method="post">

<button type="submit" name="loginUser">ログイン画面へ</button>

</form>

<br>
<br>
</body>
</html>