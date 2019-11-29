<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>Home画面</title>
</head>
<body>

	<div id="header">
		<p>EC-SITE</p>
	</div>

	<div id="main">

		<div id="top">
			<p><s:property value="session.loginUser.loginId" />さんのマイページ</p>
		</div>

		<div class="menu">
			<a href='<s:url action="SearchItemAction" />' class="btn-menu"><span>商品一覧</span></a>
		</div>
		<div class="menu">
			<a href='<s:url action="BuyItemHistoryAction" />' class="btn-menu"><span>購入履歴</span></a>
		</div>
		<div class="menu">
			<a href='<s:url action="CheckUserInfoAction" />' class="btn-menu"><span>ユーザー情報</span></a>
		</div>
		<div class="menu">
			<a href='<s:url action="LogoutAction" />' class="btn-menu"><span>ログアウト</span></a>
		</div>

	</div>



</body>
</html>