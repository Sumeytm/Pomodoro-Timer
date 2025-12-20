package com.pomodorotimer.pomodorotimer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

/**
 * Unit tests for StronglyConnectedComponents implementation.
 * Tests component identification in directed graphs.
 */
@DisplayName("StronglyConnectedComponents Tests")
class StronglyConnectedComponentsTest {
    
    private StronglyConnectedComponents scc;
    
    @BeforeEach
    void setUp() {
        scc = new StronglyConnectedComponents(5);
    }
    
    @Test
    @DisplayName("Test single SCC")
    void testSingleSCC() {
        // Create a cycle: 0->1->2->0
        // Note: vertices 3 and 4 are isolated, so total will be 3 components
        scc.addEdge(0, 1);
        scc.addEdge(1, 2);
        scc.addEdge(2, 0);
        
        List<List<Integer>> components = scc.findSCCs();
        // One cycle (0,1,2) + two isolated vertices (3,4) = 3 components
        assertEquals(3, components.size());
        // Find the component containing 0,1,2
        boolean foundCycle = false;
        for (List<Integer> comp : components) {
            if (comp.containsAll(Arrays.asList(0, 1, 2))) {
                foundCycle = true;
                assertEquals(3, comp.size());
                break;
            }
        }
        assertTrue(foundCycle);
    }
    
    @Test
    @DisplayName("Test multiple SCCs")
    void testMultipleSCCs() {
        // Create two separate cycles
        scc.addEdge(0, 1);
        scc.addEdge(1, 0);
        scc.addEdge(2, 3);
        scc.addEdge(3, 2);
        
        List<List<Integer>> components = scc.findSCCs();
        assertEquals(3, components.size()); // Two cycles + isolated vertex 4
    }
    
    @Test
    @DisplayName("Test isolated vertices")
    void testIsolatedVertices() {
        // No edges, all vertices are isolated
        List<List<Integer>> components = scc.findSCCs();
        assertEquals(5, components.size());
    }
    
    @Test
    @DisplayName("Test network cluster analysis use-case")
    void testNetworkClusterAnalysis() {
        // Simulate network with clusters
        scc = new StronglyConnectedComponents(6);
        // Cluster 1: 0->1->2->0
        scc.addEdge(0, 1);
        scc.addEdge(1, 2);
        scc.addEdge(2, 0);
        // Cluster 2: 3->4->3
        scc.addEdge(3, 4);
        scc.addEdge(4, 3);
        // Vertex 5 is isolated
        
        List<List<Integer>> components = scc.findSCCs();
        assertTrue(components.size() >= 2);
    }
    
    @Test
    @DisplayName("Test SCC count")
    void testSCCCount() {
        scc.addEdge(0, 1);
        scc.addEdge(1, 0);
        
        int count = scc.getSCCCount();
        assertTrue(count >= 1);
    }
}

