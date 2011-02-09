package com.jpizarro.th.lib.place.entity;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("place")
public class PlaceTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6003312565456112948L;
	
	private long placeId;
	
	private int latitude;
	private int longitude;
	private String name;
	private String description;
	
	private String type = new String();
	

	public PlaceTO() {
		super();
		// TODO Auto-generated constructor stub
	}
//	public PlaceTO(Place place) {
//		super();
//		this.placeId = place.getPlaceId();
//		this.latitude = place.getLatitude();
//		this.longitude = place.getLongitude();
//		this.name = place.getName();
//		this.description = place.getDescription();
//		this.type = place.getType();
//
//	}

	public PlaceTO(long placeId, int latitude, int longitude, String name,
			String description, String type) {
		super();
		this.placeId = placeId;
		this.latitude = latitude;
		this.longitude = longitude;
		this.name = name;
		this.description = description;
		this.type = type;
	}

	public PlaceTO(long placeId, int latitude, int longitude, String name,
			String description) {
		super();
		this.placeId = placeId;
		this.latitude = latitude;
		this.longitude = longitude;
		this.name = name;
		this.description = description;
	}

	public PlaceTO(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

	public long getPlaceId() {
		return placeId;
	}

	public void setPlaceId(long placeId) {
		this.placeId = placeId;
	}

	public int getLatitude() {
		return latitude;
	}

	public void setLatitude(int latitude) {
		this.latitude = latitude;
	}

	public int getLongitude() {
		return longitude;
	}

	public void setLongitude(int longitude) {
		this.longitude = longitude;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "PlaceTO [description=" + description + ", latitude=" + latitude
				+ ", longitude=" + longitude + ", name=" + name + ", placeId="
				+ placeId + ", type=" + type + "]";
	}
	
	

}
