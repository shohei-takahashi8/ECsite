package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.UserInfoDAO;
import com.internousdev.ecsite.dto.UserInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware {


	private String loginId;
	private String password;
	private UserInfoDTO userInfoDTO = new UserInfoDTO();
	private Map<String, Object> session;

	public String execute() throws SQLException{

		String result = ERROR;
		UserInfoDAO userInfoDAO = new UserInfoDAO();
		userInfoDTO = userInfoDAO.select(loginId, password);
		session.put("loginUser", userInfoDTO);

		if(loginId.equals(userInfoDTO.getLoginId()) && password.equals(userInfoDTO.getPassword())) {
			result = SUCCESS;
		}

		return result;
	}

	public String getLoginId(){
		return loginId;
	}

	public void setLoginId(String loginId){
		this.loginId = loginId;
	}

	public String getPassword(){
		return password;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public UserInfoDTO getUserInfoDTO(){
		return userInfoDTO;
	}

	public void setUserInfoDTO(UserInfoDTO userInfoDTO){
		this.userInfoDTO = userInfoDTO;
	}

	public Map<String, Object> getSession(){
		return session;
	}

	public void setSession(Map<String, Object> session){
		this.session = session;
	}
}
