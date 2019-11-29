package com.internousdev.ecsite.dto;

public class UserInfoDTO {

	private String loginId;
	private String password;
	private String familyName;
	private String firstName;
	private String familyNameKana;
	private String firstNameKana;
	private String gender;
	private String email;


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

	public String getFamilyName(){
		return familyName;
	}

	public void setFamilyName(String familyName){
		this.familyName = familyName;
	}

	public String getFirstName(){
		return firstName;
	}

	public void setFirstName(String firstName){
		this.firstName = firstName;
	}

	public String getFamilyNameKana(){
		return familyNameKana;
	}

	public void setFamilyNameKana(String familyNameKana){
		this.familyNameKana = familyNameKana;
	}

	public String getFirstNameKana(){
		return firstNameKana;
	}

	public void setFirstNameKana(String firstNameKana){
		this.firstNameKana = firstNameKana;
	}

	public String getGender(){
		return gender;
	}

	public void setGender(String gender){
		this.gender = gender;
	}

	public String getEmail(){
		return email;
	}

	public void setEmail(String email){
		this.email = email;
	}

}
