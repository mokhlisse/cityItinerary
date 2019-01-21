package com.badre.cityitinerary.itineraryservice.dijkstra.model;

/**
 * This class contains Source vertex, target vertex, and weight
 *
 * @author <a href="mailto:mokhlisse_badre@yahoo.fr">Badre Edine Mokhlisse</a>
 */
public class Edge {

	private double weight;
	private Vertex startVertex;
	private Vertex targetVertex;

	public Edge(double weight, Vertex startVertex, Vertex targetVertex) {
		this.weight = weight;
		this.startVertex = startVertex;
		this.targetVertex = targetVertex;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public Vertex getStartVertex() {
		return startVertex;
	}

	public void setStartVertex(Vertex startVertex) {
		this.startVertex = startVertex;
	}

	public Vertex getTargetVertex() {
		return targetVertex;
	}

	public void setTargetVertex(Vertex targetVertex) {
		this.targetVertex = targetVertex;
	}
}