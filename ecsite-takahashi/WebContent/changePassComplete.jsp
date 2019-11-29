<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<link href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" rel="stylesheet">
<title>ChangePassComplete画面</title>
<script type="text/javascript">
	window.onload=function(){
		var form=document.getElementById('form');
		setTimeout(function(){form.submit()},3000);
	}
</script>
</head>
<body>

	<div id="header">
		<p>EC-SITE</p>
	</div>

	<div id="main">

		<div id="top">
			<p>パスワード再設定完了画面</p>
		</div>

		<p class="introduction">パスワードが変更されました。<br>3秒後にログイン画面に遷移します。</p>
		<s:form id="form" action="LogoutAction">
		</s:form>

	</div>

	<div id="footer"></div>


</body>
</html>