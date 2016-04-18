package com.mrsun.hackerrank.challenges;

public class Edge {

    private final int v1;
    private final int v2;
    private final double weight;

    public Edge() {
        weight = 0;
        v1 = 0;
        v2 = 0;
    }

    public Edge(int v1, int v2, double wt) {
        this.v1 = v1;
        this.v2 = v2;
        weight = wt;
    }

    public int getVertex1() {
        return v1;
    }

    public int getVertex2() {
        return v2;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "from: " + v1 + " to: " + v2 + " weight: " + weight;
    }

}
