package com.pomodorotimer.pomodorotimer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Graph implementation for BFS and DFS algorithms.
 * Used for maze/graph exploration.
 * 
 * <p>Use-case: Maze/graph exploration where we need to traverse
 * nodes and find paths between them.</p>
 * 
 * @author Data Structures Project Team
 * @version 1.0
 */
public class Graph {
    
    private final int vertices;
    private final List<List<Integer>> adjacencyList;
    
    /**
     * Constructs a graph with specified number of vertices.
     * 
     * @param vertices number of vertices
     */
    public Graph(int vertices) {
        this.vertices = vertices;
        this.adjacencyList = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }
    
    /**
     * Adds an edge between two vertices.
     * 
     * @param from source vertex
     * @param to destination vertex
     */
    public void addEdge(int from, int to) {
        if (from >= 0 && from < vertices && to >= 0 && to < vertices) {
            adjacencyList.get(from).add(to);
        }
    }
    
    /**
     * Performs Breadth-First Search starting from a vertex.
     * 
     * @param start starting vertex
     * @return list of vertices in BFS order
     */
    public List<Integer> bfs(int start) {
        List<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new Queue<>();
        
        visited[start] = true;
        queue.enqueue(start);
        
        while (!queue.isEmpty()) {
            int vertex = queue.dequeue();
            result.add(vertex);
            
            for (int neighbor : adjacencyList.get(vertex)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.enqueue(neighbor);
                }
            }
        }
        
        return result;
    }
    
    /**
     * Performs Depth-First Search starting from a vertex.
     * 
     * @param start starting vertex
     * @return list of vertices in DFS order
     */
    public List<Integer> dfs(int start) {
        List<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[vertices];
        dfsHelper(start, visited, result);
        return result;
    }
    
    private void dfsHelper(int vertex, boolean[] visited, List<Integer> result) {
        visited[vertex] = true;
        result.add(vertex);
        for (int neighbor : adjacencyList.get(vertex)) {
            if (!visited[neighbor]) {
                dfsHelper(neighbor, visited, result);
            }
        }
    }
    
    /**
     * Finds shortest path using BFS.
     * 
     * @param start starting vertex
     * @param end destination vertex
     * @return list of vertices representing the shortest path, or empty list if no path exists
     */
    public List<Integer> shortestPath(int start, int end) {
        if (start == end) {
            return Collections.singletonList(start);
        }
        
        boolean[] visited = new boolean[vertices];
        int[] parent = new int[vertices];
        Arrays.fill(parent, -1);
        Queue<Integer> queue = new Queue<>();
        
        visited[start] = true;
        queue.enqueue(start);
        
        while (!queue.isEmpty()) {
            int vertex = queue.dequeue();
            
            for (int neighbor : adjacencyList.get(vertex)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    parent[neighbor] = vertex;
                    queue.enqueue(neighbor);
                    
                    if (neighbor == end) {
                        return reconstructPath(parent, start, end);
                    }
                }
            }
        }
        
        return Collections.emptyList(); // No path found
    }
    
    private List<Integer> reconstructPath(int[] parent, int start, int end) {
        List<Integer> path = new ArrayList<>();
        int current = end;
        while (current != -1) {
            path.add(current);
            current = parent[current];
        }
        Collections.reverse(path);
        return path;
    }
    
    /**
     * Returns the number of vertices.
     * 
     * @return number of vertices
     */
    public int getVertices() {
        return vertices;
    }
}

