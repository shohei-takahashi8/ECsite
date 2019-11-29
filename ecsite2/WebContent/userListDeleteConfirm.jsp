<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>UserListDeleteConfirm画面</title>
</head>
<body>

	<div id="header"></div>

	<div id="main">

		<div id="top"><h2>管理者以外のユーザーを削除します。よろしいですか？</h2></div>

		<s:form action="UserListDeleteCompleteAction">
			<s:submit value="OK"/>
		</s:form>
		<s:form action="UserListAction">
			<s:submit value="キャンセル"/>
		</s:form>
	</div>

</body>
</html>