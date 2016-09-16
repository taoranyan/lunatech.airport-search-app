package com.lunatech.airport_search_app.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lunatech.airport_search_app.model.Airport;
import com.lunatech.airport_search_app.model.Runway;
import com.lunatech.airport_search_app.service.AirportService;
import com.lunatech.airport_search_app.service.CountryAirportsRunwaysData;
import com.lunatech.airport_search_app.service.CountryService;
import com.lunatech.airport_search_app.service.QueryService;
import com.lunatech.airport_search_app.service.RunwayService;

@Service
public class QueryServiceImpl implements QueryService{
	
	@Autowired
	CountryService cserv;
	
	@Autowired
	AirportService aserv;
	
	@Autowired
	RunwayService rserv;

	public CountryAirportsRunwaysData getAirportsRunwaysByCountryCode(String code) {
		
		CountryAirportsRunwaysData res = new CountryAirportsRunwaysData();
		
		res.setCountry(cserv.getCountryByCode(code));
		
		List<Airport> l_airports = aserv.getAirportByCountryCode(code);
		
		res.setListAirports(l_airports);
		
		Map<Airport, List<Runway> > mapAirportRunways = new HashMap<Airport, List<Runway>>(); 
		
		if(l_airports == null) return res;
		for(Airport a : l_airports)
		{
			List<Runway> temp = rserv.getRunwaysByAirport(a);
			mapAirportRunways.put(a, temp);
		}
			
		res.setMapAirportRunways(mapAirportRunways);
		return res;
	}

	public CountryAirportsRunwaysData getAirportsRunwaysByCountryName(String name) {
		
		CountryAirportsRunwaysData res = new CountryAirportsRunwaysData();
		
		String name_converted = name.substring(0,  1).toUpperCase() + name.substring(1);
		
		res.setCountry(cserv.getCountryByName(name_converted));
		
		List<Airport> l_airports = aserv.getAirportByCountryName(name_converted);
		res.setListAirports(l_airports);
		
		Map<Airport, List<Runway> > mapAirportRunways = new HashMap<Airport, List<Runway>>(); 
		
		if(l_airports == null) return res;
		for(Airport a : l_airports)
		{
			List<Runway> temp = rserv.getRunwaysByAirport(a);
			mapAirportRunways.put(a, temp);
		}
			
		res.setMapAirportRunways(mapAirportRunways);
		
		return res;	
	}

}
