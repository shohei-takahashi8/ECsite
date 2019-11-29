<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<link href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" rel="stylesheet">
<title>BuyItem画面</title>
</head>
<body>
	<div id="header">
		<p>EC-SITE</p>
	</div>

	<div id="main">
		<div id="top">
			<p>商品購入画面</p>
		</div>
		<div class="search">
			<s:form action="SearchItemAction">
				<input type="text" name="keywords" placeholder="検索ワード"/>
				<input type="submit" value="商品検索" class="btn-under btn-search"/>
			</s:form>
		</div>
		<s:if test="keywordsErrorMessageList != null && keywordsErrorMessageList.size() > 0">
			<div class="error">
				<div class="error-message">
					<s:iterator value="keywordsErrorMessageList"><s:property/><br></s:iterator>
				</div>
			</div>
		</s:if>
		<div>
			<table>
				<tr>
					<th>商品名</th>
					<th>価格</th>
					<th>商品画像</th>
					<th>希望購入個数</th>
					<th>商品詳細</th>
				</tr>
				<s:if test="!productInfoDTOList.isEmpty()">
					<s:iterator value="productInfoDTOList">
					<tr>
						<td><s:property value="productName" /></td>
						<td><span>￥</span><s:property value="price"/></td>
						<td><img src="<s:property value="itemImage"/>" width="100" height="100"></td>
						<td>
							<s:form action="AddCartAction">
								<select name="productCount">
									<option value="1" selected="selected">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
									<option value="5">5</option>
								</select>
								<input type="hidden" value="<s:property value="id"/>" name="productId">
								<button type="submit" class="btn-under btn-cart">カートへ</button>
							</s:form>
						</td>
						<td>
							<s:url id="url" action="ItemDetailsAction">
								<s:param name="id"><s:property value="id"/></s:param>
							</s:url>
							<s:a href="%{url}" class="btn-under">詳細画面</s:a>
						</td>
					</tr>
					</s:iterator>
				</s:if>
				<s:else>
					<div class="error-message">
						<p>該当する商品情報がありませんでした。</p>
					</div>
				</s:else>
			</table>
		</div>

		<div class="btn-under-menu">
			<a href='<s:url action="GoHomeAction" />' class="btn-under"><i class="fa fa-chevron-right"></i>ホーム画面へ</a>
	    </div>

	</div>


	<div id="footer"></div>
</body>
</html>