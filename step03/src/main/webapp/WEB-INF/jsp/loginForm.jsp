<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main</title>
</head>
<link rel="stylesheet" type="text/css" href="/css/common.css" />
</head>
<body>
<a href="/"><img src="/img/logo.png"></a>
<h3>main page</h3>
<!-- joinForm.jsp -->
<a href="joinForm">회원가입</a>
<!-- loginForm.jsp -->
<a href="loginForm">로그인</a>

<h3>로그인페이지</h3>
<form action="login" method="post">
	<input type="text" name="memberId" autofocus="autofocus" required="required"/>
	<input type="password" name="memberPw" required="required" />
	<input type="submit" value="로그인">
</form>
<h3>로그인페이지[action="login/param", name="id", name="pw""]</h3>
<form action="login/param" method="post">
	<input type="text" name="id" autofocus="autofocus" required="required"/>
	<input type="password" name="pw" required="required" />
	<input type="submit" value="로그인">
</form>
<h3>로그인페이지[action="login/null", name="aaa", name="bbb"]</h3>
<form action="login/null" method="post">
	<input type="text" name="aaa" autofocus="autofocus" required="required"/>
	<input type="password" name="bbb" required="required" />
	<input type="submit" value="로그인">
</form>
</body>
</html>