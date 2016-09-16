package com.lunatech.airport_search_app.service;

import java.util.List;
import java.util.Map;

import com.lunatech.airport_search_app.model.Airport;
import com.lunatech.airport_search_app.model.Country;
import com.lunatech.airport_search_app.model.Runway;

public class CountryAirportsRunwaysData {

	private Country country;
	
	private List<Airport> listAirports;
	
	private Map<Airport, List<Runway> > mapAirportRunways;
	
	public Country getCountry() { return country; }
	
	public void setCountry(Country country) { this.country = country ;}
	
	public List<Airport> getListAirports() { return listAirports; }
	
	public void setListAirports(List<Airport> listAirports) { this.listAirports = listAirports; }
	
	public Map<Airport, List<Runway> > getMapAirportRunways() { return mapAirportRunways; }
	
	public void setMapAirportRunways(Map<Airport, List<Runway> >  mapAirportRunways) 
	{
		this.mapAirportRunways = mapAirportRunways; 
	}
	
	public void print()
	{
		if(getCountry() != null){
		List<Airport> listAirports = getListAirports();
		Integer numRunways = 0;
		if(listAirports != null){
		for(Airport a : listAirports)
		{
			System.out.println("Airport (ID, Ident): " + a.getId() + ", " + a.getIdent());
			for(Runway r : getMapAirportRunways().get(a) )
			{
				numRunways ++;
				System.out.println("            Runway (ID, Surface): " + r.getId() + ", " + r.getSurface());
			}	
		}
		}
		System.out.println("In Country named < " + getCountry().getName() + " >");
		System.out.println("There are " + listAirports.size() + " Airports and "+ numRunways + " Runways in this country. ");
		}
		else
		{
			System.out.println("Your input is invalid !");
		}
	}
	
}
