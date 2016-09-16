package com.lunatech.airport_search_app.service.impl;

import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lunatech.airport_search_app.dao.AirportDAO;
import com.lunatech.airport_search_app.dao.CountryDAO;
import com.lunatech.airport_search_app.dao.RunwayDAO;
import com.lunatech.airport_search_app.service.DumpDataService;

@Service
public class DumpDataServiceImpl implements DumpDataService{

	@Autowired
	AirportDAO adao;
	
	@Autowired
	CountryDAO cdao;
	
	@Autowired
	RunwayDAO rdao;
	
	@Override
	public void dumpDataFromCSV() throws FileNotFoundException {
		
		System.out.println("*****************************************************");
		System.out.println("      Dumping in the data from files in database     ");
		System.out.println("*****************************************************");
		double totalStartTime = System.nanoTime();
		double totalDuration = 0.0;
		
		String cFile = "countries.csv";
		cdao.dumpCountriesFromCSV(cFile);
		
		String aFile = "airports.csv";
		adao.dumpAirportsFromCSV(aFile);
		
		String rFile = "runways.csv";
		rdao.dumpRunwaysFromCSV(rFile);

		double totalEndTime = System.nanoTime();
		totalDuration = ((double) (totalEndTime - totalStartTime) / 1000000000.0) / 60;
		System.out.println("Total duration for data dumping is " + totalDuration + " min.\n");
		
	}
	

}
