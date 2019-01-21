package com.badre.cityitinerary.itineraryservice.utils;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.badre.cityitinerary.itineraryservice.dijkstra.DijkstraShortestPath;
import com.badre.cityitinerary.itineraryservice.dijkstra.model.Edge;
import com.badre.cityitinerary.itineraryservice.dijkstra.model.Vertex;

/**
 * test {@link DijkstraShortestPath}
 *
 * @author <a href="mailto:mokhlisse_badre@yahoo.fr">Badre Edine Mokhlisse</a>
 */
public class DijkstraTest {

	@Test
	public void calculateShortestPathTest() {

		Vertex vertexA = new Vertex("A");
		Vertex vertexB = new Vertex("B");
		Vertex vertexC = new Vertex("C");
		Vertex vertexD = new Vertex("D");
		Vertex vertexE = new Vertex("E");

		vertexA.addNeighbour(new Edge(10, vertexA, vertexC));
		vertexA.addNeighbour(new Edge(17, vertexA, vertexB));
		vertexC.addNeighbour(new Edge(5, vertexC, vertexB));
		vertexC.addNeighbour(new Edge(9, vertexC, vertexD));
		vertexC.addNeighbour(new Edge(11, vertexC, vertexE));
		vertexB.addNeighbour(new Edge(1, vertexB, vertexD));
		vertexD.addNeighbour(new Edge(6, vertexD, vertexE));

		DijkstraShortestPath.computeShortestPaths(vertexA);

		Assert.assertEquals(vertexB.getDistance(), 15.0, 0);
		Assert.assertEquals(vertexC.getDistance(), 10.0, 0);
		Assert.assertEquals(vertexD.getDistance(), 16.0, 0);
		Assert.assertEquals(vertexE.getDistance(), 21.0, 0);

		List<Vertex> pathB = DijkstraShortestPath.getShortestPathTo(vertexB);
		Assert.assertTrue(pathB.get(0).getName().equalsIgnoreCase("A"));
		Assert.assertTrue(pathB.get(1).getName().equalsIgnoreCase("C"));
		Assert.assertTrue(pathB.get(2).getName().equalsIgnoreCase("B"));

		List<Vertex> pathC = DijkstraShortestPath.getShortestPathTo(vertexC);
		Assert.assertTrue(pathC.get(0).getName().equalsIgnoreCase("A"));
		Assert.assertTrue(pathC.get(1).getName().equalsIgnoreCase("C"));

		List<Vertex> pathD = DijkstraShortestPath.getShortestPathTo(vertexD);
		Assert.assertTrue(pathD.get(0).getName().equalsIgnoreCase("A"));
		Assert.assertTrue(pathD.get(1).getName().equalsIgnoreCase("C"));
		Assert.assertTrue(pathD.get(2).getName().equalsIgnoreCase("B"));
		Assert.assertTrue(pathD.get(3).getName().equalsIgnoreCase("D"));

		List<Vertex> pathE = DijkstraShortestPath.getShortestPathTo(vertexE);
		Assert.assertTrue(pathE.get(0).getName().equalsIgnoreCase("A"));
		Assert.assertTrue(pathE.get(1).getName().equalsIgnoreCase("C"));
		Assert.assertTrue(pathE.get(2).getName().equalsIgnoreCase("E"));
	}
}