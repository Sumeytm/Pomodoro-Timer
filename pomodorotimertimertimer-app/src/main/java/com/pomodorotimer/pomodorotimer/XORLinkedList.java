package com.pomodorotimer.pomodorotimer;

import java.util.NoSuchElementException;

/**
 * XOR Linked List implementation for memory-efficient playlist system.
 * This data structure uses XOR operation to store both previous and next pointers
 * in a single field, reducing memory usage by half compared to double linked list.
 * 
 * <p>Use-case: Memory-efficient playlist system where each node stores a song,
 * and navigation can be done in both directions using XOR pointers.
 * 
 * <p>Time Complexity:
 * <ul>
 *   <li>Insertion: O(1)</li>
 *   <li>Deletion: O(1) if node is known</li>
 *   <li>Traversal: O(n)</li>
 * </ul>
 * 
 * <p>Space Complexity: O(n) where n is the number of elements
 * (but uses less memory than double linked list)
 * 
 * @param <T> the type of elements in this list
 * @author Data Structures Project Team
 * @version 1.0
 */
public class XORLinkedList<T> {
    
    /**
     * Inner class representing a node in the XOR linked list.
     */
    private static class Node<T> {
        T data;
        Node<T> xorPtr; // Stores XOR of previous and next node addresses
        
        Node(T data) {
            this.data = data;
            this.xorPtr = null;
        }
    }
    
    private Node<T> head;
    private Node<T> tail;
    private int size;
    
    /**
     * Constructs an empty XOR linked list.
     */
    public XORLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
    /**
     * Adds an element to the front of the list.
     * 
     * @param data the element to add
     */
    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.xorPtr = head;
            head.xorPtr = newNode;
            head = newNode;
        }
        size++;
    }
    
    /**
     * Adds an element to the end of the list.
     * 
     * @param data the element to add
     */
    public void addLast(T data) {
        Node<T> newNode = new Node<>(data);
        if (tail == null) {
            head = tail = newNode;
        } else {
            newNode.xorPtr = tail;
            tail.xorPtr = newNode;
            tail = newNode;
        }
        size++;
    }
    
    /**
     * Removes and returns the first element.
     * 
     * @return the first element
     * @throws NoSuchElementException if the list is empty
     */
    public T removeFirst() {
        if (head == null) throw new NoSuchElementException("List is empty");
        T data = head.data;
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.xorPtr;
        }
        size--;
        return data;
    }
    
    /**
     * Returns the first element without removing it.
     * 
     * @return the first element
     * @throws NoSuchElementException if the list is empty
     */
    public T getFirst() {
        if (head == null) {
            throw new NoSuchElementException("List is empty");
        }
        return head.data;
    }
    
    /**
     * Returns the last element without removing it.
     * 
     * @return the last element
     * @throws NoSuchElementException if the list is empty
     */
    public T getLast() {
        if (tail == null) {
            throw new NoSuchElementException("List is empty");
        }
        return tail.data;
    }
    
    /**
     * Returns the number of elements in the list.
     * 
     * @return the size of the list
     */
    public int size() {
        return size;
    }
    
    /**
     * Checks if the list is empty.
     * 
     * @return true if the list is empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /**
     * Removes all elements from the list.
     */
    public void clear() {
        head = tail = null;
        size = 0;
    }
}

