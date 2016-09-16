package com.lunatech.airport_search_app.service;

import java.io.FileNotFoundException;
import java.util.List;

import com.lunatech.airport_search_app.model.Country;

public interface CountryService {
	
	//public List<Airport> searchAirportsByCode(String code);

	//public List<Airport> searchAirortsByName(String name);
	
	
	public void dumpCountryFromCSV(String filename) throws FileNotFoundException;
	
	public Country getCountryById(Integer id);
	
	public Country getCountryByCode(String code);
	
	public Country getCountryByName(String name);
	
	public List<Country> getAllCountries();
}
