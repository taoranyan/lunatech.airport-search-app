package com.lunatech.airport_search_app.dao;

//import java.util.List;

import java.io.FileNotFoundException;

//import com.lunatech.airport_search_app.model.Airport;
import com.lunatech.airport_search_app.model.Country;

public interface CountryDAO extends CrudDAO<Country>{
	
	public void dumpCountriesFromCSV(String filename) throws FileNotFoundException;
	
	public Country getCountryById(Integer id);
	
	public Country getCountryByCode(String code);

	public Country getCountryByName(String name);
}
