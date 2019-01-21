package com.badre.cityitinerary.itineraryservice.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.badre.cityitinerary.itineraryservice.clients.CityRestTemplateClient;
import com.badre.cityitinerary.itineraryservice.dijkstra.DijkstraShortestPath;
import com.badre.cityitinerary.itineraryservice.dijkstra.model.Edge;
import com.badre.cityitinerary.itineraryservice.dijkstra.model.Vertex;
import com.badre.cityitinerary.itineraryservice.model.Route;
import com.badre.cityitinerary.itineraryservice.model.WeightCriteria;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Service
public class ItineraryService {

	private static final Logger logger = LoggerFactory.getLogger(ItineraryService.class);

	@Autowired
	private CityRestTemplateClient cityRestClient;

	/**
	 * calculate shortest itinerary from source city to destiny city
	 * 
	 * @param source source city
	 * @param destiny destiny city
	 * @return
	 */
	public List<Route> calculateSortestItinerary(String source, String destiny,
			WeightCriteria criteria) {

		// fetch all routes from city service
		List<Route> routes = getAllRoutes();

		Map<String, Vertex> graph = buildGraph(routes, criteria);
		DijkstraShortestPath.computeShortestPaths(graph.get(source));

		// build a result path
		List<Route> path = new ArrayList<>();
		for (Vertex vertex = graph.get(destiny); vertex != null
				&& vertex.getPredecessor() != null; vertex = vertex.getPredecessor()) {

			String vertexName = vertex.getName();
			String predecessorName = vertex.getPredecessor().getName();

			path.add(routes.stream()
					.filter(route -> route.getCity().equalsIgnoreCase(predecessorName)
							&& route.getDestiny().equalsIgnoreCase(vertexName))
					.findAny().orElse(null));
		}
		// reverse path
		Collections.reverse(path);

		return path;
	}

	/**
	 * get all routes
	 */
	@HystrixCommand(fallbackMethod = "fallbackGetAllRoutes", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000"/* 2000 */) }, threadPoolProperties = {
					@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
					@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "75"),
					@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "7000"),
					@HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "15000"),
					@HystrixProperty(name = "metrics.rollingStats.numBuckets", value = "5") })
	private List<Route> getAllRoutes() {

		return cityRestClient.getAllRoutes();
	}

	@SuppressWarnings("unused")
	private List<Route> fallbackGetAllRoutes() {

		logger.error("get all routes service timedout");
		return new ArrayList<>();
	}

	/**
	 * build a vertexes graph
	 * 
	 * @param criteria
	 * @return
	 */
	private Map<String, Vertex> buildGraph(List<Route> routes, WeightCriteria criteria) {

		Map<String, Vertex> map = new HashMap<>();
		for (Route route : routes) {
			Vertex vertexA, vertexB;
			String source = route.getCity().toLowerCase();
			String destiny = route.getDestiny().toLowerCase();

			if (!map.containsKey(source)) {
				vertexA = new Vertex(source);
				map.put(source, vertexA);
			}
			if (!map.containsKey(destiny)) {
				vertexB = new Vertex(destiny);
				map.put(destiny, vertexB);
			}
			vertexA = map.get(source);
			vertexB = map.get(destiny);
			double weight = criteria.equals(WeightCriteria.TIME) ? route.getDuration() : 1;
			vertexA.addNeighbour(new Edge(weight, vertexA, vertexB));
		}
		return map;
	}
}
