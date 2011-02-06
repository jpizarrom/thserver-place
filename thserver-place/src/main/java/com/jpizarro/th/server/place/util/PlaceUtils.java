package com.jpizarro.th.server.place.util;

import java.util.ArrayList;
import java.util.List;

import com.jpizarro.th.lib.place.entity.PlaceTO;
import com.jpizarro.th.server.place.model.entity.Place;

public class PlaceUtils {

	public static PlaceTO placeTOFromPlace(Place place) {
		PlaceTO to = new PlaceTO();
		
		to.setPlaceId( place.getPlaceId());

		to.setName( place.getName());
		to.setDescription( place.getDescription());

		to.setType( place.getType());
		
		to.setLatitude( place.getLatitude());
		to.setLongitude( place.getLongitude());
		
		return to;
	}
}
