package com.pomodorotimer.pomodorotimer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Strongly Connected Components (SCC) implementation using Kosaraju's algorithm.
 * Used for network cluster analysis in directed graphs.
 * 
 * <p>Use-case: Network cluster analysis tool where we need to identify
 * groups of nodes that are mutually reachable in a directed graph.</p>
 * 
 * <p>Time Complexity: O(V + E) where V is vertices and E is edges</p>
 * <p>Space Complexity: O(V + E)</p>
 * 
 * @author Data Structures Project Team
 * @version 1.0
 */
public class StronglyConnectedComponents {
    
    private final int vertices;
    private final List<List<Integer>> graph;
    private final List<List<Integer>> reverseGraph;
    
    /**
     * Constructs an SCC finder for a graph with specified number of vertices.
     * 
     * @param vertices number of vertices
     */
    public StronglyConnectedComponents(int vertices) {
        this.vertices = vertices;
        this.graph = new ArrayList<>();
        this.reverseGraph = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            graph.add(new ArrayList<>());
            reverseGraph.add(new ArrayList<>());
        }
    }
    
    /**
     * Adds a directed edge to the graph.
     * 
     * @param from source vertex
     * @param to destination vertex
     */
    public void addEdge(int from, int to) {
        if (from >= 0 && from < vertices && to >= 0 && to < vertices) {
            graph.get(from).add(to);
            reverseGraph.get(to).add(from);
        }
    }
    
    /**
     * Finds all strongly connected components using Kosaraju's algorithm.
     * 
     * @return list of strongly connected components, each component is a list of vertices
     */
    public List<List<Integer>> findSCCs() {
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        boolean[] visited = new boolean[vertices];
        
        // Step 1: Fill stack with vertices in order of finishing times (DFS)
        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                fillOrder(i, visited, stack);
            }
        }
        
        // Step 2: Reverse the graph (already done in constructor)
        // Step 3: Process vertices in reverse order of finishing times
        Arrays.fill(visited, false);
        List<List<Integer>> sccs = new ArrayList<>();
        
        while (!stack.isEmpty()) {
            int vertex = stack.pop();
            if (!visited[vertex]) {
                List<Integer> component = new ArrayList<>();
                dfsReverse(vertex, visited, component);
                sccs.add(component);
            }
        }
        
        return sccs;
    }
    
    private void fillOrder(int vertex, boolean[] visited, java.util.Stack<Integer> stack) {
        visited[vertex] = true;
        for (int neighbor : graph.get(vertex)) {
            if (!visited[neighbor]) fillOrder(neighbor, visited, stack);
        }
        stack.push(vertex);
    }
    
    private void dfsReverse(int vertex, boolean[] visited, List<Integer> component) {
        visited[vertex] = true;
        component.add(vertex);
        for (int neighbor : reverseGraph.get(vertex)) {
            if (!visited[neighbor]) dfsReverse(neighbor, visited, component);
        }
    }
    
    /**
     * Returns the number of strongly connected components.
     * 
     * @return number of SCCs
     */
    public int getSCCCount() {
        return findSCCs().size();
    }
}

