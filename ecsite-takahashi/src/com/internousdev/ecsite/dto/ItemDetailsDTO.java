package com.internousdev.ecsite.dto;

public class ItemDetailsDTO {

	private String productName;
	private String productNameKana;
	private String productDesc;
	private String price;
	private String itemImage;
	private String releaseDate;
	private String releaseCompany;


	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductNameKana() {
		return productNameKana;
	}
	public void setProductNameKana(String productNameKana) {
		this.productNameKana = productNameKana;
	}
	public String getProductDesc() {
		return productDesc;
	}
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}

	public String getItemImage() {
		return itemImage;
	}
	public void setItemImage(String itemImage) {
		this.itemImage = itemImage;
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	public String getReleaseCompany() {
		return releaseCompany;
	}
	public void setReleaseCompany(String releaseCompany) {
		this.releaseCompany = releaseCompany;
	}



}
