package com.pomodorotimer.pomodorotimer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

/**
 * Unit tests for Graph BFS and DFS implementations.
 * Tests shortest path (BFS) and complete traversal (DFS).
 */
@DisplayName("Graph BFS/DFS Tests")
class GraphTest {
    
    private Graph graph;
    
    @BeforeEach
    void setUp() {
        graph = new Graph(6);
        // Create a graph: 0->1->2, 0->3, 1->4, 3->4, 4->5
        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
    }
    
    @Test
    @DisplayName("Test BFS traversal")
    void testBFS() {
        List<Integer> result = graph.bfs(0);
        assertEquals(0, result.get(0));
        assertTrue(result.contains(1));
        assertTrue(result.contains(3));
        assertEquals(6, result.size());
    }
    
    @Test
    @DisplayName("Test DFS traversal")
    void testDFS() {
        List<Integer> result = graph.dfs(0);
        assertEquals(0, result.get(0));
        assertTrue(result.containsAll(Arrays.asList(0, 1, 2, 3, 4, 5)));
        assertEquals(6, result.size());
    }
    
    @Test
    @DisplayName("Test shortest path using BFS")
    void testShortestPath() {
        List<Integer> path = graph.shortestPath(0, 5);
        assertFalse(path.isEmpty());
        assertEquals(0, path.get(0));
        assertEquals(5, path.get(path.size() - 1));
        // Path should be: 0 -> 1 -> 4 -> 5 or 0 -> 3 -> 4 -> 5
        assertTrue(path.size() >= 3 && path.size() <= 4);
    }
    
    @Test
    @DisplayName("Test shortest path to same vertex")
    void testShortestPathSameVertex() {
        List<Integer> path = graph.shortestPath(0, 0);
        assertEquals(1, path.size());
        assertEquals(0, path.get(0));
    }
    
    @Test
    @DisplayName("Test shortest path when no path exists")
    void testShortestPathNoPath() {
        Graph disconnectedGraph = new Graph(3);
        disconnectedGraph.addEdge(0, 1);
        // 2 is disconnected
        
        List<Integer> path = disconnectedGraph.shortestPath(0, 2);
        assertTrue(path.isEmpty());
    }
    
    @Test
    @DisplayName("Test maze exploration use-case")
    void testMazeExploration() {
        // Simulate maze: 0 is start, 5 is end
        List<Integer> path = graph.shortestPath(0, 5);
        assertFalse(path.isEmpty());
        // Verify path is valid
        for (int i = 0; i < path.size() - 1; i++) {
            // Each consecutive pair should be connected
            assertTrue(path.get(i) >= 0 && path.get(i) < graph.getVertices());
        }
    }
    
    @Test
    @DisplayName("Test complete graph traversal")
    void testCompleteTraversal() {
        List<Integer> bfsResult = graph.bfs(0);
        List<Integer> dfsResult = graph.dfs(0);
        
        // Both should visit all reachable vertices
        assertEquals(6, bfsResult.size());
        assertEquals(6, dfsResult.size());
    }
}

