package com.lunatech.airport_search_app.control;

import com.lunatech.airport_search_app.service.CountryAirportsRunwaysData;

public interface UserQueryController {
	
	public CountryAirportsRunwaysData searchAirportsRunwaysByCode(String code);
	
	public CountryAirportsRunwaysData searchAirortsRunwaysByName(String name);
}
