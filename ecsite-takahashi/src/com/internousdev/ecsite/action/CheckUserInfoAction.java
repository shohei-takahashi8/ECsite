package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dto.UserInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class CheckUserInfoAction extends ActionSupport implements SessionAware {

	private Map<String,Object> session;
	private String gender;

	public String execute(){

		if(((UserInfoDTO) session.get("loginUser")).getGender().toString().equals("0")){
			gender = "男性";
		}else {
			gender = "女性";
		}

		return SUCCESS;
	}


	public Map<String, Object> getSession(){
		return session;
	}

	public void setSession(Map<String, Object> session){
		this.session = session;
	}

	public String getGender(){
		return gender;
	}

	public void setGender(String gender){
		this.gender = gender;
	}
}
