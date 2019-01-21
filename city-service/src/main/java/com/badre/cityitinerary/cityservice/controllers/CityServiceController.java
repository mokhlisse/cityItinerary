package com.badre.cityitinerary.cityservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.badre.cityitinerary.cityservice.model.Route;
import com.badre.cityitinerary.cityservice.services.RouteService;

import io.swagger.annotations.ApiOperation;

/**
 * City controller
 *
 * @author <a href="mailto:mokhlisse_badre@yahoo.fr">Badre Edine Mokhlisse</a>
 */
@RestController
@RequestMapping(value = "/v1/city")
public class CityServiceController {

	@Autowired
	private RouteService routeService;

	/**
	 * return a route by id
	 * 
	 * @param route id
	 * @return route defined by id
	 */
	@RequestMapping(value = "/{routeId}", method = RequestMethod.GET)
	@ApiOperation(value = "Finds Route by id", response = Route.class)
	public Route getRoute(@PathVariable("routeId") Integer routeId) {

		return routeService.getRoute(routeId);
	}

	/**
	 * return adjacent routes from a source
	 * 
	 * @param city source
	 * @return adjacent routes
	 */
	@RequestMapping(value = "/adjacents/{city}", method = RequestMethod.GET)
	@ApiOperation(value = "Finds Routes starting from a city", response = Route.class, responseContainer = "List")
	public List<Route> getRoutesFrom(@PathVariable("city") String name) {

		return routeService.getRoutesFrom(name);
	}

	/**
	 * get all routes
	 * 
	 * @return all routes
	 */
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	@ApiOperation(value = "Finds all routes", response = Route.class, responseContainer = "List")
	public List<Route> getAllRoutes() {

		return routeService.getRoutesAll();
	}

	/**
	 * update a route
	 * 
	 * @param routeId route id to update
	 * @param route new route
	 */
	@RequestMapping(value = "{routeId}", method = RequestMethod.PUT)
	public void updateRoute(@PathVariable("routeId") Integer routeId, @RequestBody Route route) {
		routeService.updateRoute(route);
	}

	/**
	 * add a new route
	 * 
	 * @param route new route to add
	 */
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public void saveCity(@RequestBody Route route) {
		routeService.saveRoute(route);
	}

	/**
	 * delete a route
	 * 
	 * @param routeId route id to delete
	 * @param route
	 */
	@RequestMapping(value = "{routeId}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteRoute(@PathVariable("routeId") Integer routeId) {
		routeService.deleteRoute(routeId);
	}
}