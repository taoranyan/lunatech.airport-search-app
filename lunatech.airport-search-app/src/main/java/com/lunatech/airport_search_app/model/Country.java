package com.lunatech.airport_search_app.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;



@SuppressWarnings("serial")
@Entity
@Table(name="Country")
public class Country extends ModelObject {
	
	@NaturalId
	@Column(name = "COUNTRY_CODE")
	private String code;
	
	@Column(name = "COUNTRY_NAME")
	private String name;
	
	@Column(name = "CONTINENT")
	private String continent;
	
	@Column(name = "WIKI_LINK")
	private String wiki_link;
	
	@Column(name = "KEYWORDS")
	private String keywords;
	
	@OneToMany(mappedBy = "country", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Airport> airports = new ArrayList<Airport>();
	
	public Country() { }
	
	public String getCode() { return code; }
	
	public void setCode(String code) { this.code = code; }
	
	public String getName() { return name; }	

	public void setName(String name) { this.name = name; }
	
	public String getContinent() { return continent; }
	
	public void setContinent(String continent) { this.continent = continent;}
	
	public String getWikiLink() { return wiki_link; }

	public void setWikiLink(String wiki_link) { this.wiki_link = wiki_link; }
	
	public String getKeywords() { return keywords; }
	
	public void setKeywords(String keywords) { this.keywords = keywords; }
	
	public List<Airport> getAirports() { return airports; }
	
	
    public void addAirport(Airport airport) {
        airports.add( airport );
        airport.setCountry( this );
    }

    public void removeAirport(Airport airport) {
        airports.remove( airport );
        airport.setCountry( null );
    }
    
	
}
