package com.jpizarro.th.server.team.view.web.ws;

import org.apache.wicket.PageParameters;
import org.wicketstuff.annotation.mount.MountPath;
import org.wicketstuff.annotation.strategy.MountMixedParam;

import com.jpizarro.th.lib.place.entity.PlaceTO;
import com.jpizarro.th.lib.place.util.xml.xstream.PlaceXStreamFactory;

import com.jpizarro.th.server.generic.model.persistence.util.exceptions.InstanceNotFoundException;
import com.jpizarro.th.server.generic.view.web.ws.util.GenericWS;
import com.jpizarro.th.server.place.model.service.PlaceService;
import com.jpizarro.th.server.place.view.web.application.WicketApplication;

import com.thoughtworks.xstream.XStream;

@MountPath(path = "/ws/findById")
@MountMixedParam(parameterNames={"placeId"})
public class FindByIdWS extends GenericWS {

	public FindByIdWS(PageParameters parameters) {
		super(parameters, new PlaceXStreamFactory());
		// TODO Auto-generated constructor stub
	}

	public void	doExecute(PageParameters parameters){
		long teamId = parameters.getLong("placeId");
		
		PlaceService gameService = WicketApplication.get().getPlaceService();
		try {
			PlaceTO teamTO = gameService.find(teamId);
			
			XStream xf = xStreamFactory.createXStream();
			this.selement = xf.toXML(teamTO);
//			this.element = TOToXMLConversor.toXML(teamTO);
		} catch (InstanceNotFoundException e) {
			System.out.println("IOIO : " + e.getMessage());
		}
	}

}
