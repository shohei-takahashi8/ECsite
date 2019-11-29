package com.internousdev.ecsite.dto;

public class CartInfoDTO {

	private int id;
	private String productId;
	private String itemName;
	private String itemNameKana;
	private String itemImage;
	private String price;
	private String company;
	private String releaseDate;
	private String itemCount;
	private int totalPrice;



	public int getId(){
		return id;
	}

	public void setId(int id){
		this.id = id;
	}

	public String getProductId(){
		return productId;
	}

	public void setProductId(String productId){
		this.productId = productId;
	}

	public String getItemName(){
		return itemName;
	}

	public void setItemName(String itemName){
		this.itemName = itemName;
	}

	public String getItemNameKana(){
		return itemNameKana;
	}

	public void setItemNameKana(String itemNameKana){
		this.itemNameKana = itemNameKana;
	}

	public String getItemImage(){
		return itemImage;
	}

	public void setItemImage(String itemImage){
		this.itemImage = itemImage;
	}

	public String getPrice(){
		return price;
	}

	public void setPrice(String price){
		this.price = price;
	}

	public String getCompany(){
		return company;
	}

	public void setCompany(String company){
		this.company = company;
	}

	public String getReleaseDate(){
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate){
		this.releaseDate = releaseDate;
	}

	public String getItemCount(){
		return itemCount;
	}

	public void setItemCount(String itemCount){
		this.itemCount = itemCount;
	}

	public int getTotalPrice(){
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice){
		this.totalPrice = totalPrice;
	}

}
