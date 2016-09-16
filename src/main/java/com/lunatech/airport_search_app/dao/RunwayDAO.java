package com.lunatech.airport_search_app.dao;

import java.io.FileNotFoundException;
import java.util.List;

import com.lunatech.airport_search_app.model.Airport;
import com.lunatech.airport_search_app.model.Runway;

public interface RunwayDAO extends CrudDAO<Runway>{

	public void dumpRunwaysFromCSV(String filename) throws FileNotFoundException;
	
	public List<Runway> getRunwaysByAirport(Airport airport);
	
	public List<Runway> getRunwayByAirportId(Integer id);
	
	public List<Runway> getRunwayByCountryCode(String code);
	
	public List<Runway> getRunwayByCountryName(String name);
	
	//public CountryAirportsRunwaysData getAirportRunwaysByCountryCode(String code);
	
	//public CountryAirportsRunwaysData getAirportRunwaysByCountryName(String name);
	
	public Runway getRunwayById(Integer id);

}
