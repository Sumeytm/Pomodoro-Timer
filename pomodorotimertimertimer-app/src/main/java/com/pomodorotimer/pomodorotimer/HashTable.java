package com.pomodorotimer.pomodorotimer;

import java.util.LinkedList;

/**
 * Hash Table implementation with chaining for collision handling.
 * Used for simple key-value database.
 * 
 * <p>Use-case: Simple key-value database where we need fast insertion,
 * deletion, and lookup operations.
 * 
 * <p>Time Complexity:
 * <ul>
 *   <li>Insert: O(1) average, O(n) worst case</li>
 *   <li>Search: O(1) average, O(n) worst case</li>
 *   <li>Delete: O(1) average, O(n) worst case</li>
 * </ul>
 * 
 * <p>Space Complexity: O(n) where n is the number of key-value pairs
 * 
 * @param <K> the type of keys maintained by this hash table
 * @param <V> the type of mapped values
 * @author Data Structures Project Team
 * @version 1.0
 */
public class HashTable<K, V> {
    
    /**
     * Inner class representing a key-value pair.
     */
    private static class Entry<K, V> {
        K key;
        V value;
        
        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
    
    private static final int DEFAULT_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75;
    
    private LinkedList<Entry<K, V>>[] buckets;
    private int size;
    private int capacity;
    
    /**
     * Constructs a hash table with default capacity.
     */
    @SuppressWarnings("unchecked")
    public HashTable() {
        this.capacity = DEFAULT_CAPACITY;
        this.buckets = new LinkedList[capacity];
        this.size = 0;
        for (int i = 0; i < capacity; i++) {
            buckets[i] = new LinkedList<>();
        }
    }
    
    /**
     * Constructs a hash table with specified capacity.
     * 
     * @param capacity initial capacity
     */
    @SuppressWarnings("unchecked")
    public HashTable(int capacity) {
        this.capacity = capacity;
        this.buckets = new LinkedList[capacity];
        this.size = 0;
        for (int i = 0; i < capacity; i++) {
            buckets[i] = new LinkedList<>();
        }
    }
    
    private int hash(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }
    
    /**
     * Inserts a key-value pair into the hash table.
     * 
     * @param key the key
     * @param value the value
     */
    public void put(K key, V value) {
        int index = hash(key);
        LinkedList<Entry<K, V>> bucket = buckets[index];
        
        // Check if key already exists
        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                entry.value = value; // Update existing
                return;
            }
        }
        
        // Add new entry
        bucket.add(new Entry<>(key, value));
        size++;
        
        // Resize if load factor exceeded
        if ((double) size / capacity > LOAD_FACTOR) {
            resize();
        }
    }
    
    /**
     * Retrieves the value associated with a key.
     * 
     * @param key the key
     * @return the value, or null if key not found
     */
    public V get(K key) {
        int index = hash(key);
        LinkedList<Entry<K, V>> bucket = buckets[index];
        
        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        
        return null;
    }
    
    /**
     * Removes a key-value pair from the hash table.
     * 
     * @param key the key to remove
     * @return the value that was removed, or null if key not found
     */
    public V remove(K key) {
        int index = hash(key);
        LinkedList<Entry<K, V>> bucket = buckets[index];
        
        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                bucket.remove(entry);
                size--;
                return entry.value;
            }
        }
        
        return null;
    }
    
    /**
     * Checks if the hash table contains a key.
     * 
     * @param key the key to check
     * @return true if key exists, false otherwise
     */
    public boolean containsKey(K key) {
        return get(key) != null;
    }
    
    /**
     * Returns the number of key-value pairs.
     * 
     * @return the size
     */
    public int size() {
        return size;
    }
    
    /**
     * Checks if the hash table is empty.
     * 
     * @return true if empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /**
     * Removes all key-value pairs from the hash table.
     */
    public void clear() {
        for (int i = 0; i < capacity; i++) {
            buckets[i].clear();
        }
        size = 0;
    }
    
    @SuppressWarnings("unchecked")
    private void resize() {
        int oldCapacity = capacity;
        capacity *= 2;
        LinkedList<Entry<K, V>>[] oldBuckets = buckets;
        buckets = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            buckets[i] = new LinkedList<>();
        }
        size = 0;
        for (int i = 0; i < oldCapacity; i++) {
            for (Entry<K, V> entry : oldBuckets[i]) {
                put(entry.key, entry.value);
            }
        }
    }
}

