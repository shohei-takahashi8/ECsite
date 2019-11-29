package com.internousdev.ecsite.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ChangePassDAO;
import com.internousdev.ecsite.util.InputChecker;
import com.opensymphony.xwork2.ActionSupport;

public class ChangePassCompleteAction extends ActionSupport implements SessionAware {

	private String loginId;
	private String currentPass;
	private String newPass;
	private String newPassConfirm;
	private String errorMsg = null;
	private Map<String,Object> session;
	private List<String> passwordErrorMessageList = new ArrayList<String>();

	public String execute() {

		int count = 0;
		String result = ERROR;
		String password = null;

		InputChecker inputChecker = new InputChecker();
		ChangePassDAO changePassDAO = new ChangePassDAO();
		password = changePassDAO.checkPass(loginId);
		passwordErrorMessageList.addAll(inputChecker.doCheck("現在のパスワード", currentPass, 1, 16, true, false, false, true, false, false));
		passwordErrorMessageList.addAll(inputChecker.doCheck("新しいパスワード", newPass, 1, 16, true, false, false, true, false, false));
		passwordErrorMessageList.addAll(inputChecker.doCheck("新しいパスワード（再確認）", newPassConfirm, 1, 16, true, false, false, true, false, false));

		if(!passwordErrorMessageList.isEmpty()) {
			return ERROR;
		}else if(!newPass.equals(newPassConfirm)) {
			passwordErrorMessageList.add("確認用パスワードが異なります。");
			return ERROR;
		}else if(currentPass.equals(newPass)) {
			passwordErrorMessageList.add("新しいパスワードは現在のパスワードと異なるものにしてください。");
			return ERROR;
		}else if(!password.equals(currentPass)) {
			passwordErrorMessageList.add("パスワードが登録されているものと異なります。");
			return ERROR;
		} else {
			count = changePassDAO.changePass(loginId, newPass);
			if(count > 0){
				result = SUCCESS;
			}
		}

		return result;

	}



	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getCurrentPass() {
		return currentPass;
	}

	public void setCurrentPass(String currentPass) {
		this.currentPass = currentPass;
	}

	public String getNewPass() {
		return newPass;
	}

	public void setNewPass(String newPass) {
		this.newPass = newPass;
	}

	public String getNewPassConfirm() {
		return newPassConfirm;
	}

	public void setNewPassConfirm(String newPassConfirm) {
		this.newPassConfirm = newPassConfirm;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public List<String> getPasswordErrorMessageList() {
		return passwordErrorMessageList;
	}

	public void setPasswordErrorMessageList(List<String> passwordErrorMessageList) {
		this.passwordErrorMessageList = passwordErrorMessageList;
	}




}
