package com.jpizarro.th.server.place.view.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.jpizarro.th.lib.place.entity.PlaceTO;
import com.jpizarro.th.lib.place.util.PlaceRestURL;
import com.jpizarro.th.server.generic.model.persistence.util.exceptions.DuplicateInstanceException;
import com.jpizarro.th.server.generic.model.persistence.util.exceptions.InstanceNotFoundException;
import com.jpizarro.th.server.generic.util.ResourceNotFoundException;
import com.jpizarro.th.server.generic.view.rest.GenericController;
import com.jpizarro.th.server.place.model.service.PlaceService;

@Controller
@RequestMapping(PlaceRestURL.ENTITY)
public class PlaceController implements GenericController <PlaceTO, Long>{
	@Autowired
	private PlaceService placeService;
	private String XML_VIEW_NAME = "users";
	
	@RequestMapping(method=RequestMethod.GET, value=PlaceRestURL.ENTITY_ID,
			headers="Accept=application/xml")
	@ResponseBody
	public PlaceTO getEntity(@PathVariable Long id) {
		PlaceTO to = null;
		try {
			to = placeService.find(id);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ResourceNotFoundException();
		} catch (InstanceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ResourceNotFoundException();
		}
		return to;
//		return new ModelAndView(XML_VIEW_NAME, BindingResult.MODEL_KEY_PREFIX+"object", to);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value=PlaceRestURL.ENTITY_ID)
	public ModelAndView removeEntity(@PathVariable Long id) {
		boolean ret = true;
		try {
			placeService.remove(id);
		} catch (InstanceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ret = false;
			throw new ResourceNotFoundException();
		}
		
		return new ModelAndView(XML_VIEW_NAME, BindingResult.MODEL_KEY_PREFIX+"user", ret);
	}

	@Override
	public List<PlaceTO> getEntities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(method=RequestMethod.PUT, value=PlaceRestURL.ENTITY_ID)
	@ResponseBody
	public PlaceTO updateEntity(@PathVariable Long id, @RequestBody PlaceTO entity) {
		// TODO Auto-generated method stub
		try {
			entity.setPlaceId(id);
			return placeService.update(entity);
		} catch (InstanceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ResourceNotFoundException();
		}
//		return null;
	}

	@Override
	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	@ResponseStatus(value=HttpStatus.CREATED)
	public PlaceTO addEntity(@RequestBody PlaceTO body) {
		// TODO Auto-generated method stub
		PlaceTO r =null;
		try {
			r = placeService.create(body);
		} catch (DuplicateInstanceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return r; 
	}
}
