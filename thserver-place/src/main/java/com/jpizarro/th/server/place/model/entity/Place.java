package com.jpizarro.th.server.place.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Place {
	private long placeId;
	
	private int latitude;
	private int longitude;

	private String name;
	private String description;
	
	private String type = new String();
	
	public Place() {
		super();
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO,
            generator="PlaceIdGenerator")
    @SequenceGenerator(             // It only takes effect for
            name="PlaceIdGenerator", // databases providing identifier
            sequenceName="PlaceSeq") // generators.
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
		return "Place [description=" + description 
				+ ", latitude=" + latitude + ", longitude=" + longitude
				+ ", name=" + name + ", placeId=" + placeId + ", type=" + type
				+ "]";
	}

}
