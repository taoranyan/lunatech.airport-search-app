package com.lunatech.airport_search_app.service;

import java.io.FileNotFoundException;
import java.util.List;

import com.lunatech.airport_search_app.model.Airport;
import com.lunatech.airport_search_app.model.Country;

public interface AirportService {
	
	public List<Airport> getAirportByCountryCode(String code);
	
	public List<Airport> getAirportByCountryName(String name);
	
	public  List<Airport> getAirportByCountry(Country country);
	
	public void dumpAirportFromCSV(String filename) throws FileNotFoundException;
	
	public Airport getAirportById(Integer id);
	
	public List<Airport> getAllAirports();

}
