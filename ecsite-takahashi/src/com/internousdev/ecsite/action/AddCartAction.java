package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.AddCartDAO;
import com.internousdev.ecsite.dao.CartInfoDAO;
import com.internousdev.ecsite.dto.CartInfoDTO;
import com.internousdev.ecsite.dto.UserInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class AddCartAction extends ActionSupport implements SessionAware {

	private Map<String, Object> session;
	private List<CartInfoDTO> cartInfoList;
	private String productCount;
	private String productId;
	private int cartTotalPrice = 0;

	public String execute() throws SQLException{

		String userId = ((UserInfoDTO) session.get("loginUser")).getLoginId().toString();
		int count = 0;

		AddCartDAO addCartDAO = new AddCartDAO();
		if(addCartDAO.isExistsCartInfo(userId, productId)){
			count = addCartDAO.updateProductCount(userId, productId, productCount);
		}else {
			count = addCartDAO.addCart(userId, productId, productCount);
		}

		if(count > 0){
			CartInfoDAO cartInfoDAO = new CartInfoDAO();
			cartInfoList = cartInfoDAO.getCartInfo(userId);
			//決済のためにセッションに入れる
			session.put("cartInfo", cartInfoList);
			//カート合計金額計算
			for(int i = 0; i < cartInfoList.size(); i++){
				cartTotalPrice += cartInfoList.get(i).getTotalPrice();
				//決済のためにセッションに入れる
				session.put("cartTotalPrice", cartTotalPrice);
			}
		}

		return SUCCESS;

	}


	public Map<String,Object> getSession(){
		return session;
	}

	public void setSession(Map<String, Object> session){
		this.session = session;
	}

	public List<CartInfoDTO> getCartInfoList(){
		return cartInfoList;
	}

	public String getProductCount(){
		return productCount;
	}

	public void setProductCount(String productCount){
		this.productCount = productCount;
	}

	public String getProductId(){
		return productId;
	}

	public void setProductId(String productId){
		this.productId = productId;
	}

	public int getCartTotalPrice(){
		return cartTotalPrice;
	}

	public void setCartTotalPrice(int cartTotalPrice){
		this.cartTotalPrice = cartTotalPrice;
	}




}
