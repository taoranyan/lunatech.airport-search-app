package com.lunatech.airport_search_app.dao;

import java.io.FileNotFoundException;
import java.util.List;

import com.lunatech.airport_search_app.model.Airport;
import com.lunatech.airport_search_app.model.Country;

public interface AirportDAO extends CrudDAO<Airport>{
	
	public List<Airport> getAirportsByCountry(Country country);
	
	public List<Airport> getAirportsByCountryCode(String code);
	
	public List<Airport> getAirportsByCountryName(String name);
	
	public Airport getAirportById(Integer id);

	public void dumpAirportsFromCSV(String filename) throws FileNotFoundException;
}
