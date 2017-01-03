package com.yosanai.web.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mastercard.api.core.model.RequestMap;
import com.mastercard.api.places.GeocodeLocation;
import com.mastercard.api.places.MerchantCategoryCodes;
import com.mastercard.api.places.MerchantIndustries;
import com.mastercard.api.places.MerchantPointOfInterest;
import com.yosanai.web.model.GeoRequest;
import com.yosanai.web.model.IndustryRequest;
import com.yosanai.web.model.MCCRequest;
import com.yosanai.web.model.PointOfInterestRequest;

@RestController
public class PlacesController {

	@RequestMapping(value = "/mcc", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody MerchantCategoryCodes query(@RequestBody MCCRequest req) throws Exception {
		RequestMap map = new RequestMap();
		map.set("Mcc_Codes", req.isMCC());
		return MerchantCategoryCodes.query(map);
	}

	@RequestMapping(value = "/industries", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody MerchantIndustries industries(@RequestBody IndustryRequest req) throws Exception {
		RequestMap map = new RequestMap();
		map.set("Ind_Codes", req.isInd());
		return MerchantIndustries.query(map);
	}

	@RequestMapping(value = "/poi", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody MerchantPointOfInterest poi(@RequestBody PointOfInterestRequest req) throws Exception {
		RequestMap map = new RequestMap();
		map.set("radiusSearch", req.isRadiusSearch());
		map.set("unit", req.getUnit());
		map.set("pageLength", req.getPageLength());
		map.set("distance", req.getDistance());
		map.set("pageOffset", req.getPageOffset());
		map.set("place.countryCode", req.getCountryCode());
		map.set("place.stateProvidenceCode", req.getStateProvidenceCode());
		return MerchantPointOfInterest.create(map);
	}

	@RequestMapping(value = "/geo", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody GeocodeLocation geo(@RequestBody GeoRequest req) throws Exception {
		RequestMap map = new RequestMap();
		map.set("cityName", req.getCityName());
		map.set("countryCode", req.getCountryCode());
		map.set("postalCode", req.getPostalCode());
		map.set("addressLine1", req.getAddressLine1());
		return GeocodeLocation.query(map);
	}

}
