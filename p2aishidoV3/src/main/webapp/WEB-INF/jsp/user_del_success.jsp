<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ユーザ削除成功</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/login.css">
</head>
<body>
<h1>ユーザ削除成功</h1>

<%
    String username = (String)request.getAttribute("username");
    if (username != null) {
%>
    <p style="color:blue; font-size: larger;"><%= username %>さんの登録を削除しました。</p>
<%   } %>
<br>
<br>

<form action="sentaku02" method="post">
<button type="submit" name="admain">管理画面へ</button>
</form>

</body>
</html>