package com.badre.cityitinerary.cityservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.badre.cityitinerary.cityservice.config.ServiceConfig;
import com.badre.cityitinerary.cityservice.model.Route;
import com.badre.cityitinerary.cityservice.repository.RouteRepository;

/**
 * Route service
 *
 * @author <a href="mailto:mokhlisse_badre@yahoo.fr">Badre Edine Mokhlisse</a>
 */
@Service
public class RouteService {

	@Autowired
	private RouteRepository routeRepository;

	@Autowired
	ServiceConfig config;

	public Route getRoute(Integer routeId) {
		return routeRepository.findOne(routeId);
	}

	public List<Route> getRoutesAll() {
		return routeRepository.findAll();
	}

	public List<Route> getRoutesFrom(String name) {
		return routeRepository.findByCity(name);
	}

	public void saveRoute(Route route) {
		routeRepository.save(route);
	}

	public void updateRoute(Route route) {
		routeRepository.save(route);
	}

	public void deleteRoute(Integer routeId) {
		routeRepository.delete(routeId);
	}
}
