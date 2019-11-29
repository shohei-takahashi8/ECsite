package com.internousdev.ecsite2.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite2.dao.BuyItemStockConfirmDAO;
import com.opensymphony.xwork2.ActionSupport;

public class BuyItemAction extends ActionSupport implements SessionAware {

	private Map<String, Object> session;
	private int count;
	private String pay;
	private String errorMessage = null;

	public String execute() {

		String result = SUCCESS;

		BuyItemStockConfirmDAO buyItemStockConfirmDAO = new BuyItemStockConfirmDAO();
		int itemStock = buyItemStockConfirmDAO.confirmStock();
		System.out.println(itemStock);

		if(count > itemStock){
			result = ERROR;
			errorMessage = "在庫が足りません。";
		}else{
			result = SUCCESS;
			session.put("count", count);
			int intCount = Integer.parseInt(session.get("count").toString());
			int intPrice = Integer.parseInt(session.get("buyItem_price").toString());
			session.put("total_price", intCount * intPrice);
			String payment;
			if(pay.equals("1")) {
				payment = "現金払い";
				session.put("pay", payment);
			}else {
				payment = "クレジットカード";
				session.put("pay", payment);
			}
		}

		return result;
	}

	public void setCount(int count){
		this.count = count;
	}

	public void setPay(String pay){
		this.pay = pay;
	}

	public Map<String, Object> getSession(){
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getErrorMessage(){
		return errorMessage;
	}
}
