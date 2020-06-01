package com.test.graphs;

/**
 * CSE 373, Winter 2011, Jessica Miller
 * A utility class that attaches some "bookkeeping" information to
 * a vertex.  Used when searching the graph for a path between two
 * vertices.
 */
public class VertexInfo<V> {
    /** The vertex itself. */
    public V v;

    /** A mark for whether this vertex has been visited.  Useful for path searching. */
    public boolean visited;
    
    /** Constructs information for the given vertex. */
    public VertexInfo(V v) {
        this.v = v;
        this.clear();
    }
    
    /** Resets the visited field. */
    public void clear() {
        this.visited = false;
    }
}