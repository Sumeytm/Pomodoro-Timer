package com.pomodorotimer.pomodorotimer;

import java.util.NoSuchElementException;

/**
 * Stack implementation using LIFO (Last In First Out) principle.
 * Used for task scheduler with undo operations.
 * 
 * <p>Use-case: Task scheduler with undo operations where the most recent
 * task can be undone first (LIFO behavior).
 * 
 * <p>Time Complexity:
 * <ul>
 *   <li>Push: O(1)</li>
 *   <li>Pop: O(1)</li>
 *   <li>Peek: O(1)</li>
 * </ul>
 * 
 * <p>Space Complexity: O(n) where n is the number of elements
 * 
 * @param <T> the type of elements in this stack
 * @author Data Structures Project Team
 * @version 1.0
 */
public class Stack<T> {
    
    private static class Node<T> {
        T data;
        Node<T> next;
        
        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }
    
    private Node<T> top;
    private int size;
    
    /**
     * Constructs an empty stack.
     */
    public Stack() {
        this.top = null;
        this.size = 0;
    }
    
    /**
     * Pushes an element onto the top of the stack.
     * 
     * @param item the element to push
     */
    public void push(T item) {
        Node<T> newNode = new Node<>(item);
        newNode.next = top;
        top = newNode;
        size++;
    }
    
    /**
     * Removes and returns the top element.
     * 
     * @return the top element
     * @throws NoSuchElementException if the stack is empty
     */
    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        T data = top.data;
        top = top.next;
        size--;
        return data;
    }
    
    /**
     * Returns the top element without removing it.
     * 
     * @return the top element
     * @throws NoSuchElementException if the stack is empty
     */
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        return top.data;
    }
    
    /**
     * Checks if the stack is empty.
     * 
     * @return true if the stack is empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /**
     * Returns the number of elements in the stack.
     * 
     * @return the size of the stack
     */
    public int size() {
        return size;
    }
    
    /**
     * Removes all elements from the stack.
     */
    public void clear() {
        top = null;
        size = 0;
    }
}

