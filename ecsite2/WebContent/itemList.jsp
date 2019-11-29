<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>ItemList画面</title>
</head>
<body>

	<div id="header"></div>

	<div id="main">
		<div id="top">
			<p>ItemList</p>
		</div>
		<div>
				<h3>商品情報一覧は以下になります。</h3>
				<table border="1">
					<tr>
						<th>ID</th>
						<th>商品名</th>
						<th>商品価格</th>
						<th>在庫</th>
						<th>入稿日</th>
						<th>更新日</th>
						<th>リンク</th>
					</tr>
				<s:iterator value="itemList">
					<tr>
						<td><s:property value="id" /></td>
						<td><s:property value="itemName" /></td>
						<td><s:property value="itemPrice" /><span>円</span></td>
						<td><s:property value="stock" /><span>個</span></td>
						<td><s:property value="insert_date" /></td>
						<td><s:property value="update_date" /></td>
						<td>
							<s:url id="url" action="ItemDetailsAction">
								<s:param name="id"><s:property value="id"/></s:param>
							</s:url>
							<s:a href="%{url}"><s:property value="id"/></s:a>
						</td>
					</tr>
				</s:iterator>
				</table>
			<s:form action="ItemListDeleteConfirmAction">
				<s:submit value="削除"/>
			</s:form>

			<div id="text-right">
				<p>Homeへ戻る場合は<a href='<s:url action="GoHomeAction"/>'>こちら</a></p>
			</div>
		</div>
	</div>

	<div id="footer"></div>

</body>
</html>