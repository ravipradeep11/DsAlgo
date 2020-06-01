package com.test.graphs;

/**
 * CSE 373, Winter 2011, Jessica Miller
 * Representation of a directed graph edge.
 */
public class Edge<V> {
    public V from, to;
    public int weight;

    public Edge(V from, V to, int weight) {
        if (from == null || to == null) {
            throw new IllegalArgumentException("null");
        }
        this.from = from;
        this.to = to;
        this.weight = weight;
    }


    public String toString() {
        return "<" + from + ", " + to + ", " + weight + ">";
    }
}