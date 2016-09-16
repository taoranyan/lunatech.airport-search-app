package com.lunatech.airport_search_app.service.impl;

import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lunatech.airport_search_app.dao.RunwayDAO;
import com.lunatech.airport_search_app.model.Airport;
import com.lunatech.airport_search_app.model.Runway;
import com.lunatech.airport_search_app.service.AirportService;
import com.lunatech.airport_search_app.service.RunwayService;

@Service
public class RunwayServiceImpl implements RunwayService{
	
	@Autowired
	RunwayDAO rdao;
	
	@Autowired
	AirportService aserv;

	public List<Runway> getRunwaysByAirportId(Integer id) {
		
		return rdao.getRunwayByAirportId(id);
	}

	public List<Runway> getRunwaysByAirport(Airport airport) {
		
		return rdao.getRunwaysByAirport(airport);
	}

	public void dumpRunwayFromCSV(String filename) throws FileNotFoundException {
		
		rdao.dumpRunwaysFromCSV(filename);
		
	}

	public List<Runway> getAllRunway() {
		
		return rdao.listAll();
	}

	

}
