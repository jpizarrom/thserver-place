package com.jpizarro.th.server.place.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpizarro.th.lib.place.entity.PlaceTO;
import com.jpizarro.th.server.generic.model.persistence.util.exceptions.DuplicateInstanceException;
import com.jpizarro.th.server.generic.model.persistence.util.exceptions.InstanceNotFoundException;
import com.jpizarro.th.server.place.model.entity.Place;
import com.jpizarro.th.server.place.model.persistence.accessor.PlaceAccessor;

@Service
public class PlaceServiceImpl implements PlaceService {
	@Autowired
	private PlaceAccessor placeAccessor;
	
	@Override
	public void create(PlaceTO entity) throws DuplicateInstanceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PlaceTO find(Long id) throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		Place place = placeAccessor.find(id);
		PlaceTO placeTO = new PlaceTO();
		return placeTO;
	}

	@Override
	public boolean exists(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public PlaceTO update(PlaceTO entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(Long id) throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		
	}
}
