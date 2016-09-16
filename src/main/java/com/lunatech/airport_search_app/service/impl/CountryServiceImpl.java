package com.lunatech.airport_search_app.service.impl;

import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lunatech.airport_search_app.model.Country;
import com.lunatech.airport_search_app.dao.CountryDAO;
import com.lunatech.airport_search_app.service.CountryService;

@Service
public class CountryServiceImpl implements CountryService{
	
	@Autowired
	CountryDAO cdao;

	public void dumpCountryFromCSV(String filename) throws FileNotFoundException {
		 
		cdao.dumpCountriesFromCSV(filename);
		
	}
	
	public Country getCountryById(Integer id) {

		return cdao.getCountryById(id);
	}

	public Country getCountryByName(String name) {

		return cdao.getCountryByName(name);
	}
	
	public Country getCountryByCode(String code) {
		
		return cdao.getCountryByCode(code);
	}

	public List<Country> getAllCountries() {

		return cdao.listAll();
	}




	

}
