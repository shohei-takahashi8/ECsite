<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<link href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" rel="stylesheet">
<title>UserInfo画面</title>
</head>
<body>

	<div id="header">
		<p>EC-SITE</p>
	</div>

	<div id="main">
		<div id="top">
			<p><s:property value="session.loginUser.loginId" />さんのユーザー情報</p>
		</div>

		<table>
			<tr>
				<td class="top-td left-td">ログインID</td>
				<td class="top-td right-td"><s:property value="session.loginUser.loginId" /></td>
			</tr>
			<tr>
				<td class="left-td">姓</td>
				<td class="right-td"><s:property value="session.loginUser.familyName" /></td>
			</tr>
			<tr>
				<td class="left-td">名</td>
				<td class="right-td"><s:property value="session.loginUser.firstName" /></td>
			</tr>
			<tr>
				<td class="left-td">ふりがな</td>
				<td class="right-td"><s:property value="session.loginUser.familyNameKana" /> <s:property value="session.loginUser.firstNameKana" /></td>
			</tr>
			<tr>
				<td class="left-td">性別</td>
				<td class="right-td"><s:property value="gender"/></td>
			</tr>
			<tr>
				<td class="left-td">メールアドレス</td>
				<td class="right-td"><s:property value="session.loginUser.email"/></td>
			</tr>
		</table>

		<div class="btn-under-menu">
			<a href='<s:url action="ChangePassAction" />' class="btn-under"><i class="fa fa-chevron-right"></i>パスワード変更</a>
		</div>
		<div class="btn-under-menu">
			<a href='<s:url action="CreateDestinationAction" />' class="btn-under"><i class="fa fa-chevron-right"></i>宛先情報登録</a>
		</div>
		<div class="btn-under-menu">
			<a href='<s:url action="GoHomeAction" />' class="btn-under"><i class="fa fa-chevron-right"></i>ホーム画面へ</a>
		</div>


	</div>

	<div id="footer"></div>

</body>
</html>