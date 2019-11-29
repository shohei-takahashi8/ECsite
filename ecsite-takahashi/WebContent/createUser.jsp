<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<link href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" rel="stylesheet">
<title>CreateUser画面</title>
</head>
<body>

	<div id="header">
		<p>EC-SITE</p>
	</div>

	<div id="main">

		<div id="top">
			<p>ユーザー新規登録画面</p>
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
		<s:if test="emailErrorMessageList != null && emailErrorMessageList.size() > 0">
			<div class="error">
				<div class="error-message">
					<s:iterator value="emailErrorMessageList"><s:property /><br></s:iterator>
				</div>
			</div>
		</s:if>
		<s:if test="userIdErrorMessageList != null && userIdErrorMessageList.size() > 0">
			<div class="error">
				<div class="error-message">
					<s:iterator value="userIdErrorMessageList"><s:property /><br></s:iterator>
				</div>
			</div>
		</s:if>
		<s:if test="passwordErrorMessageList != null && passwordErrorMessageList.size() > 0">
			<div class="error">
				<div class="error-message">
					<s:iterator value="passwordErrorMessageList"><s:property /><br></s:iterator>
				</div>
			</div>
		</s:if>
		<s:if test="isExistsUserErrorMessage != null && !isExistsUserErrorMessage.isEmpty()">
			<div class="error">
				<div class="error-message">
					<s:iterator value="isExistsUserErrorMessage"><s:property /><br></s:iterator>
				</div>
			</div>
		</s:if>
		<s:if test="userIdDuplicateMessage != null">
			<div class="error">
				<div class="error-message">
					<s:iterator value="userIdDuplicateMessage"><s:property /><br></s:iterator>
				</div>
			</div>
		</s:if>


		<s:form action="CreateUserConfirmAction">
			<table class="user-table">
					<tr>
						<td class="user-table user-table-top"><label>ユーザーID：</label></td>
						<td class="user-table user-table-top"><input type="text" name="userId" value='<s:property value="#session.userId" />'/></td>
					</tr>
					<tr>
						<td class="user-table"><label>パスワード：</label></td>
						<td class="user-table"><input type="password" name="password" value='<s:property value="#session.password" />' /></td>
					</tr>
					<tr>
						<td class="user-table"><label>姓：</label>
						<td class="user-table"><input type="text" name="familyName" value='<s:property value="#session.familyName" />'/></td>
					</tr>
					<tr>
						<td class="user-table"><label>名：</label></td>
						<td class="user-table"><input type="text" name="firstName" value='<s:property value="#session.firstName" />'/></td>
					</tr>
					<tr>
						<td class="user-table"><label>姓（かな）：</label></td>
						<td class="user-table"><input type="text" name="familyNameKana" value='<s:property value="#session.familyNameKana" />'/></td>
					</tr>
					<tr>
						<td class="user-table"><label>名（かな）：</label></td>
						<td class="user-table"><input type="text" name="firstNameKana" value='<s:property value="#session.firstNameKana" />'/></td>
					</tr>
					<tr>
						<td class="user-table">性別：</td>
						<td class="user-table">
							<s:if test="#session.gender == 1">
								<label><input type="radio" name="gender" value="0">男</label>
								<label><input type="radio" name="gender" value="1" checked="checked">女</label>
							</s:if>
							<s:else>
								<label><input type="radio" name="gender" value="0" checked="checked">男</label>
								<label><input type="radio" name="gender" value="1">女</label>
							</s:else>
						</td>
					</tr>
					<tr>
						<td class="user-table"><label>メールアドレス：</label></td>
						<td class="user-table"><input type="text" name="email" value='<s:property value="#session.email" />'></td>
					</tr>
			</table>
			<s:submit value="確認画面へ" class="btn-under btn-create-user"/>
		</s:form>

		<div class="btn-under-menu">
			<a href='<s:url action="GoLoginAction" />' class="btn-under"><i class="fa fa-chevron-right"></i>ログイン画面へ</a>
	    </div>


	</div>


	<div id="footer"></div>

</body>
</html>