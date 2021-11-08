<%-- リスト10-6の状態 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>p2aquiz_login</title>
</head>
<body>
<h1>P2AQuiz</h1>
<form action="UserLoginServlet" method="post">
ユーザー名：<input type="text" name="userid"><br>
パスワード：<input type="password" name="password"><br>
<input type="submit" value="ログイン">
</form>
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