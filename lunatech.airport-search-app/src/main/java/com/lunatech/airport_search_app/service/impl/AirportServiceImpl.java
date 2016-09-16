package com.lunatech.airport_search_app.service.impl;

import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lunatech.airport_search_app.model.Airport;
import com.lunatech.airport_search_app.model.Country;
import com.lunatech.airport_search_app.dao.AirportDAO;
import com.lunatech.airport_search_app.service.AirportService;
import com.lunatech.airport_search_app.service.CountryService;

@Service
public class AirportServiceImpl implements AirportService{
	
	@Autowired
	AirportDAO adao;
	
	@Autowired
	CountryService cserv;
	
	public List<Airport> getAirportByCountryCode(String code) {
		
		Country country = cserv.getCountryByCode(code);
		
		return getAirportByCountry(country);
	}
	
	public List<Airport> getAirportByCountryName(String name) {
		
		Country country = cserv.getCountryByName(name);
		
		return getAirportByCountry(country);
	}
	
	public List<Airport> getAirportByCountry(Country country) {

		return adao.getAirportsByCountry(country);
	}
	
	public void dumpAirportFromCSV(String filename) throws FileNotFoundException {
		
		adao.dumpAirportsFromCSV(filename);
		
	}

	public Airport getAirportById(Integer id) {

		return adao.getAirportById(id);
	}

	public List<Airport> getAllAirports() {
		
		return adao.listAll();
	}

}
