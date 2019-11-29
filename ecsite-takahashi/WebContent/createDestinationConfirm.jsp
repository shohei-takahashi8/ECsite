<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<link href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" rel="stylesheet">
<title>CreateDestinationConfirm画面</title>
</head>
<body>

	<div id="header">
		<p>EC-SITE</p>
	</div>

	<div id="main">

		<div id="top">
			<p>宛先情報確認画面</p>
		</div>

		<div>
			<s:form action="CreateDestinationCompleteAction">
				<table>
					<tr>
						<td class="top-td left-td">姓</td>
						<td class="top-td right-td"><s:property value="familyName" escape="false" /></td>
					</tr>
					<tr>
						<td class="left-td">名</td>
						<td class="right-td"><s:property value="firstName" escape="false" /></td>
					</tr>
					<tr>
						<td class="left-td">姓（ふりがな）</td>
						<td class="right-td"><s:property value="familyNameKana" escape="false" /></td>
					</tr>
					<tr>
						<td class="left-td">名（ふりがな）</td>
						<td class="right-td"><s:property value="firstNameKana" escape="false" /></td>
					</tr>
					<tr>
						<td class="left-td">住所</td>
						<td class="right-td"><s:property value="address" escape="false" /></td>
					</tr>
					<tr>
						<td class="left-td">電話番号</td>
						<td class="right-td"><s:property value="telNumber" escape="false" /></td>
					</tr>
					<tr>
						<td class="left-td">メールアドレス</td>
						<td class="right-td"><s:property value="email" escape="false" /></td>
					</tr>
				</table>

				<s:submit value="登録" class="btn-under btn-delete"/>
			</s:form>
		</div>


		<div class="btn-under-menu">
			<a href='<s:url action="CreateDestinationAction" />' class="btn-under"><i class="fa fa-chevron-right"></i>宛先情報作成画面へ戻る</a>
		</div>


	</div>

	<div id="footer"></div>

</body>
</html>