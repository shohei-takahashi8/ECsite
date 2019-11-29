package com.internousdev.ecsite.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.CartInfoDAO;
import com.internousdev.ecsite.dao.PaymentCompleteDAO;
import com.internousdev.ecsite.dto.CartInfoDTO;
import com.internousdev.ecsite.dto.UserInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class PaymentCompleteAction extends ActionSupport implements SessionAware {

	private int destinationId = 0;
	private Map<String,Object> session;
	private List<CartInfoDTO> cartInfoList;

	public String execute(){

		String result = ERROR;
		String userId = ((UserInfoDTO) session.get("loginUser")).getLoginId().toString();
		int count = 0;

		CartInfoDAO cartInfoDAO = new CartInfoDAO();
		cartInfoList = cartInfoDAO.getCartInfo(userId);

		PaymentCompleteDAO paymentCompleteDAO = new PaymentCompleteDAO();
		for(CartInfoDTO dto:cartInfoList) {
			count += paymentCompleteDAO.buyItem(userId, dto.getProductId(), dto.getItemCount(), dto.getPrice(), destinationId);
		}

		if(count > 0){
			count = cartInfoDAO.deleteCartInfo(userId);
			if(count > 0){
				result = SUCCESS;
			}
		}

		return result;

	}



	public int getDestinationId() {
		return destinationId;
	}

	public void setDestinationId(int destinationId) {
		this.destinationId = destinationId;
	}

	public Map<String,Object> getSession(){
		return session;
	}

	public void setSession(Map<String,Object> session){
		this.session = session;
	}

}
