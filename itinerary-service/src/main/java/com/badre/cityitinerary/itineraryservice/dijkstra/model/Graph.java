package com.badre.cityitinerary.itineraryservice.dijkstra.model;

import java.util.List;

/**
 * represents a graph with edges and vertexes
 *
 * @author <a href="mailto:mokhlisse_badre@yahoo.fr">Badre Edine Mokhlisse</a>
 */
public class Graph {
	private final List<Vertex> vertexes;
	private final List<Edge> edges;

	public Graph(List<Vertex> vertexes, List<Edge> edges) {
		this.vertexes = vertexes;
		this.edges = edges;
	}

	public List<Vertex> getVertexes() {
		return vertexes;
	}

	public List<Edge> getEdges() {
		return edges;
	}

}
