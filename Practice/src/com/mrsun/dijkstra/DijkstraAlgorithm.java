package com.mrsun.dijkstra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
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
    
    public void execute(Vertex source){
        settledNodes = new HashSet<>();
        unsettledNodes = new HashSet<>();
        predecessors = new HashMap<>();
        distance = new HashMap<>();
        distance.put(source, 0);
        
    }
    
    private int getDistance(Vertex source, Vertex target){
        for(Edge edge : edges){
            if(edge.getSource().equals(source) && edge.getDestination().equals(target))
                return edge.getWeight();
        }
        throw new RuntimeException("No distance");
    }
    
    
    
    
}
