package com.yosanai.web.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PointOfInterestRequest extends BaseRequest {

	protected boolean radiusSearch;
	protected String countryCode;
	protected String unit;
	protected int distance;
	protected String stateProvidenceCode;

	public PointOfInterestRequest() {
	}

	public boolean isRadiusSearch() {
		return radiusSearch;
	}

	public void setRadiusSearch(boolean radiusSearch) {
		this.radiusSearch = radiusSearch;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public String getStateProvidenceCode() {
		return stateProvidenceCode;
	}

	public void setStateProvidenceCode(String stateProvidenceCode) {
		this.stateProvidenceCode = stateProvidenceCode;
	}

}
