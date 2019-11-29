package com.internousdev.ecsite.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.util.InputChecker;
import com.opensymphony.xwork2.ActionSupport;

public class CreateDestinationConfirmAction extends ActionSupport implements SessionAware {

	private String familyName;
	private String firstName;
	private String familyNameKana;
	private String firstNameKana;
	private String address;
	private String telNumber;
	private String email;
	private List<String> familyNameErrorMessageList;
	private List<String> firstNameErrorMessageList;
	private List<String> familyNameKanaErrorMessageList;
	private List<String> firstNameKanaErrorMessageList;
	private List<String> addressErrorMessageList;
	private List<String> telNumberErrorMessageList;
	private List<String> emailErrorMessageList;

	private Map<String,Object> session;

	public String execute() {
		String result = ERROR;

		session.put("familyName", familyName);
		session.put("firstName", firstName);
		session.put("familyNameKana", familyNameKana);
		session.put("firstNameKana", firstNameKana);
		session.put("address", address);
		session.put("telNumber", telNumber);
		session.put("email", email);


		InputChecker inputChecker = new InputChecker();

		familyNameErrorMessageList = inputChecker.doCheck("姓", familyName, 1, 16, true, true, true, false, true, false);
		firstNameErrorMessageList = inputChecker.doCheck("名", firstName, 1, 16, true, true, true, false, true, false);
		familyNameKanaErrorMessageList = inputChecker.doCheck("姓ふりがな", familyNameKana, 1, 16, false, false, true, false, false, false);
		firstNameKanaErrorMessageList = inputChecker.doCheck("名ふりがな", firstNameKana, 1, 16, false, false, true, false, false, false);
		addressErrorMessageList = inputChecker.doCheck("住所", address, 10, 50, true, true, true, true, true, true);
		telNumberErrorMessageList = inputChecker.doCheck("電話番号", telNumber, 10, 13, false, false, false, true, false, false);
		emailErrorMessageList = inputChecker.doCheckForEmail("メールアドレス", email, 10, 32);

		if(familyNameErrorMessageList.size() > 0
		|| firstNameErrorMessageList.size() > 0
		||familyNameKanaErrorMessageList.size() > 0
		||firstNameKanaErrorMessageList.size() > 0
		||addressErrorMessageList.size() > 0
		||telNumberErrorMessageList.size() > 0
		||emailErrorMessageList.size() > 0) {
			return result;
		} else {
			result = SUCCESS;
		}

		return result;
	}



	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFamilyNameKana() {
		return familyNameKana;
	}

	public void setFamilyNameKana(String familyNameKana) {
		this.familyNameKana = familyNameKana;
	}

	public String getFirstNameKana() {
		return firstNameKana;
	}

	public void setFirstNameKana(String firstNameKana) {
		this.firstNameKana = firstNameKana;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelNumber() {
		return telNumber;
	}

	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<String> getFamilyNameErrorMessageList() {
		return familyNameErrorMessageList;
	}

	public void setFamilyNameErrorMessageList(List<String> familyNameErrorMessageList) {
		this.familyNameErrorMessageList = familyNameErrorMessageList;
	}

	public List<String> getFirstNameErrorMessageList() {
		return firstNameErrorMessageList;
	}

	public void setFirstNameErrorMessageList(List<String> firstNameErrorMessageList) {
		this.firstNameErrorMessageList = firstNameErrorMessageList;
	}

	public List<String> getFamilyNameKanaErrorMessageList() {
		return familyNameKanaErrorMessageList;
	}

	public void setFamilyNameKanaErrorMessageList(List<String> familyNameKanaErrorMessageList) {
		this.familyNameKanaErrorMessageList = familyNameKanaErrorMessageList;
	}

	public List<String> getFirstNameKanaErrorMessageList() {
		return firstNameKanaErrorMessageList;
	}

	public void setFirstNameKanaErrorMessageList(List<String> firstNameKanaErrorMessageList) {
		this.firstNameKanaErrorMessageList = firstNameKanaErrorMessageList;
	}

	public List<String> getAddressErrorMessageList() {
		return addressErrorMessageList;
	}

	public void setAddressErrorMessageList(List<String> addressErrorMessageList) {
		this.addressErrorMessageList = addressErrorMessageList;
	}

	public List<String> gettelNumberErrorMessageList() {
		return telNumberErrorMessageList;
	}

	public void settelNumberErrorMessageList(List<String> telNumberErrorMessageList) {
		this.telNumberErrorMessageList = telNumberErrorMessageList;
	}

	public List<String> getEmailErrorMessageList() {
		return emailErrorMessageList;
	}

	public void setEmailErrorMessageList(List<String> emailErrorMessageList) {
		this.emailErrorMessageList = emailErrorMessageList;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}


}
