package com.jpizarro.th.server.place.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpizarro.th.lib.place.entity.PlaceTO;
import com.jpizarro.th.server.generic.model.persistence.util.exceptions.DuplicateInstanceException;
import com.jpizarro.th.server.generic.model.persistence.util.exceptions.InstanceNotFoundException;
import com.jpizarro.th.server.place.model.entity.Place;
import com.jpizarro.th.server.place.model.persistence.accessor.PlaceAccessor;
import com.jpizarro.th.server.place.util.PlaceUtils;

@Service
public class PlaceServiceImpl implements PlaceService {
	@Autowired
	private PlaceAccessor placeAccessor;
	
	@Override
	public PlaceTO create(PlaceTO entity) throws DuplicateInstanceException {
		Place place = PlaceUtils.placeFromPlaceTO(entity);
		placeAccessor.create(place);
		return PlaceUtils.placeTOFromPlace(place);
		
	}

	@Override
	public PlaceTO find(Long id) throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		Place place = placeAccessor.find(id);
		PlaceTO placeTO = PlaceUtils.placeTOFromPlace(place);
		return placeTO;
	}

	@Override
	public boolean exists(Long id) {
		// TODO Auto-generated method stub
		return placeAccessor.exists(id);
	}

	@Override
	public PlaceTO update(PlaceTO entity) {
		Place place = PlaceUtils.placeFromPlaceTO(entity);
		place = placeAccessor.update(place);
		return PlaceUtils.placeTOFromPlace(place);
	}

	@Override
	public void remove(Long id) throws InstanceNotFoundException {
		placeAccessor.remove(id);
		
	}
}
