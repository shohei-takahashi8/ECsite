<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>UserDetail画面</title>
</head>
<body>

	<div id="header"></div>

	<div id="main">
		<div id="top">
			<p>UserInfo</p>
		</div>
		<div>
			<h3>ユーザー情報詳細は以下になります。</h3>
			<table border="1">
				<tr>
					<th>ID</th>
					<th>ログインID</th>
					<th>パスワード</th>
					<th>ユーザー名</th>
					<th>入稿日</th>
					<th>更新日</th>
					<th>ユーザータイプ</th>
				</tr>
			<s:iterator value="userInfo">
				<tr>
					<td><s:property value="id" /></td>
					<td><s:property value="loginId" /></td>
					<td><s:property value="loginPassword" /></td>
					<td><s:property value="userName" /></td>
					<td><s:property value="insert_date" /></td>
					<td><s:property value="update_date" /></td>
					<td><s:property value="admin_flg" /></td>
				</tr>
			</s:iterator>
			</table>
		</div>

		<s:url id="url" action="UserDeleteConfirmAction">
			<s:param name="id"><s:property value="id"/></s:param>
		</s:url>
		<s:a href="%{url}">削除</s:a>

		<div id="text-right">
			<p>一覧へ戻る場合は<a href='<s:url action="UserListAction"/>'>こちら</a></p>
		</div>

	</div>

	<div id="footer"></div>


</body>
</html>