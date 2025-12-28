package com.pomodorotimer.pomodorotimer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

/**
 * Unit tests for XORLinkedList implementation.
 * Tests insertion, deletion, and bidirectional navigation.
 */
@DisplayName("XORLinkedList Tests")
class XORLinkedListTest {
    
    private XORLinkedList<String> list;
    
    @BeforeEach
    void setUp() {
        list = new XORLinkedList<>();
    }
    
    @Test
    @DisplayName("Test empty list")
    void testEmptyList() {
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
        assertThrows(NoSuchElementException.class, () -> list.getFirst());
        assertThrows(NoSuchElementException.class, () -> list.getLast());
    }
    
    @Test
    @DisplayName("Test addFirst")
    void testAddFirst() {
        list.addFirst("Song1");
        assertEquals(1, list.size());
        assertFalse(list.isEmpty());
        assertEquals("Song1", list.getFirst());
        assertEquals("Song1", list.getLast());
        
        list.addFirst("Song2");
        assertEquals(2, list.size());
        assertEquals("Song2", list.getFirst());
        assertEquals("Song1", list.getLast());
    }
    
    @Test
    @DisplayName("Test addLast")
    void testAddLast() {
        list.addLast("Song1");
        assertEquals(1, list.size());
        assertEquals("Song1", list.getFirst());
        assertEquals("Song1", list.getLast());
        
        list.addLast("Song2");
        assertEquals(2, list.size());
        assertEquals("Song1", list.getFirst());
        assertEquals("Song2", list.getLast());
    }
    
    @Test
    @DisplayName("Test removeFirst")
    void testRemoveFirst() {
        list.addLast("Song1");
        list.addLast("Song2");
        list.addLast("Song3");
        
        assertEquals("Song1", list.removeFirst());
        assertEquals(2, list.size());
        assertEquals("Song2", list.getFirst());
        
        assertEquals("Song2", list.removeFirst());
        assertEquals(1, list.size());
        assertEquals("Song3", list.getFirst());
        
        assertEquals("Song3", list.removeFirst());
        assertTrue(list.isEmpty());
        assertThrows(NoSuchElementException.class, () -> list.removeFirst());
    }
    
    @Test
    @DisplayName("Test single element")
    void testSingleElement() {
        list.addFirst("Single");
        assertEquals(1, list.size());
        assertEquals("Single", list.getFirst());
        assertEquals("Single", list.getLast());
        
        assertEquals("Single", list.removeFirst());
        assertTrue(list.isEmpty());
    }
    
    @Test
    @DisplayName("Test clear")
    void testClear() {
        list.addLast("Song1");
        list.addLast("Song2");
        list.addLast("Song3");
        
        list.clear();
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }
    
    @Test
    @DisplayName("Test playlist use-case")
    void testPlaylistUseCase() {
        // Simulate playlist operations
        list.addLast("Song1");
        list.addLast("Song2");
        list.addLast("Song3");
        
        assertEquals("Song1", list.getFirst());
        assertEquals("Song3", list.getLast());
        assertEquals(3, list.size());
    }
    
    @Test
    @DisplayName("Test insert method (alias for addLast)")
    void testInsert() {
        list.insert("Item1");
        assertEquals(1, list.size());
        assertEquals("Item1", list.getFirst());
        
        list.insert("Item2");
        assertEquals(2, list.size());
        assertEquals("Item2", list.getLast());
    }
    
    @Test
    @DisplayName("Test delete method - element exists")
    void testDeleteElementExists() {
        list.addLast("Song1");
        list.addLast("Song2");
        list.addLast("Song3");
        
        assertTrue(list.delete("Song2"));
        assertEquals(2, list.size());
        assertEquals("Song1", list.getFirst());
        assertEquals("Song3", list.getLast());
    }
    
    @Test
    @DisplayName("Test delete method - element not exists")
    void testDeleteElementNotExists() {
        list.addLast("Song1");
        list.addLast("Song2");
        
        assertFalse(list.delete("Song3"));
        assertEquals(2, list.size());
    }
    
    @Test
    @DisplayName("Test delete from empty list")
    void testDeleteFromEmptyList() {
        assertFalse(list.delete("Song1"));
        assertTrue(list.isEmpty());
    }
    
    @Test
    @DisplayName("Test delete first element")
    void testDeleteFirstElement() {
        list.addLast("Song1");
        list.addLast("Song2");
        list.addLast("Song3");
        
        assertTrue(list.delete("Song1"));
        assertEquals(2, list.size());
        assertEquals("Song2", list.getFirst());
    }
    
    @Test
    @DisplayName("Test delete last element")
    void testDeleteLastElement() {
        list.addLast("Song1");
        list.addLast("Song2");
        list.addLast("Song3");
        
        assertTrue(list.delete("Song3"));
        assertEquals(2, list.size());
        assertEquals("Song1", list.getFirst());
        assertEquals("Song2", list.getLast());
    }
    
    @Test
    @DisplayName("Test delete single element")
    void testDeleteSingleElement() {
        list.addLast("Song1");
        
        assertTrue(list.delete("Song1"));
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }
    
    @Test
    @DisplayName("Test traverseForward with elements")
    void testTraverseForward() {
        list.addLast("Song1");
        list.addLast("Song2");
        list.addLast("Song3");
        
        // Capture output
        java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(out));
        
        list.traverseForward();
        
        String output = out.toString();
        assertTrue(output.contains("Song1"));
        assertTrue(output.contains("Song2"));
        assertTrue(output.contains("Song3"));
        
        System.setOut(System.out);
    }
    
    @Test
    @DisplayName("Test traverseForward empty list")
    void testTraverseForwardEmpty() {
        java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(out));
        
        list.traverseForward();
        
        String output = out.toString();
        assertTrue(output.contains("List is empty"));
        
        System.setOut(System.out);
    }
    
    @Test
    @DisplayName("Test traverseBackward with elements")
    void testTraverseBackward() {
        list.addLast("Song1");
        list.addLast("Song2");
        list.addLast("Song3");
        
        java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(out));
        
        list.traverseBackward();
        
        String output = out.toString();
        assertTrue(output.contains("Song1"));
        assertTrue(output.contains("Song2"));
        assertTrue(output.contains("Song3"));
        
        System.setOut(System.out);
    }
    
    @Test
    @DisplayName("Test traverseBackward empty list")
    void testTraverseBackwardEmpty() {
        java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(out));
        
        list.traverseBackward();
        
        String output = out.toString();
        assertTrue(output.contains("List is empty"));
        
        System.setOut(System.out);
    }
    
    @Test
    @DisplayName("Test mixed addFirst and addLast")
    void testMixedAddFirstAndAddLast() {
        list.addFirst("First");
        list.addLast("Last");
        list.addFirst("NewFirst");
        
        assertEquals(3, list.size());
        assertEquals("NewFirst", list.getFirst());
        assertEquals("Last", list.getLast());
    }
    
    @Test
    @DisplayName("Test clear after operations")
    void testClearAfterOperations() {
        list.addLast("Song1");
        list.addLast("Song2");
        list.addLast("Song3");
        list.removeFirst();
        
        list.clear();
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
        assertThrows(NoSuchElementException.class, () -> list.getFirst());
    }
}


