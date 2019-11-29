package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.CreateDestinationCompleteDAO;
import com.internousdev.ecsite.dto.UserInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class CreateDestinationCompleteAction extends ActionSupport implements SessionAware{

	private Map<String,Object> session;

	public String execute() throws SQLException{
		String result = ERROR;
		String userId = ((UserInfoDTO) session.get("loginUser")).getLoginId().toString();
		int count = 0;

		CreateDestinationCompleteDAO createDestinationCompleteDAO = new CreateDestinationCompleteDAO();
		count = createDestinationCompleteDAO.createDestination(userId, session.get("familyName").toString(), session.get("firstName").toString(), session.get("familyNameKana").toString(), session.get("firstNameKana").toString(), session.get("address").toString(), session.get("telNumber").toString(), session.get("email").toString());

		if(count > 0) {
			result = SUCCESS;
		}

		session.remove("familyName");
		session.remove("firstName");
		session.remove("familyNameKana");
		session.remove("firstNameKana");
		session.remove("address");
		session.remove("telNumber");
		session.remove("email");

		return result;

	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}



}
