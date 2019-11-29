package com.internousdev.ecsite.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.CartInfoDAO;
import com.internousdev.ecsite.dao.DeleteCartDAO;
import com.internousdev.ecsite.dto.CartInfoDTO;
import com.internousdev.ecsite.dto.UserInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteCartAction extends ActionSupport implements SessionAware {

	private Map<String, Object> session;
	private String[] deleteList;
	private List<CartInfoDTO> cartInfoList;
	private int cartTotalPrice = 0;
	private String errorMsg = null;
	private String errorMsg2 = null;


	public String execute() {

		String result = ERROR;
		String userId = ((UserInfoDTO) session.get("loginUser")).getLoginId().toString();
		int count = 0;
		DeleteCartDAO deleteCartDAO = new DeleteCartDAO();

		if(deleteList != null){
			for(String id:deleteList){
				count += deleteCartDAO.deleteCart(id, userId);
			}

			if(deleteList.length == count){
				CartInfoDAO cartInfoDAO = new CartInfoDAO();
				cartInfoList = cartInfoDAO.getCartInfo(userId);
				//カート合計金額計算
				for(int i = 0; i < cartInfoList.size(); i++){
					cartTotalPrice += cartInfoList.get(i).getTotalPrice();
				}
			}
			result = SUCCESS;

		}else {
			errorMsg = "削除したい項目にチェックをいれてください。";
			CartInfoDAO cartInfoDAO = new CartInfoDAO();
			cartInfoList = cartInfoDAO.getCartInfo(userId);
			//カート合計金額計算
			for(int i = 0; i < cartInfoList.size(); i++){
				cartTotalPrice += cartInfoList.get(i).getTotalPrice();
			}
		}

		//DeleteCheckTest
		if(cartInfoList.isEmpty()){
			errorMsg2 = "商品情報がありません。";
		}

		return result;
	}


	public Map<String,Object> getSession(){
		return session;
	}

	public void setSession(Map<String,Object> session){
		this.session = session;
	}

	public String[] getDeleteList(){
		return deleteList;
	}

	public void setDeleteList(String[] deleteList){
		this.deleteList = deleteList;
	}

	public List<CartInfoDTO> getCartInfoList(){
		return cartInfoList;
	}

	public int getCartTotalPrice(){
		return cartTotalPrice;
	}

	public void setCartTotalPrice(int cartTotalPrice){
		this.cartTotalPrice = cartTotalPrice;
	}

	public String getErrorMsg(){
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg){
		this.errorMsg = errorMsg;
	}

	public String getErrorMsg2(){
		return errorMsg2;
	}

	public void setErrorMsg2(String errorMsg2){
		this.errorMsg2 = errorMsg2;
	}
}
