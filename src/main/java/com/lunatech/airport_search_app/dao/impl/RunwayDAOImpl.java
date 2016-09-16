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
import com.lunatech.airport_search_app.dao.RunwayDAO;
import com.lunatech.airport_search_app.model.Airport;
import com.lunatech.airport_search_app.model.Runway;




@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class RunwayDAOImpl extends AbstractCrudDAOImpl<Runway> implements RunwayDAO{
	
	@Autowired
	private AirportDAO adao;
	
	@Autowired
	private dumpDataHelper ddh;

	@SuppressWarnings("unchecked")
	public List<Runway> listAll() 
	{
		return (List<Runway>)createQuery("from Runway r").getResultList();
	}

	public Runway getRunwayById(Integer id) 
	{
		Query query = createQuery("from Runway r where r.id = :id").setParameter("id", id);
		try {
			return (Runway) query.getSingleResult();
		} catch(NoResultException notfound) {
			return null;
		} 	
	}

	@SuppressWarnings("unchecked")
	public List<Runway> getRunwaysByAirport( Airport airport) 
	{
		Query query = createQuery("from Runway r where r.airport_ref = :aid")
				.setParameter("aid", airport.getId().intValue());
		try {
			return (List<Runway>) query.getResultList();
		} catch(NoResultException notfound) {
			return null;
		} 	
	}


	@SuppressWarnings("unchecked")
	public List<Runway> getRunwayByAirportId( Integer id) 
	{
		Query query = createQuery("from Runway r where r.airport_ref = :aid")
				.setParameter("aid", id);
		try {
			return (List<Runway>) query.getResultList();
		} catch(NoResultException notfound) {
			return null;
		} 
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Runway> getRunwayByCountryCode(String code) 
	{
		Query query = createQuery("select r "
				+ "from Runway r "
				+ "join Airport a with r.airport_ident = a.ident "
				+ "where a.iso_country = :code")
				.setParameter("code", code);
		try {
			return (List<Runway>) query.getResultList();
		} catch(NoResultException notfound) {
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Runway> getRunwayByCountryName(String name) 
	{
		Query query = createQuery("select  r "
				+ "from Country c "
				+ "join Airport a with c.code = a.iso_country "
				+ "join Runway r with a.ident = r.airport_ident "
				+ "where a.ident = r.airport_ident and c.name = :name ")
				.setParameter("name", name);
		try {
			return (List<Runway>) query.getResultList();
		} catch(NoResultException notfound) {
			return null;
		}
	}
	
	/*
	@Override
	public CountryAirportsRunwaysData getAirportRunwaysByCountryCode(String code) 
	{
		Query query = createQuery("select a, r from Country c "
				+ "join Airport a with c.code = a.iso_country "
				+ "join Runway r with a.ident = r.airport_ident "
				+ "where c.country_code = :code")
						.setParameter("code", code);
	}
	*/
	
	/*
	@SuppressWarnings("unchecked")
	@Override
	public CountryAirportsRunwaysData getAirportRunwaysByCountryName(String name) 
	{
		
		//Query query = createQuery("select a, r from Country c join Airport a with c.code = a.iso_country join Runway r with a.ident = r.airport_ident where c.name = :name")
		//		.setParameter("name", name);
		CountryAirportsRunwaysData res = new CountryAirportsRunwaysData();
		Map<Airport, List<Runway> > map_airport_runways = new HashMap<Airport, List<Runway> >();

			Query query = createQuery("select a.name, r "
					+ "from Country c "
					+ "join Airport a with c.code = a.iso_country "
					+ "join Runway r with a.ident = r.airport_ident "
					+ "where a.ident = r.airport_ident and c.name = :name ")
					.setParameter("name", name);
			try {
				List<Object[]> rawRes = query.getResultList();
				for (Object[] o : rawRes) {
					StringBuffer row = new StringBuffer();
					
					for (int i=0; i<o.length; i++) {
					
						
					row.append((o[i] == null ? "[null]" : o[i].toString()) + ", ");
					}
						System.out.println(row.deleteCharAt(row.length()-2));
					}
				return null;
			} catch(NoResultException notfound) {
				return null;
			}


	}
	*/
	
	public void dumpRunwaysFromCSV(String filename) throws FileNotFoundException{
		
		Iterable<CSVRecord> records = null;
		try {
			records = ddh.getReaderFromFile(filename);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		Integer j = 0;
	    
		for (CSVRecord record : records) {

			j++;
			
		    Runway runway = new Runway();
    
		    String id = record.get("id");
			if(id != null) runway.setId(Integer.valueOf(id));
			else runway.setId(null);
			
			runway.setAirportRef(Integer.valueOf(record.get("airport_ref")));
			runway.setAirportIdent(record.get("airport_ident"));
			
			String lf = record.get("length_ft");
			if(!lf.equals("")) runway.setLengthFt(Integer.valueOf(lf));
			else runway.setLengthFt(null);
			
			String wf = record.get("width_ft");
			if(!wf.equals("")) runway.setWidthFt(Integer.valueOf(wf));
			else runway.setWidthFt(null);
			
			String surface = record.get("surface");
			if(surface != null) runway.setSurface(surface);
			else runway.setSurface(null);
			
			String lighted = record.get("lighted");
			if(lighted != null) runway.setLighted(lighted);
			else runway.setLighted(null);
			
			String closed = record.get("closed");
			if(closed != null) runway.setClosed(closed);
			runway.setClosed(null);
			
			String le_ident = record.get("le_ident");
			if(le_ident != null) runway.setLeIdent(le_ident);
			else runway.setLeIdent(null);
			
			String lad = record.get("le_latitude_deg");
			if(!lad.equals("")) runway.setLeLatitudeDeg(Float.valueOf(lad));
			else runway.setLeLatitudeDeg(null);
			
			String lod = record.get("le_longitude_deg");
			if(!lod.equals("")) runway.setLeLongitudeDeg(Float.valueOf(lod));
			else runway.setLeLongitudeDeg(null);
			
			String lef = record.get("le_elevation_ft");
			if(!lef.equals("")) runway.setLeElevationFt(Integer.valueOf(lef));
			else runway.setLeElevationFt(null);
			
			String lhd = record.get("le_heading_degT");
			if(!lhd.equals("")) runway.setLeHeadingDegT(Float.valueOf(lhd));
			else runway.setLeHeadingDegT(null);
			
			String ldtf = record.get("le_displaced_threshold_ft");
			if(!ldtf.equals("")) runway.setLeDisplacedThreshFt(Integer.valueOf(ldtf));
			else runway.setLeDisplacedThreshFt(null);
			
			String had = record.get("he_latitude_deg");
			if(!had.equals("")) runway.setHeLatitudeDeg(Float.valueOf(had));
			else runway.setHeLatitudeDeg(null);
			
			String hod = record.get("he_longitude_deg");
			if(!hod.equals("")) runway.setHeLongitudeDeg(Float.valueOf(hod));
			else runway.setHeLongitudeDeg(null);
			
			String hef = record.get("he_elevation_ft");
			if(!hef.equals("")) runway.setHeElevationFt(Integer.valueOf(hef));
			else runway.setHeElevationFt(null);
			
			String hhd = record.get("he_heading_degT");
			if(!hhd.equals("")) runway.setHeHeadingDegT(Float.valueOf(hhd));
			else runway.setHeHeadingDegT(null);
			
			String hdtf = record.get("he_displaced_threshold_ft");
			if(!hdtf.equals("")) runway.setHeDisplacedThreshFt(Integer.valueOf(hdtf));
			else runway.setHeDisplacedThreshFt(null);
			

			this.save(runway);
		}
			System.out.println("Total # of runways => " + j );

	}









}
