package com.lunatech.airport_search_app.service;


public interface QueryService {
	
	public CountryAirportsRunwaysData getAirportsRunwaysByCountryCode(String code);
	
	public CountryAirportsRunwaysData getAirportsRunwaysByCountryName(String name);
	

}
