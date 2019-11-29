<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<link href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" rel="stylesheet">
<title>CreateDestinationComplete画面</title>
</head>
<body>

	<div id="header">
		<p>EC-SITE</p>
	</div>

	<div id="main">
		<div id="top">

		</div>
		<p class="introduction">宛先情報登録が完了しました</p>

		<div class="btn-under-menu">
			<a href='<s:url action="PaymentAction" />' class="btn-under"><i class="fa fa-chevron-right"></i>決済確認画面へ</a>
	    </div>
		<div class="btn-under-menu">
			<a href='<s:url action="GoHomeAction" />' class="btn-under"><i class="fa fa-chevron-right"></i>ホーム画面へ</a>
	    </div>

	</div>


</body>
</html>