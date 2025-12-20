package com.pomodorotimer.pomodorotimer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for FileOperations implementation.
 * Tests search time and collision handling with linear probing.
 */
@DisplayName("File Operations Tests")
class FileOperationsTest {
    
    private FileOperations fileOps;
    
    @BeforeEach
    void setUp() {
        fileOps = new FileOperations();
    }
    
    @Test
    @DisplayName("Test empty file operations")
    void testEmptyFileOperations() {
        assertTrue(fileOps.isEmpty());
        assertEquals(0, fileOps.size());
        assertNull(fileOps.get("nonexistent"));
    }
    
    @Test
    @DisplayName("Test put and get")
    void testPutAndGet() {
        fileOps.put("file1", "path/to/file1.txt");
        fileOps.put("file2", "path/to/file2.txt");
        
        assertEquals("path/to/file1.txt", fileOps.get("file1"));
        assertEquals("path/to/file2.txt", fileOps.get("file2"));
        assertEquals(2, fileOps.size());
    }
    
    @Test
    @DisplayName("Test update existing key")
    void testUpdateExistingKey() {
        fileOps.put("file1", "path1");
        fileOps.put("file1", "path2");
        
        assertEquals("path2", fileOps.get("file1"));
        assertEquals(1, fileOps.size());
    }
    
    @Test
    @DisplayName("Test remove")
    void testRemove() {
        fileOps.put("file1", "path1");
        fileOps.put("file2", "path2");
        
        assertEquals("path1", fileOps.remove("file1"));
        assertNull(fileOps.get("file1"));
        assertEquals(1, fileOps.size());
    }
    
    @Test
    @DisplayName("Test containsKey")
    void testContainsKey() {
        fileOps.put("file1", "path1");
        
        assertTrue(fileOps.containsKey("file1"));
        assertFalse(fileOps.containsKey("nonexistent"));
    }
    
    @Test
    @DisplayName("Test collision handling with linear probing")
    void testCollisionHandling() {
        // Create small table to force collisions
        FileOperations smallTable = new FileOperations(4);
        
        smallTable.put("a", "path1");
        smallTable.put("b", "path2");
        smallTable.put("c", "path3");
        smallTable.put("d", "path4");
        
        assertEquals("path1", smallTable.get("a"));
        assertEquals("path2", smallTable.get("b"));
        assertEquals("path3", smallTable.get("c"));
        assertEquals("path4", smallTable.get("d"));
    }
    
    @Test
    @DisplayName("Test search time")
    void testSearchTime() {
        fileOps.put("file1", "path1");
        fileOps.put("file2", "path2");
        
        int time = fileOps.getSearchTime("file1");
        assertTrue(time > 0);
    }
    
    @Test
    @DisplayName("Test clear")
    void testClear() {
        fileOps.put("file1", "path1");
        fileOps.put("file2", "path2");
        
        fileOps.clear();
        assertTrue(fileOps.isEmpty());
        assertEquals(0, fileOps.size());
    }
    
    @Test
    @DisplayName("Test fast file search use-case")
    void testFastFileSearch() {
        // Simulate file search operations
        fileOps.put("document.pdf", "/documents/document.pdf");
        fileOps.put("image.jpg", "/images/image.jpg");
        fileOps.put("video.mp4", "/videos/video.mp4");
        
        assertEquals("/documents/document.pdf", fileOps.get("document.pdf"));
        assertEquals("/images/image.jpg", fileOps.get("image.jpg"));
        assertEquals("/videos/video.mp4", fileOps.get("video.mp4"));
        
        // Fast search
        assertTrue(fileOps.getSearchTime("document.pdf") <= 5);
    }
    
    @Test
    @DisplayName("Test resize functionality")
    void testResize() {
        // Add many elements to trigger resize
        for (int i = 0; i < 20; i++) {
            fileOps.put("file" + i, "path" + i);
        }
        
        assertEquals(20, fileOps.size());
        for (int i = 0; i < 20; i++) {
            assertEquals("path" + i, fileOps.get("file" + i));
        }
    }
}

