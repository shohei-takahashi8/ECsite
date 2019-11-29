package com.internousdev.ecsite.action;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.SearchItemDAO;
import com.internousdev.ecsite.dto.SearchItemDTO;
import com.internousdev.ecsite.util.InputChecker;
import com.opensymphony.xwork2.ActionSupport;

public class SearchItemAction extends ActionSupport implements SessionAware {

	private String keywords;
	private List<String> keywordsErrorMessageList;
	private List<SearchItemDTO> productInfoDTOList;
	private Map<String,Object> session;

	public String execute(){

		InputChecker inputChecker = new InputChecker();

		//処理用の変数に値を入れる
		if(StringUtils.isBlank(keywords)){
			//キーワードがnull,""," ","　"の時に空文字を設定する
			keywords = "";
		}else {
			keywords = keywords.replaceAll("　"," ").replaceAll("\\s{2,}"," ").trim();
		}

		if(!"".equals(keywords)){
			keywordsErrorMessageList = inputChecker.doCheck("検索ワード", keywords, 0, 50, true, true, true, true, true, true);
			if(keywordsErrorMessageList.size() > 0) {
				return SUCCESS;
			}
		}

		SearchItemDAO dao = new SearchItemDAO();
		productInfoDTOList = dao.searchItem(keywords.split(" "));
		return SUCCESS;
	}


	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public List<String> getKeywordsErrorMessageList() {
		return keywordsErrorMessageList;
	}

	public void setKeywordsErrorMessageList(List<String> keywordsErrorMessageList) {
		this.keywordsErrorMessageList = keywordsErrorMessageList;
	}

	public List<SearchItemDTO> getProductInfoDTOList() {
		return productInfoDTOList;
	}

	public void setProductInfoDTOList(List<SearchItemDTO> productInfoDTOList) {
		this.productInfoDTOList = productInfoDTOList;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}


}
