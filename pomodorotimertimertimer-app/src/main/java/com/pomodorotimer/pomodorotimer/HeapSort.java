package com.pomodorotimer.pomodorotimer;

/**
 * Heap Sort algorithm implementation.
 * Sorts an array using the heap data structure with O(n log n) time complexity.
 * 
 * <p>Use-case: Priority task manager where tasks need to be sorted by priority.</p>
 * 
 * <p>Time Complexity: O(n log n) in all cases</p>
 * <p>Space Complexity: O(1) for in-place sorting</p>
 * 
 * @author Data Structures Project Team
 * @version 1.0
 */
public class HeapSort {
    
    /**
     * Private constructor to prevent instantiation.
     */
    private HeapSort() {
        // Utility class - no instantiation
    }
    
    /**
     * Sorts an array using heap sort algorithm.
     * 
     * @param array the array to sort
     */
    public static void sort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        
        int n = array.length;
        
        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }
        
        // Extract elements from heap one by one
        for (int i = n - 1; i > 0; i--) {
            // Move root to end
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            
            // Call heapify on reduced heap
            heapify(array, i, 0);
        }
    }
    
    /**
     * Heapifies a subtree rooted at index i.
     * 
     * @param array the array
     * @param n size of heap
     * @param i root index
     */
    private static void heapify(int[] array, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        
        if (left < n && array[left] > array[largest]) {
            largest = left;
        }
        
        if (right < n && array[right] > array[largest]) {
            largest = right;
        }
        
        if (largest != i) {
            int swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;
            
            heapify(array, n, largest);
        }
    }
}

