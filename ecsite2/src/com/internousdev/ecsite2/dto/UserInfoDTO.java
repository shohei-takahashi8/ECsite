package com.internousdev.ecsite2.dto;

public class UserInfoDTO {

	private String id;
	private String loginId;
	private String loginPassword;
	private String userName;
	private String insert_date;
	private String updated_date;
	private String admin_flg;

	public String getId(){
		return id;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getLoginId(){
		return loginId;
	}

	public void setLoginId(String loginId){
		this.loginId = loginId;
	}

	public String getLoginPassword(){
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword){
		this.loginPassword = loginPassword;
	}

	public String getUserName(){
		return userName;
	}

	public void setUserName(String userName){
		this.userName = userName;
	}

	public String getInsert_date(){
		return insert_date;
	}

	public void setInsert_date(String insert_date){
		this.insert_date = insert_date;
	}

	public String getUpdated_date(){
		return updated_date;
	}

	public void setUpdated_date(String updated_date){
		this.updated_date = updated_date;
	}

	public String getAdmin_flg(){
		return admin_flg;
	}

	public void setAdmin_flg(String admin_flg){
		this.admin_flg = admin_flg;
	}

}
