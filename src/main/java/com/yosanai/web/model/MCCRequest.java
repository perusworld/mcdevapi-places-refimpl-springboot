package com.yosanai.web.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MCCRequest {

	protected boolean isMCC;

	public MCCRequest() {
	}

	public boolean isMCC() {
		return isMCC;
	}

	public void setIsMCC(boolean isMCC) {
		this.isMCC = isMCC;
	}
}
