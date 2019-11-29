package com.internousdev.ecsite.dto;

public class BuyItemHistoryDTO {

	private String id;
	private String itemName;
	private String itemNameKana;
	private String itemImage;
	private String company;
	private String releaseDate;
	private String price;
	private String count;
	private String totalPrice;

	public String getId(){
		return id;
	}

	public void setId(String id){
		this.id = id;
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

	public String getPrice(){
		return price;
	}

	public void setPrice(String price){
		this.price = price;
	}

	public String getCount(){
		return count;
	}

	public void setCount(String count){
		this.count = count;
	}

	public String getTotalPrice(){
		return totalPrice;
	}

	public void setTotalPrice(String totalPrice){
		this.totalPrice = totalPrice;
	}

}
