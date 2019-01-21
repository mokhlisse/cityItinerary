package com.badre.cityitinerary.itineraryservice.dijkstra;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

import com.badre.cityitinerary.itineraryservice.dijkstra.model.Edge;
import com.badre.cityitinerary.itineraryservice.dijkstra.model.Vertex;

/**
 * Dijkstra algorithm to compute shortest path
 *
 * @author <a href="mailto:mokhlisse_badre@yahoo.fr">Badre Edine Mokhlisse</a>
 */
public class DijkstraShortestPath {

	/**
	 * compute shortest path from a source vertex
	 * 
	 * @param sourceVertex source vertex
	 */
	public static void computeShortestPaths(Vertex sourceVertex) {

		sourceVertex.setDistance(0);
		PriorityQueue<Vertex> priorityQueue = new PriorityQueue<>();
		priorityQueue.add(sourceVertex);
		sourceVertex.setVisited(true);

		while (!priorityQueue.isEmpty()) {
			// Getting the minimum distance vertex from priority queue
			Vertex actualVertex = priorityQueue.poll();

			for (Edge edge : actualVertex.getAdjacenciesList()) {

				Vertex v = edge.getTargetVertex();
				if (!v.isVisited()) {
					double newDistance = actualVertex.getDistance() + edge.getWeight();

					if (newDistance < v.getDistance()) {
						priorityQueue.remove(v);
						v.setDistance(newDistance);
						v.setPredecessor(actualVertex);
						priorityQueue.add(v);
					}
				}
			}
			actualVertex.setVisited(true);
		}
	}

	/**
	 * get shortest path to a target vertex after executing Dijkstra algorithm
	 * 
	 * @param targetVertex
	 * @return
	 */
	public static List<Vertex> getShortestPathTo(Vertex targetVertex) {
		List<Vertex> path = new ArrayList<>();

		for (Vertex vertex = targetVertex; vertex != null; vertex = vertex.getPredecessor()) {
			path.add(vertex);
		}

		Collections.reverse(path);
		return path;
	}

}