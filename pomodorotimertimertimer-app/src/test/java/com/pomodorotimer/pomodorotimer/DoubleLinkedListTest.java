package com.pomodorotimer.pomodorotimer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Unit tests for DoubleLinkedList implementation.
 * Tests insertion, deletion, traversal, and edge cases.
 */
@DisplayName("DoubleLinkedList Tests")
class DoubleLinkedListTest {
    
    private DoubleLinkedList<String> list;
    
    @BeforeEach
    void setUp() {
        list = new DoubleLinkedList<>();
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
    @DisplayName("Test addFirst and getFirst")
    void testAddFirst() {
        list.addFirst("Page1");
        assertEquals(1, list.size());
        assertEquals("Page1", list.getFirst());
        list.addFirst("Page2");
        assertEquals("Page2", list.getFirst());
        assertEquals("Page1", list.getLast());
    }
    
    @Test
    @DisplayName("Test addLast and getLast")
    void testAddLast() {
        list.addLast("Page1");
        assertEquals("Page1", list.getFirst());
        list.addLast("Page2");
        assertEquals("Page1", list.getFirst());
        assertEquals("Page2", list.getLast());
    }
    
    @Test
    @DisplayName("Test removeFirst")
    void testRemoveFirst() {
        list.addLast("Page1");
        list.addLast("Page2");
        list.addLast("Page3");
        assertEquals("Page1", list.removeFirst());
        assertEquals("Page2", list.getFirst());
        assertEquals("Page2", list.removeFirst());
        assertEquals("Page3", list.removeFirst());
        assertTrue(list.isEmpty());
        assertThrows(NoSuchElementException.class, () -> list.removeFirst());
    }
    
    @Test
    @DisplayName("Test removeLast")
    void testRemoveLast() {
        list.addLast("Page1");
        list.addLast("Page2");
        list.addLast("Page3");
        assertEquals("Page3", list.removeLast());
        assertEquals("Page2", list.removeLast());
        assertEquals("Page1", list.removeLast());
        assertTrue(list.isEmpty());
        assertThrows(NoSuchElementException.class, () -> list.removeLast());
    }
    
    @Test
    @DisplayName("Test forward traversal")
    void testForwardTraversal() {
        list.addLast("Page1");
        list.addLast("Page2");
        list.addLast("Page3");
        Iterator<String> it = list.iterator();
        assertEquals("Page1", it.next());
        assertEquals("Page2", it.next());
        assertEquals("Page3", it.next());
        assertFalse(it.hasNext());
    }
    
    @Test
    @DisplayName("Test backward traversal")
    void testBackwardTraversal() {
        list.addLast("Page1");
        list.addLast("Page2");
        list.addLast("Page3");
        Iterator<String> it = list.backwardIterator();
        assertEquals("Page3", it.next());
        assertEquals("Page2", it.next());
        assertEquals("Page1", it.next());
        assertFalse(it.hasNext());
    }
    
    @Test
    @DisplayName("Test single element and clear")
    void testSingleElementAndClear() {
        list.addFirst("Single");
        assertEquals("Single", list.getFirst());
        assertEquals("Single", list.removeFirst());
        assertTrue(list.isEmpty());
        
        list.addLast("Page1");
        list.addLast("Page2");
        list.clear();
        assertTrue(list.isEmpty());
        assertThrows(NoSuchElementException.class, () -> list.getFirst());
    }
    
    @Test
    @DisplayName("Test browser history use-case")
    void testBrowserHistoryUseCase() {
        list.addLast("google.com");
        list.addLast("github.com");
        list.addLast("stackoverflow.com");
        Iterator<String> forward = list.iterator();
        assertEquals("google.com", forward.next());
        assertEquals("github.com", forward.next());
        assertEquals("stackoverflow.com", forward.next());
    }
}

