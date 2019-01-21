package com.badre.cityitinerary.itineraryservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.badre.cityitinerary.itineraryservice.model.WeightCriteria;
import com.badre.cityitinerary.itineraryservice.model.WeightCriteriaEnumConverter;
import com.badre.cityitinerary.itineraryservice.model.Route;
import com.badre.cityitinerary.itineraryservice.services.ItineraryService;

import io.swagger.annotations.ApiOperation;

/**
 * Itinerary controller
 *
 * @author <a href="mailto:mokhlisse_badre@yahoo.fr">Badre Edine Mokhlisse</a>
 */
@RestController
@RequestMapping(value = "/v1/itinerary")
public class ItineraryController {

	@Autowired
	ItineraryService service;

	@RequestMapping(value = "/sortest", method = RequestMethod.GET)
	@ApiOperation(value = "Calculates the sortest way between two cities", response = Route.class, responseContainer = "List")
	public List<Route> sortestItineraryInTime(@RequestParam(required = true) String from,
			@RequestParam(required = true) String to,
			@RequestParam(name = "criteria", required = false, defaultValue = "time") WeightCriteria criteria) {

		return service.calculateSortestItinerary(from.toLowerCase(), to.toLowerCase(), criteria);
	}

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		dataBinder.registerCustomEditor(WeightCriteria.class, new WeightCriteriaEnumConverter());
	}
}