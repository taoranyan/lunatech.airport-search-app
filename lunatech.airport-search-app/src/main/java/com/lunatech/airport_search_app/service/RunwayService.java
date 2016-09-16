package com.lunatech.airport_search_app.service;

import java.io.FileNotFoundException;
import java.util.List;

import com.lunatech.airport_search_app.model.Airport;
import com.lunatech.airport_search_app.model.Runway;

public interface RunwayService {
	
	public List<Runway> getRunwaysByAirportId(Integer id);
	
	public  List<Runway> getRunwaysByAirport(Airport airport);
	
	public void dumpRunwayFromCSV(String filename) throws FileNotFoundException;
	
	public List<Runway> getAllRunway();

}
