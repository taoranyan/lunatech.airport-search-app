package com.lunatech.airport_search_app.control.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.lunatech.airport_search_app.control.UserQueryController;
import com.lunatech.airport_search_app.service.CountryAirportsRunwaysData;
import com.lunatech.airport_search_app.service.QueryService;

@Controller
public class UserQueryControllerImpl implements UserQueryController {

	@Autowired
	private QueryService qs;
	
	public CountryAirportsRunwaysData searchAirportsRunwaysByCode(String code) {
		
		return qs.getAirportsRunwaysByCountryCode(code);
	
	}

	public CountryAirportsRunwaysData searchAirortsRunwaysByName(String name) {
		
		return qs.getAirportsRunwaysByCountryName(name);
		
	}

}
