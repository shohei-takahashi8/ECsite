<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<link href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" rel="stylesheet">
<title>ChangePass画面</title>
</head>
<body>

	<div id="header">
		<p>EC-SITE</p>
	</div>

	<div id="main">

		<div id="top">
			<p>パスワード再設定画面</p>
		</div>

		<div>
			<s:form action="ChangePassCompleteAction">
				<table>
					<tr>
						<td class="top-td left-td">ログインID</td>
						<td class="top-td right-td"><s:property value="session.loginUser.loginId" /><input type="hidden" name="loginId" value='<s:property value="session.loginUser.loginId"/>' ></td>
					</tr>
					<tr>
						<td class="left-td">現在のパスワード</td>
						<td class="right-td"><input type="password" name="currentPass" placeholder="現在のパスワード" /></td>
					</tr>
					<tr>
						<td class="left-td">新しいパスワード</td>
						<td class="right-td"><input type="password" name="newPass" placeholder="新しいパスワード" /></td>
					</tr>
					<tr>
						<td class="left-td">新しいパスワード（再確認）</td>
						<td class="right-td"><input type="password" name="newPassConfirm" placeholder="新しいパスワード（再確認）"/></td>
					</tr>
				</table>

				<s:if test="passwordErrorMessageList != null && passwordErrorMessageList.size() > 0">
					<div class="error">
						<div class="error-message">
							<s:iterator value="passwordErrorMessageList"><s:property /><br></s:iterator>
						</div>
					</div>
				</s:if>
				<s:submit value="パスワード変更" class="btn-under btn-delete"/>
			</s:form>
		</div>


		<div class="btn-under-menu">
			<a href='<s:url action="CheckUserInfoAction" />' class="btn-under"><i class="fa fa-chevron-right"></i>ユーザー情報画面へ</a>
		</div>


	</div>

	<div id="footer"></div>

</body>
</html>