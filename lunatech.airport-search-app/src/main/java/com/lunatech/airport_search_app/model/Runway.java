package com.lunatech.airport_search_app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@SuppressWarnings("serial")
@Entity
@Table(name = "Runway")
public class Runway extends ModelObject{
	
	@Column(name = "AIRPORT_REF")
	private Integer airport_ref;
	
	@Column(name = "AIRPORT_IDENT")
	private String airport_ident;
	
	@Column(name = "LENGTH_FT")
	private Integer length_ft;
	
	@Column(name = "WIDTH_FT")
	private Integer width_ft;
	
	@Column(name = "SURFACE")
	private String surface;
	
	@Column(name = "LIGHTED")
	private String lighted;
	
	@Column(name = "CLOSED")
	private String closed;
	
	@Column(name = "LE_IDENT")
	private String le_ident;
	
	@Column(name = "LE_LATITUDE_DEG")
	private Float le_latitude_deg;
	
	@Column(name = "LE_LONGITUDE_DEG")
	private Float le_longitude_deg;
	
	@Column(name = "LE_ELEVATION_FT")
	private Integer le_elevation_ft;
	
	@Column(name = "LE_HEADING_DEGT")
	private Float le_heading_degT;
	
	@Column(name = "LE_DISPLACED_THRESHOLD_FT")
	private Integer le_displaced_threshold_ft;
	
	@Column(name = "HE_IDENT")
	private String he_ident;
	
	@Column(name = "HE_LATITUDE_DEG")
	private Float he_latitude_deg;
	
	@Column(name = "HE_LONGITUTDE_DEG")
	private Float he_longitude_deg;
	
	@Column(name = "HE_ELEVATION_FT")
	private Integer he_elevation_ft;
	
	@Column(name = "HE_HEADING_DEGT")
	private Float he_heading_degT;
	
	@Column(name = "HE_DISPLACED_THRESHOLD_FT")
	private Integer he_displaced_threshold_ft;
	
	@ManyToOne
	@JoinColumn(name = "AIRPORT_OF_CURR_RUNWAY", referencedColumnName= "airport_ident")
	private Airport airport;
	
	public Runway() {}
	
	public Runway(String surface) { this.surface = surface; }
	
	public Integer getAirportRef() { return airport_ref; }
	
	public void setAirportRef(Integer airport_ref) { this.airport_ref = airport_ref; }
	
	public String getAirportIdent() { return airport_ident; }
	
	public void setAirportIdent( String airport_ident ) { this.airport_ident = airport_ident;}
	
	public Integer getLengthFt() { return length_ft; }
	
	public void setLengthFt(Integer length_ft) { this.length_ft = length_ft; }
	
	public Integer getWidthFt() { return width_ft; }
	
	public void setWidthFt(Integer width_ft) { this.width_ft = width_ft; }
	
	public String getSurface() { return surface; }
	
	public void setSurface(String surface) { this.surface = surface; }
	
	public String getLighted() { return lighted; }
	
	public void setLighted(String lighted) { this.lighted = lighted; }
	
	public String getClosed() { return closed; }
	
	public void setClosed(String closed) { this.closed = closed; }
	
	public String getLeIdent() { return le_ident; }
	
	public void setLeIdent(String le_ident) { this.le_ident = le_ident; }
	
	public Float getLeLatitudeDeg() { return le_latitude_deg; }
	
	public void setLeLatitudeDeg(Float le_latitude_deg) { this.le_latitude_deg = le_latitude_deg;}
	
	public Float getLeLongitudeDeg() { return le_longitude_deg; }
	
	public void setLeLongitudeDeg(Float le_longitude_deg) { this.le_longitude_deg = le_longitude_deg;}
	
	public Integer getLeElevationFt() { return le_elevation_ft; }
	
	public void setLeElevationFt(Integer le_elevation_ft) { this.le_elevation_ft = le_elevation_ft; }
	
	public Float getLeHeadingDegT() {return le_heading_degT; }
	
	public void setLeHeadingDegT(Float le_heading_degT) {this.le_heading_degT = le_heading_degT;}
	
	public Integer getLeDisplacedThreshFt() { return le_displaced_threshold_ft; }
	
	public void setLeDisplacedThreshFt(Integer le_displaced_threshold_ft) { this.le_displaced_threshold_ft = le_displaced_threshold_ft; }
	
	public String getHeIdent() { return he_ident; }
	
	public void setHeIdent(String he_ident) { this.he_ident = he_ident; }

	public Float getHeLatitudeDeg() { return he_latitude_deg; }
	
	public void setHeLatitudeDeg(Float he_latitude_deg) { this.he_latitude_deg = he_latitude_deg;}
	
	public Float getHeLongitudeDeg() { return he_longitude_deg; }
	
	public void setHeLongitudeDeg(Float he_longitude_deg) { this.he_longitude_deg = he_longitude_deg;}
	
	public Integer getHeElevationFt() { return he_elevation_ft; }
	
	public void setHeElevationFt(Integer he_elevation_ft) { this.he_elevation_ft = he_elevation_ft; }
	
	public Float getHeHeadingDegT() {return he_heading_degT; }
	
	public void setHeHeadingDegT(Float he_heading_degT) {this.he_heading_degT = he_heading_degT;}
	
	public Integer getHeDisplacedThreshFt() { return he_displaced_threshold_ft; }
	
	public void setHeDisplacedThreshFt(Integer he_displaced_threshold_ft) { this.he_displaced_threshold_ft = he_displaced_threshold_ft; }

	public Airport getAirport() { return airport; }

    public void setAirport(Airport airport) { this.airport = airport; }


}
