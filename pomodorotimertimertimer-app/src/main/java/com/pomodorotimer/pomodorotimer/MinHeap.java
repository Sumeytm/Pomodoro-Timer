package com.pomodorotimer.pomodorotimer;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Min Heap implementation for priority task manager.
 * A min heap maintains the heap property where parent nodes are always
 * smaller than or equal to their children.
 * 
 * <p>Use-case: Priority task manager where tasks with higher priority
 * (lower values) are processed first.
 * 
 * <p>Time Complexity:
 * <ul>
 *   <li>Insert: O(log n)</li>
 *   <li>Extract Min: O(log n)</li>
 *   <li>Peek: O(1)</li>
 * </ul>
 * 
 * <p>Space Complexity: O(n) where n is the number of elements
 * 
 * @author Data Structures Project Team
 * @version 1.0
 */
public class MinHeap {
    
    private final List<Integer> heap;
    
    /**
     * Constructs an empty min heap.
     */
    public MinHeap() {
        this.heap = new ArrayList<>();
    }
    
    /**
     * Constructs a min heap from an array of integers.
     * 
     * @param array the array to build heap from
     */
    public MinHeap(int[] array) {
        this.heap = new ArrayList<>();
        for (int value : array) {
            heap.add(value);
        }
        buildHeap();
    }
    
    /**
     * Inserts a value into the heap.
     * 
     * @param value the value to insert
     */
    public void insert(int value) {
        heap.add(value);
        heapifyUp(heap.size() - 1);
    }
    
    /**
     * Removes and returns the minimum value.
     * 
     * @return the minimum value
     * @throws NoSuchElementException if the heap is empty
     */
    public int extractMin() {
        if (heap.isEmpty()) {
            throw new NoSuchElementException("Heap is empty");
        }
        int min = heap.get(0);
        int last = heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) {
            heap.set(0, last);
            heapifyDown(0);
        }
        return min;
    }
    
    /**
     * Returns the minimum value without removing it.
     * 
     * @return the minimum value
     * @throws NoSuchElementException if the heap is empty
     */
    public int peek() {
        if (heap.isEmpty()) {
            throw new NoSuchElementException("Heap is empty");
        }
        return heap.get(0);
    }
    
    /**
     * Checks if the heap is empty.
     * 
     * @return true if the heap is empty, false otherwise
     */
    public boolean isEmpty() {
        return heap.isEmpty();
    }
    
    /**
     * Returns the number of elements in the heap.
     * 
     * @return the size of the heap
     */
    public int size() {
        return heap.size();
    }
    
    private void heapifyUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (heap.get(index) >= heap.get(parentIndex)) break;
            swap(index, parentIndex);
            index = parentIndex;
        }
    }
    
    private void heapifyDown(int index) {
        while (true) {
            int leftChild = 2 * index + 1;
            int rightChild = 2 * index + 2;
            int smallest = index;
            
            if (leftChild < heap.size() && heap.get(leftChild) < heap.get(smallest)) {
                smallest = leftChild;
            }
            if (rightChild < heap.size() && heap.get(rightChild) < heap.get(smallest)) {
                smallest = rightChild;
            }
            
            if (smallest == index) break;
            swap(index, smallest);
            index = smallest;
        }
    }
    
    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
    
    private void buildHeap() {
        for (int i = heap.size() / 2 - 1; i >= 0; i--) {
            heapifyDown(i);
        }
    }
    
    /**
     * Checks if the heap property is maintained.
     * 
     * @return true if heap property is maintained, false otherwise
     */
    public boolean isHeapPropertyMaintained() {
        for (int i = 0; i < heap.size(); i++) {
            int leftChild = 2 * i + 1;
            int rightChild = 2 * i + 2;
            
            if (leftChild < heap.size() && heap.get(i) > heap.get(leftChild)) {
                return false;
            }
            if (rightChild < heap.size() && heap.get(i) > heap.get(rightChild)) {
                return false;
            }
        }
        return true;
    }
}
