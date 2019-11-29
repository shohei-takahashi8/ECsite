<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>UserDeleteConfirm画面</title>
</head>
<body>

	<div id="header"></div>

	<div id="main">
		<div id="top"><h2>ユーザー情報削除確認画面</h2></div>
		<h2>ログインID[<s:property value="currentLoginId"/>]のユーザーを削除します。よろしいですか？</h2>

		<s:url id="url" action="UserDeleteCompleteAction">
			<s:param name="id"><s:property value="id"/></s:param>
		</s:url>
		<s:a href="%{url}">OK</s:a>

		<s:url id="url" action="UserDetailsAction">
			<s:param name="id"><s:property value="id"/></s:param>
		</s:url>
		<s:a href="%{url}">キャンセル</s:a>

	</div>


	<div id="footer"></div>

</body>
</html>