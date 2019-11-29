package com.internousdev.ecsite.dto;

public class SearchItemDTO {

	private int id;
	private String productName;
	private String price;
	private String itemImage;


	public int getId(){
		return id;
	}

	public void setId(int id){
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
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



}
