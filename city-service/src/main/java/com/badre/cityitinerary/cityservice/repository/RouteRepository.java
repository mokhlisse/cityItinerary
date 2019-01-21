package com.badre.cityitinerary.cityservice.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.badre.cityitinerary.cityservice.model.Route;

@Repository
public interface RouteRepository extends CrudRepository<Route, Integer> {

	/**
	 * find routes by city
	 * 
	 * @param city city to find routes from
	 * @return list of routes from city
	 */
	List<Route> findByCity(String city);

	/**
	 * find all routes
	 */
	List<Route> findAll();
}
