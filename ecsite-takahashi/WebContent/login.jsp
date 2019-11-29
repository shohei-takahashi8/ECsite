<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>Login画面</title>
</head>
<body>


	<div>
		<div class="form-wrapper">
			<h1>Login</h1>
			<s:form action="LoginAction">
				<div class="form-item">
					<label for="ユーザーID"></label>
					<input type="text" name="loginId" placeholder="ユーザーID" />
				</div>
				<div class="form-item">
					<label for="password"></label>
					<input type="password" name="password" placeholder="パスワード" />
				</div>
				<div class="button-panel">
					<input type="submit" class="button" value="ログイン" />
				</div>
			</s:form>
			<div class="form-footer">
				<p><a href='<s:url action="CreateUserAction"/>'>新規登録</a></p>
			</div>
		</div>
	</div>



</body>
</html>