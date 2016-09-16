package com.lunatech.airport_search_app.dao.impl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lunatech.airport_search_app.dao.CountryDAO;
import com.lunatech.airport_search_app.model.Country;

@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class CountryDAOImpl extends AbstractCrudDAOImpl<Country> implements CountryDAO{
	

	@Autowired
	private dumpDataHelper ddh;
	
	@SuppressWarnings("unchecked")
	public List<Country> listAll() {
		return (List<Country>)createQuery("select c from Country c").getResultList();
	}

	
	public Country getCountryById(Integer id) {
		Query query = createQuery("from Country c where c.id = :id").setParameter("id", id);
		try {
			return (Country) query.getSingleResult();
		} catch(NoResultException notfound) {
			return null;
		} 
		
	}
	
    public Country getCountryByCode(String code) throws NoResultException
    {
    	Query query = createQuery("from Country c where c.code = :code").setParameter("code", code);
    	try{
    		return (Country) query.getSingleResult();
    	}catch(NoResultException notfound){
    		return null;
    	}
    }
    

	public Country getCountryByName(String name) throws NoResultException{
    	Query query = createQuery("from Country c where c.name = :name").setParameter("name", name);
    	try{
    		return (Country) query.getSingleResult();
    	}catch(NoResultException notfound){
    		return null;
    	}
	}


	public void dumpCountriesFromCSV(String filename) throws FileNotFoundException {
		
		Iterable<CSVRecord> records = null;
		try {
			records = ddh.getReaderFromFile(filename);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Integer i = 0;
		for (CSVRecord record : records) {
			i++;
			Country country = new Country();
		    String id = record.get("id");
			if(id != null) country.setId(Integer.valueOf(id));
			else country.setId(null);
			country.setCode(record.get("code"));
			country.setName(record.get("name"));
			country.setContinent(record.get("continent"));
			country.setWikiLink(record.get("wikipedia_link"));
			String kw = record.get("keywords");
			if(kw != null)  country.setKeywords(kw);
			else country.setKeywords(null);
			this.save(country);
		}
		System.out.println("Total # of countries => " + i);
		
	}
	


}
