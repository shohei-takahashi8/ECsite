package com.internousdev.ecsite.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.CartInfoDAO;
import com.internousdev.ecsite.dao.DestinationInfoDAO;
import com.internousdev.ecsite.dto.CartInfoDTO;
import com.internousdev.ecsite.dto.DestinationInfoDTO;
import com.internousdev.ecsite.dto.UserInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class PaymentAction extends ActionSupport implements SessionAware {

	private Map<String,Object> session;
	private List<CartInfoDTO> cartInfoList;
	private List<DestinationInfoDTO> destinationInfoList;
	private int cartTotalPrice = 0;
	private String errorMsg2 = null;

	public String execute(){

			String result = ERROR;
		    String userId = ((UserInfoDTO) session.get("loginUser")).getLoginId().toString();
			CartInfoDAO cartInfoDAO = new CartInfoDAO();
			cartInfoList = cartInfoDAO.getCartInfo(userId);
			DestinationInfoDAO destinationInfoDAO = new DestinationInfoDAO();
			destinationInfoList = destinationInfoDAO.getDestinationInfo(userId);

			if(cartInfoList.isEmpty()){
				errorMsg2 = "商品情報がありません。";
			}else{
				//決済のためにセッションに入れる
				session.put("cartInfo", cartInfoList);
				//カート合計金額計算
				for(int i = 0; i < cartInfoList.size(); i++){
					cartTotalPrice += cartInfoList.get(i).getTotalPrice();
					//決済のためにセッションに入れる
					session.put("cartTotalPrice", cartTotalPrice);
				}

				result = SUCCESS;

			}

		return result;
	}

	public Map<String,Object> getSession(){
		return session;
	}

	public void setSession(Map<String,Object> session){
		this.session = session;
	}

	public List<CartInfoDTO> getCartInfoList(){
		return cartInfoList;
	}

	public void setCartInfoList(List<CartInfoDTO> cartInfoList){
		this.cartInfoList = cartInfoList;
	}


	public List<DestinationInfoDTO> getDestinationInfoList() {
		return destinationInfoList;
	}

	public void setDestinationInfoList(List<DestinationInfoDTO> destinationInfoList) {
		this.destinationInfoList = destinationInfoList;
	}

	public int getCartTotalPrice(){
		return cartTotalPrice;
	}

	public void setCartTotalPrice(int cartTotalPrice){
		this.cartTotalPrice = cartTotalPrice;
	}

	public String getErrorMsg2(){
		return errorMsg2;
	}

	public void setErrorMsg2(String errorMsg2){
		this.errorMsg2 = errorMsg2;
	}
}
