package com.yosanai.web.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class IndustryRequest {
	protected boolean isInd;

	public IndustryRequest() {
	}

	public boolean isInd() {
		return isInd;
	}

	public void setIsInd(boolean isInd) {
		this.isInd = isInd;
	}

}
