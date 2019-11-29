<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<link href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" rel="stylesheet">
<title>CreateDestination画面</title>
</head>
<body>

	<div id="header">
		<p>EC-SITE</p>
	</div>

	<div id="main">

		<div id="top">
			<p>宛先情報作成画面</p>
		</div>
		<s:if test="familyNameErrorMessageList != null && familyNameErrorMessageList.size() > 0">
			<div class="error">
				<div class="error-message">
					<s:iterator value="familyNameErrorMessageList"><s:property /><br></s:iterator>
				</div>
			</div>
		</s:if>
		<s:if test="firstNameErrorMessageList != null && firstNameErrorMessageList.size() > 0">
			<div class="error">
				<div class="error-message">
					<s:iterator value="firstNameErrorMessageList"><s:property /><br></s:iterator>
				</div>
			</div>
		</s:if>
		<s:if test="familyNameKanaErrorMessageList != null && familyNameKanaErrorMessageList.size() > 0">
			<div class="error">
				<div class="error-message">
					<s:iterator value="familyNameKanaErrorMessageList"><s:property /><br></s:iterator>
				</div>
			</div>
		</s:if>
		<s:if test="firstNameKanaErrorMessageList != null && firstNameKanaErrorMessageList.size() > 0">
			<div class="error">
				<div class="error-message">
					<s:iterator value="firstNameKanaErrorMessageList"><s:property /><br></s:iterator>
				</div>
			</div>
		</s:if>
		<s:if test="addressErrorMessageList != null && addressErrorMessageList.size() > 0">
			<div class="error">
				<div class="error-message">
					<s:iterator value="addressErrorMessageList"><s:property /><br></s:iterator>
				</div>
			</div>
		</s:if>
		<s:if test="telNumberErrorMessageList != null && telNumberErrorMessageList.size() > 0">
			<div class="error">
				<div class="error-message">
					<s:iterator value="telNumberErrorMessageList"><s:property /><br></s:iterator>
				</div>
			</div>
		</s:if>
		<s:if test="emailErrorMessageList != null && emailErrorMessageList.size() > 0">
			<div class="error">
				<div class="error-message">
					<s:iterator value="emailErrorMessageList"><s:property /><br></s:iterator>
				</div>
			</div>
		</s:if>

		<div>
			<s:form action="CreateDestinationConfirmAction">
				<table>
					<tr>
						<td class="top-td left-td">姓</td>
						<td class="top-td right-td"><input type="text" name="familyName" placeholder="姓" value='<s:property value="#session.familyName"/>' /></td>
					</tr>
					<tr>
						<td class="left-td">名</td>
						<td class="right-td"><input type="text" name="firstName" placeholder="名" value='<s:property value="#session.firstName"/>' /></td>
					</tr>
					<tr>
						<td class="left-td">姓（ふりがな）</td>
						<td class="right-td"><input type="text" name="familyNameKana" placeholder="姓（ふりがな）" value='<s:property value="#session.familyNameKana"/>' /></td>
					</tr>
					<tr>
						<td class="left-td">名（ふりがな）</td>
						<td class="right-td"><input type="text" name="firstNameKana" placeholder="名（ふりがな）" value='<s:property value="#session.firstNameKana"/>'/></td>
					</tr>
					<tr>
						<td class="left-td">住所</td>
						<td class="right-td"><input type="text" name="address" placeholder="住所" value='<s:property value="#session.address"/>'/></td>
					</tr>
					<tr>
						<td class="left-td">電話番号</td>
						<td class="right-td"><input type="text" name="telNumber" placeholder="電話番号" value='<s:property value="#session.telNumber"/>'/></td>
					</tr>
					<tr>
						<td class="left-td">メールアドレス</td>
						<td class="right-td"><input type="text" name="email" placeholder="メールアドレス" value='<s:property value="#session.email"/>' /></td>
					</tr>
				</table>
				<s:submit value="宛先情報登録確認" class="btn-under btn-delete"/>
			</s:form>
		</div>


		<div class="btn-under-menu">
			<a href='<s:url action="CheckUserInfoAction" />' class="btn-under"><i class="fa fa-chevron-right"></i>ユーザー情報画面へ</a>
		</div>


	</div>

	<div id="footer"></div>

</body>
</html>