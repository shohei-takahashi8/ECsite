<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<link href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" rel="stylesheet">
<title>ItemDetail画面</title>
</head>
<body>

	<div id="header">
		<p>EC-SITE</p>
	</div>

	<div id="main">

		<div id="top">
			<p>商品詳細画面</p>
		</div>

		<div>
			<table class="itemDetailTable">
				<tr>
					<th>商品名</th>
					<th>ふりがな</th>
					<th>商品画像</th>
					<th>価格</th>
					<th>発売元</th>
					<th>発売日</th>
					<th>商品説明</th>
				</tr>
				<s:iterator value="itemDetailsList">
					<tr>
						<td><s:property value="productName"/></td>
						<td><s:property value="productNameKana"/></td>
						<td><img src="<s:property value="itemImage"/>" height="70" width="70"></td>
						<td><span>￥</span><s:property value="price"/></td>
						<td><s:property value="releaseCompany"/></td>
						<td><s:property value="releaseDate"/></td>
						<td class="itemDesc"><s:property value="productDesc"/></td>
					</tr>
				</s:iterator>
			</table>
		</div>

		<div class="reviewList">
			<h3>■レビュー一覧</h3>
			<s:iterator value="reviewList">
				<div class="review">
					<span>評価点</span><span class="star"><s:property value="star"/></span>
					<span class="reviewTitle"><s:property value="title"/></span>
					<span><s:property value="registDate"/></span><br>
					<span class="reviewer">By <s:property value="userId"/></span><br>
					<s:property value="review"/><br>
				</div>
			</s:iterator>
		</div>

		<div class="reviewInput">
			<h3>■カスタマーレビュー</h3>
			<s:form action="ReviewAction">
				<p>評価点（１～５点で評価してください）</p>
				<select name="point">
					<option value="1" selected="selected">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
				</select>
				<p>タイトル</p>
				<input type="text" name="title">
				<p>レビューを追加</p>
				<textarea rows="10" cols="60" name="review"></textarea>
				<s:if test="!errorMessageList.isEmpty()">
					<input type="hidden" value="<s:property value='productId'/>" name="productId"/>
					<p class="error-message-review"><s:iterator value="errorMessageList"><s:property /><br></s:iterator></p>
				</s:if>
				<s:else>
					<input type="hidden" value="<s:property value='id'/>" name="productId"/>
				</s:else>
				<input type="submit" value="投稿" class="btn-under btn-submit"/>
			</s:form>
		</div>

		<div class="btn-under-menu">
			<a href='<s:url action="SearchItemAction" />' class="btn-under"><i class="fa fa-chevron-right"></i>商品購入画面へ</a>
	   	</div>


	</div>

	<div id="footer"></div>

</body>
</html>