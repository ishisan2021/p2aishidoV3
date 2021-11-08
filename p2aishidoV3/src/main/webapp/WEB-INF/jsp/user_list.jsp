<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="logintest03.UserDto" %>
<% ArrayList<UserDto> list = (ArrayList<UserDto>)request.getAttribute("list"); %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登録済みユーザ一覧</title>

</head>
<body>
    <h1>登録済みユーザ一覧</h1>
    <table>
        <tr><th>登録番号</th><th>ユーザID</th><th>パスワード</th></tr>
        <% for (UserDto ud: list) { %>
        <tr>
        <td><%= ud.getNo() %></td>
        <td><%= ud.getUserid() %></td>
        <td><%= ud.getPassword() %></td>
        </tr>
        <% } %>
    </table>
    <br>
    <hr>
<form action="sentaku02" method="post">
<button type="submit" name="admain">管理画面へ</button>
</form>
  
</body>
</html>