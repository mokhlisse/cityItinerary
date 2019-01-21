package com.badre.cityitinerary.itineraryservice.clients;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.badre.cityitinerary.itineraryservice.model.Route;

/**
 * contains city rest services
 *
 * @author <a href="mailto:mokhlisse_badre@yahoo.fr">Badre Edine Mokhlisse</a>
 */
@Component
public class CityRestTemplateClient {

	@Autowired
	private RestTemplate restTemplate;

	/**
	 * fetch all routes from city service
	 * 
	 * @return
	 */
	public List<Route> getAllRoutes() {

		ResponseEntity<List<Route>> restExchange = restTemplate.exchange(
				"http://cityservice/v1/city/all", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Route>>() {
				});

		return restExchange.getBody();
	}

	/**
	 * fetch all routes starting from a given city
	 * 
	 * @param city city routes should start from
	 * @return list of routes starting from that city
	 */
	public List<Route> getRoutes(String city) {

		ResponseEntity<List<Route>> restExchange = restTemplate.exchange(
				"http://cityservice/v1/city/adjacents/{city}", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Route>>() {
				}, city);

		return restExchange.getBody();
	}
}
