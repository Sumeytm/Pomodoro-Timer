package com.pomodorotimer.pomodorotimer;

import java.util.NoSuchElementException;

/**
 * Queue implementation using FIFO (First In First Out) principle.
 * Used for task queue management.
 * 
 * <p>Use-case: Task queue where tasks are processed in the order they were added (FIFO).
 * 
 * <p>Time Complexity:
 * <ul>
 *   <li>Enqueue: O(1)</li>
 *   <li>Dequeue: O(1)</li>
 *   <li>Peek: O(1)</li>
 * </ul>
 * 
 * <p>Space Complexity: O(n) where n is the number of elements
 * 
 * @param <T> the type of elements in this queue
 * @author Data Structures Project Team
 * @version 1.0
 */
public class Queue<T> {
    
    private static class Node<T> {
        T data;
        Node<T> next;
        
        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }
    
    private Node<T> front;
    private Node<T> rear;
    private int size;
    
    /**
     * Constructs an empty queue.
     */
    public Queue() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }
    
    /**
     * Adds an element to the rear of the queue.
     * 
     * @param item the element to add
     */
    public void enqueue(T item) {
        Node<T> newNode = new Node<>(item);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }
    
    /**
     * Removes and returns the front element.
     * 
     * @return the front element
     * @throws NoSuchElementException if the queue is empty
     */
    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        T data = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        size--;
        return data;
    }
    
    /**
     * Returns the front element without removing it.
     * 
     * @return the front element
     * @throws NoSuchElementException if the queue is empty
     */
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return front.data;
    }
    
    /**
     * Checks if the queue is empty.
     * 
     * @return true if the queue is empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /**
     * Returns the number of elements in the queue.
     * 
     * @return the size of the queue
     */
    public int size() {
        return size;
    }
    
    /**
     * Removes all elements from the queue.
     */
    public void clear() {
        front = rear = null;
        size = 0;
    }
}

