<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<link href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<title>Cart画面</title>
</head>
<body>

	<div id="header">
		<p>EC-SITE</p>
	</div>

	<div id="main">
		<div id="top">
			<p>カート画面</p>
		</div>


		<s:if test="errorMsg2 == null">
			<s:if test="errorMsg != null">
				<p><s:property value="errorMsg"/></p>
			</s:if>
			<s:form action="DeleteCartAction">
				<table>
					<tr>
						<th><input type="checkbox" id="all"></th>
						<th>商品名</th>
						<th>ふりがな</th>
						<th>商品画像</th>
						<th>価格</th>
						<th>発売元</th>
						<th>発売日</th>
						<th>購入個数</th>
						<th>合計金額</th>
					</tr>
					<s:iterator value="cartInfoList">
						<tr>
							<td><input type="checkbox" class="list" name="deleteList" value="<s:property value="id"/>"></td>
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
				<s:submit value="削除" class="btn-under btn-delete" />
				<span class="total-price">合計金額：<s:property value="cartTotalPrice"/></span>
			</s:form>
			<div class="btn-under-menu">
				<a href='<s:url action="PaymentAction" />' class="btn-under"><i class="fa fa-chevron-right"></i>決済へ進む</a>
	    	</div>
		</s:if>
		<s:else>
			<p class="introduction">商品情報がありません。</p>
		</s:else>
		<div class="btn-under-menu">
			<a href='<s:url action="SearchItemAction" />' class="btn-under"><i class="fa fa-chevron-right"></i>買い物を続ける</a>
	   	</div>
	</div>

	<div id="footer"></div>

<script src="js/script.js"></script>
</body>
</html>