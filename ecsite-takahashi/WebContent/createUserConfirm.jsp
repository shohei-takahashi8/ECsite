<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<link href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" rel="stylesheet">
<title>CreateUserConfirm画面</title>
</head>
<body>

	<div id="header">
		<p>EC-SITE</p>
	</div>

	<div id="main">

		<div id="top">
			<p>ユーザー登録情報確認画面</p>
		</div>


		<s:form action="CreateUserCompleteAction">
			<table>
					<tr>
						<td class="user-table user-table-top"><label>ユーザーID：</label></td>
						<td class="user-table user-table-top"><s:property value="userId" escape="false" /></td>
					</tr>
					<tr>
						<td class="user-table"><label>パスワード：</label></td>
						<td class="user-table"><s:property value="password" escape="false"/></td>
					</tr>
					<tr>
						<td class="user-table"><label>姓：</label>
						<td class="user-table"><s:property value="familyName" escape="false" /></td>
					</tr>
					<tr>
						<td class="user-table"><label>名：</label></td>
						<td class="user-table"><s:property value="firstName" escape="false" /></td>
					</tr>
					<tr>
						<td class="user-table"><label>姓（かな）：</label></td>
						<td class="user-table"><s:property value="familyNameKana" escape="false" /></td>
					</tr>
					<tr>
						<td class="user-table"><label>名（かな）：</label></td>
						<td class="user-table"><s:property value="firstNameKana" escape="false" /></td>
					</tr>
					<tr>
						<td class="user-table">性別：</td>
						<td class="user-table"><s:property value="gender" escape="false" /></td>
					</tr>
					<tr>
						<td class="user-table"><label>メールアドレス：</label></td>
						<td class="user-table"><s:property value="email" escape="false" /></td>
					</tr>
			</table>
			<s:submit value="登録" class="btn-under btn-create-user"/>
		</s:form>

		<div class="btn-under-menu">
			<a href='<s:url action="CreateUserAction" />' class="btn-under"><i class="fa fa-chevron-right"></i>ユーザー作成画面へ戻る</a>
	    </div>

	</div>


	<div id="footer"></div>

</body>
</html>