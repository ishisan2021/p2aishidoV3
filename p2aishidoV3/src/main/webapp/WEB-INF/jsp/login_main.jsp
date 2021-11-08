<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ユーザ管理UI</title>
</head>
<body>
<h1>登録済みユーザ一覧</h1>
<form action="UserListServlet" method="post">
    <button type="submit">登録済みユーザ一覧</button>
</form>

<h1>ユーザログイン</h1>
<form action="sentaku01" method="post">
<button type="submit" name="loginUser">ログイン画面へ</button>
</form>

<h1>ユーザ登録</h1>
<br>
<form action="sentaku02" method="post">
<button type="submit" name="upUser">ユーザー登録へ</button>
</form>

<h1>ユーザ削除</h1>
<br>
<form action="sentaku02" method="post">
<button type="submit" name="dell">ユーザ削除</button>
</form>

</body>
</html>