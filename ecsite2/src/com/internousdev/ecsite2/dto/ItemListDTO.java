package com.internousdev.ecsite2.dto;

public class ItemListDTO {

	private int id;
	private String itemName;
	private String itemPrice;
	private String stock;
	private String insert_date;
	private String update_date;

	public int getId(){
		return id;
	}

	public void setId(int id){
		this.id = id;
	}

	public String getItemName(){
		return itemName;
	}

	public void setItemName(String itemName){
		this.itemName = itemName;
	}

	public String getItemPrice(){
		return itemPrice;
	}

	public void setItemPrice(String itemPrice){
		this.itemPrice = itemPrice;
	}

	public String getStock(){
		return stock;
	}

	public void setStock(String stock){
		this.stock = stock;
	}

	public String getInsert_date(){
		return insert_date;
	}

	public void setInsert_date(String insert_date){
		this.insert_date = insert_date;
	}

	public String getUpdate_date(){
		return update_date;
	}

	public void setUpdate_date(String update_date){
		this.update_date = update_date;
	}

}
