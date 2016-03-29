package com.mrsun.dijkstra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * http://www.vogella.com/tutorials/JavaAlgorithmsDijkstra/article.html
 *
 * @author sundeep
 */
public class DijkstraAlgorithm {

    private final List<Vertex> nodes;
    private final List<Edge> edges;
    private Set<Vertex> settledNodes;
    private Set<Vertex> unsettledNodes;
    private Map<Vertex, Vertex> predecessors;
    private Map<Vertex, Integer> distance;

    public DijkstraAlgorithm(Graph graph) {
        this.nodes = new ArrayList<>(graph.getVertices());
        this.edges = new ArrayList<>(graph.getEdges());
    }

    public void execute(Vertex source) {
        settledNodes = new HashSet<>();
        unsettledNodes = new HashSet<>();
        predecessors = new HashMap<>();
        distance = new HashMap<>();
        distance.put(source, 0);
        unsettledNodes.add(source);
        while (unsettledNodes.size() > 0) {
            Vertex node = getMinimum(unsettledNodes);
            settledNodes.add(node);
            unsettledNodes.remove(node);
            findMinimalDistances(node);
        }
    }

    private void findMinimalDistances(Vertex node) {
        List<Vertex> neighbors = getNeighbors(node);
        for (Vertex v : neighbors) {
            if (getShortestDistance(v) > getShortestDistance(node) + getDistance(v, node)) {
                distance.put(v, getShortestDistance(node) + getDistance(v, node));
                predecessors.put(v, node);
                unsettledNodes.add(v);
            }
        }
    }

    private List<Vertex> getNeighbors(Vertex node) {
        List<Vertex> neighbors = new ArrayList<>();
        for (Edge edge : edges) {
            if (edge.getSource().equals(node) && !isSettled(node)) {
                neighbors.add(edge.getDestination());
            }
        }
        return neighbors;
    }

    private boolean isSettled(Vertex node) {
        return settledNodes.contains(node);
    }

    private int getDistance(Vertex source, Vertex target) {
        for (Edge edge : edges) {
            if (edge.getSource().equals(source) && edge.getDestination().equals(target)) {
                return edge.getWeight();
            }
        }
        throw new RuntimeException("No distance");
    }

    private Vertex getMinimum(Set<Vertex> unsettledNodes) {
        Vertex minimum = null;
        for (Vertex v : unsettledNodes) {
            if (minimum == null) {
                minimum = v;
            } else if (getShortestDistance(v) < getShortestDistance(minimum)) {
                minimum = v;
            }
        }
        return null;
    }

    private int getShortestDistance(Vertex v) {
        Integer d = distance.get(v);
        if (d == null) {
            return Integer.MAX_VALUE;
        } else {
            return d;
        }
    }

}
