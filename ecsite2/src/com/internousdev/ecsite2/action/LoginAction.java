package com.internousdev.ecsite2.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite2.dao.BuyItemDAO;
import com.internousdev.ecsite2.dao.LoginDAO;
import com.internousdev.ecsite2.dto.BuyItemDTO;
import com.internousdev.ecsite2.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware {

	private String loginUserId;
	private String loginPassword;
	private Map<String, Object> session;

	public String execute(){
		String result = ERROR;

		LoginDAO loginDAO = new LoginDAO();
		LoginDTO loginDTO = new LoginDTO();
		loginDTO = loginDAO.getLoginUserInfo(loginUserId, loginPassword);
		session.put("loginUser", loginDTO);

		if(((LoginDTO) session.get("loginUser")).getLoginFlg()){
		  if(((LoginDTO) session.get("loginUser")).getUserType().equals("0")){

			BuyItemDAO buyItemDAO = new BuyItemDAO();
			BuyItemDTO buyItemDTO = buyItemDAO.getBuyItemInfo();

			session.put("login_user_id", loginDTO.getLoginId());
			session.put("id", buyItemDTO.getId());
			session.put("buyItem_name", buyItemDTO.getItemName());
			session.put("buyItem_price", buyItemDTO.getItemPrice());

			result = SUCCESS;
			return result;
		  }


		 if(((LoginDTO) session.get("loginUser")).getLoginFlg()){
			 if(((LoginDTO) session.get("loginUser")).getUserType().equals("1")){
				 result = "success2";
				 return result;
			 }
		 }

		}
		return result;
	}


	public String getLoginUserId(){
		return loginUserId;
	}

	public void setLoginUserId(String loginUserId){
		this.loginUserId = loginUserId;
	}

	public String getLoginPassword(){
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword){
		this.loginPassword = loginPassword;
	}

	public Map<String, Object> getSession(){
		return this.session;
	}

	public void setSession(Map<String, Object> session){
		this.session = session;
	}


}
