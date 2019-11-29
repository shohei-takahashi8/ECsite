<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<link href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" rel="stylesheet">
<title>PaymentConfirm画面</title>
</head>
<body>

	<div id="header">
		<p>EC-SITE</p>
	</div>

	<div id="main">
		<div id="top">
			<p>決済確認画面</p>
		</div>
		<div class="buyItemInfo">
			<p>購入商品情報</p>
			<table>
				<tr>
					<th>商品名</th>
					<th>ふりがな</th>
					<th>商品画像</th>
					<th>価格</th>
					<th>発売元</th>
					<th>発売日</th>
					<th>購入個数</th>
					<th>合計金額</th>
				</tr>
				<s:iterator value="#session.cartInfo">
				<tr>
					<td><s:property value="itemName"/></td>
					<td><s:property value="itemNameKana"/></td>
					<td><img src="<s:property value="itemImage"/>" height="70" width="70"></td>
					<td><s:property value="price"/></td>
					<td><s:property value="company"/></td>
					<td><s:property value="releaseDate"/></td>
					<td><s:property value="itemCount"/></td>
					<td><s:property value="totalPrice"/></td>
				</tr>
				</s:iterator>
			</table>
			<span class="total-price">合計金額：<s:property value="#session.cartTotalPrice"/></span>
		</div>

		<s:if test="destinationInfoList.isEmpty()">
			<p class="error-message">商品購入の際は宛先情報を下記より登録してください</p>
			<div class="btn-under-menu">
				<a href='<s:url action="CreateDestinationAction" />' class="btn-under"><i class="fa fa-chevron-right"></i>宛先情報登録</a>
			</div>
		</s:if>
		<s:else>
			<s:form action="PaymentCompleteAction">
				<div class="destinationInfo">
					<p>宛先情報選択</p>
					<table class="destinationTable">
						<tr>
							<th>#</th>
							<th>姓</th>
							<th>名</th>
							<th>メールアドレス</th>
							<th>電話番号</th>
							<th>住所</th>
						</tr>
						<s:iterator value="destinationInfoList" status="st">
							<tr>
								<s:if test="#st.index == 0">
									<td><input type="radio" class="list" checked="checked" name="destinationId" value='<s:property value="id"/>'/></td>
								</s:if>
								<s:else>
									<td><input type="radio" class="list" name="destinationId" value='<s:property value="id"/>'/></td>
								</s:else>
								<td><s:property value="familyName"/></td>
								<td><s:property value="firstName" /></td>
								<td><s:property value="email" /></td>
								<td><s:property value="telNumber" /></td>
								<td><s:property value="address" /></td>
							</tr>
						</s:iterator>
					</table>
					<s:submit value="決済完了" class="btn-under btn-delete"/>
				</div>
			</s:form>
		</s:else>
		<div class="btn-under-menu">
			<a href='<s:url action="GoCartAction" />' class="btn-under"><i class="fa fa-chevron-right"></i>カート画面へ戻る</a>
	    </div>

	</div>

	<div id="footer"></div>

</body>
</html>