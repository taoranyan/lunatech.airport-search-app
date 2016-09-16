package com.lunatech.airport_search_app.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;


@SuppressWarnings("serial")
@Entity
@Table(name = "Airport")
public class Airport extends ModelObject{
	
	@NaturalId
	@Column(name = "AIRPORT_IDENT")
	private String ident;
	
	@Column(name = "TYPE")
	private String type;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "LATITDUE_DEG")
	private Float latitude_deg;
	
	@Column(name = "LONGITUDE_DEG")
	private Float longitude_deg;
	
	@Column(name = "ELEVATION_FT")
	private Integer elevation_ft;
	
	@Column(name = "CONTINENT")
	private String continent;
	
	@Column(name = "ISO_COUNTRY")
	private String iso_country;
	
	@Column(name = "ISO_REGION")
	private String iso_region;
	
	@Column(name = "MUNICIPALITY")
	private String municipality;
	
	@Column(name = "SCHEDULED_SERVICE")
	private String scheduled_service;
	
	@Column(name = "GPS_CODE")
	private String gps_code;
	
	@Column(name = "IATA_CODE")
	private String iata_code;
	
	@Column(name = "LOCAL_CODE")
	private String local_code;
	
	@Column(name = "HOME_LINK")
	private String home_link;
	
	@Column(name = "WIKI_LINK")
	private String wiki_link;
	
	@Column(name = "KEYWORDS")
	private String keywords;
	
	@ManyToOne
	@JoinColumn(name="COUNTRY_OF_CURR_AIRPORT", referencedColumnName = "COUNTRY_NAME")
	private Country country;
	
	@OneToMany(mappedBy = "airport", cascade = CascadeType.ALL)
	private List<Runway> runways = new ArrayList<Runway>();

	
	public String getIdent() { return ident;}
	
	public void setIdent(String ident) { this.ident = ident;}
	
	public String getType() {return type;}
	
	public void setType(String type) { this.type = type; }
	
	public String getName() { return name; }
	
	public void setName(String name) { this.name = name; }
	
	public Float getLatitudeDeg() { return latitude_deg ;}
	
	public void setLatitudeDeg(Float d) { this.latitude_deg = d; }
	
	public Float getLongitudeDeg() { return longitude_deg; }
	
	public void setLongitudeDeg(Float longitude_deg) { this.longitude_deg = longitude_deg;}
	
	public Integer getElevationFT() { return elevation_ft; }
	
	public void setElevationFT(Integer elevation_ft) { this.elevation_ft = elevation_ft; }
	
	public String getIsoRegion() { return iso_region; }
	
	public void setIsoRegion(String iso_region) { this.iso_region = iso_region; }
	
	public String getMunicipality() { return municipality; }
	
	public void setMunicipality(String municipality) { this.municipality = municipality; }
	
	public String getScheduledService() { return scheduled_service; }
	
	public void setScheduledService(String scheduled_service) { this.scheduled_service = scheduled_service; }
	
	public String getGPSCode() {return gps_code; }
	
	public void setGPSCode(String gps_code) {this.gps_code = gps_code; }
	
	public String getIataCode() {return iata_code; }
	
	public void setIataCode(String iata_code) {this.iata_code = iata_code; }
	
	public String getLocalCode() { return local_code; }
	
	public void setLocalCode(String local_code) {this.local_code = local_code; }
	
	public String getHomeLink(){ return home_link; }
	
	public void setHomeLink(String home_link) { this.home_link = home_link; }
	
	public String getWikiLink() { return wiki_link; }
	
	public void setWikiLink(String wiki_link) { this.wiki_link = wiki_link; }
	
	public String getKeywords() { return keywords; }
	
	public void setKeywords(String keywords) { this.keywords = keywords; }	
	
	public String getContinent() { return continent; }
	
	public void setContinent(String continent) { this.continent = continent; }
	
	public String getIsoCountry() { return iso_country; }
	
	public void setIsoCountry(String iso_country) { this.iso_country = iso_country; }
	
	public Country getCountry() { return country; }

    public void setCountry(Country country) { this.country = country; }
	
	public List<Runway> getRunways() { return runways; }

    public void addRunway(Runway runway) {
        runways.add( runway );
        runway.setAirport( this );
    }

    public void removeRunway(Runway runway) {
    	runways.remove( runway );
        runway.setAirport( null );
    }

	
	
	
	

}
