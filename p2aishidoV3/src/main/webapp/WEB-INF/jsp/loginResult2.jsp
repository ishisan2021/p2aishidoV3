<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="logintest03.UserDto" %>
<%
// セッションスコープからユーザー情報を取得
UserDto loginUser = (UserDto) session.getAttribute("loginUser");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>p2aquiz_sentaku</title>
</head>
</head>
<body>
<h1>P2AQuiz_選択</h1>
<%  if(loginUser != null) { %>
<p><%= loginUser.getUserid() %>さん</p>
<p><a href="Quizishi2">QuizIshido_verへ</a></p>
<br>
<br>
<p><a href="Logout">ログアウト</a></p>

<% } else { %>
<p>ログインに失敗しました</p>
<a href="index.html">入口へ</a>
<%  } %>
</body>
</html>