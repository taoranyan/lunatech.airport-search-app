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

import com.lunatech.airport_search_app.dao.AirportDAO;
import com.lunatech.airport_search_app.dao.CountryDAO;
import com.lunatech.airport_search_app.model.Airport;
import com.lunatech.airport_search_app.model.Country;

@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class AirportDAOImpl extends AbstractCrudDAOImpl<Airport> implements AirportDAO{
	
	@Autowired
	CountryDAO cdao;
	
	@Autowired
	dumpDataHelper ddh;
	
	@SuppressWarnings("unchecked")
	public List<Airport> listAll() {
		return (List<Airport>)createQuery("select a from Airport a").getResultList();
	}

	
	public Airport getAirportById(Integer id) {
		Query query = createQuery("from Airport a where a.id = :id").setParameter("id", id);
		try {
			return (Airport) query.getSingleResult();
		} catch(NoResultException notfound) {
			return null;
		} 	
	}
	
	@SuppressWarnings("unchecked")
	public List<Airport> getAirportsByCountry( Country country) {
		
		if(country == null) return null;
		Query query = createQuery("from Airport a where a.iso_country = :code").setParameter("code", country.getCode());
		try{
			return (List<Airport>) query.getResultList();
		} catch (NoResultException notfound) {
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Airport> getAirportsByCountryCode(String code){
		Query query = createQuery("from Airport a where a.iso_country = :code").setParameter("code", code);
		try{
			return (List<Airport>) query.getResultList();
		} catch (NoResultException notfound) {
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Airport> getAirportsByCountryName(String name) {
		Query query = createQuery("from Airport a join Country c with a.iso_country = c.code and c.name = :name")
				.setParameter("name", name);
		try{
			return (List<Airport>) query.getResultList();
		} catch (NoResultException notfound) {
			return null;
		}
	}



	public void dumpAirportsFromCSV(String filename) throws FileNotFoundException{
		
		Iterable<CSVRecord> records = null;
		try {
			records = ddh.getReaderFromFile(filename);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		Integer j = 0;
	    
		for (CSVRecord record : records) {

			j++;
		    Airport a1 = new Airport();
    
		    String id = record.get("id");
			if(id != null) a1.setId(Integer.valueOf(id));
			else a1.setId(null);
			
			a1.setIdent(record.get("ident"));
			a1.setType(record.get("type"));
			a1.setName(record.get("name"));
			
			String lad = record.get("latitude_deg");
			if(lad != null) a1.setLatitudeDeg(Float.valueOf(lad));
			else a1.setLatitudeDeg(null);
			
			String lod = record.get("longitude_deg");
			if(lod != null) a1.setLongitudeDeg(Float.valueOf(lod));
			else a1.setLongitudeDeg(null);
			
			String e_ft = record.get("elevation_ft");
			
			if(!e_ft.equals("")) a1.setElevationFT(Integer.valueOf(e_ft));
			else a1.setElevationFT(null);
			
			a1.setIsoRegion(record.get("iso_region"));
			a1.setMunicipality(record.get("municipality"));
			
			String ss = record.get("scheduled_service");	
			if(ss != null) a1.setScheduledService(ss);
			else a1.setScheduledService(ss);
			
			a1.setGPSCode(record.get("gps_code"));
			a1.setIataCode(record.get("iata_code"));
			a1.setLocalCode(record.get("local_code"));
			a1.setHomeLink(record.get("home_link"));
			a1.setWikiLink(record.get("wikipedia_link"));
			a1.setKeywords(record.get("keywords"));
			a1.setContinent(record.get("continent"));
			
			String iso_country = record.get("iso_country");
			a1.setIsoCountry(iso_country);	
			
			/* Do not update country for Airport in object level
			//Country c1 = cdao.getCountryByCode(iso_country);
			//a1.setCountry(c1);
			 * */

			this.save(a1);
			
		}
			System.out.println("Total # of airports => " + j );
	}



	

}
