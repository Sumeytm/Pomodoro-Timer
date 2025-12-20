package com.pomodorotimer.pomodorotimer;

import java.util.HashMap;
import java.util.Map;

/**
 * Sparse Matrix implementation for map-based grid applications in games.
 * This data structure efficiently stores only non-zero elements, saving memory
 * for large matrices with many zero values.
 * 
 * <p>Use-case: Map-based grid application for games where most cells are empty (zero)
 * and only a few cells contain game objects or values.
 * 
 * <p>Time Complexity:
 * <ul>
 *   <li>Get/Set value: O(1) average case</li>
 *   <li>Memory usage: O(k) where k is number of non-zero elements</li>
 * </ul>
 * 
 * <p>Space Complexity: O(k) where k is the number of non-zero elements
 * (much better than O(rows * cols) for sparse matrices)
 * 
 * @author Data Structures Project Team
 * @version 1.0
 */
public class SparseMatrix {
    
    private final int rows;
    private final int cols;
    private final Map<String, Integer> matrix; // Key: "row,col", Value: non-zero value
    
    /**
     * Constructs a sparse matrix with specified dimensions.
     * 
     * @param rows number of rows
     * @param cols number of columns
     * @throws IllegalArgumentException if rows or cols are negative
     */
    public SparseMatrix(int rows, int cols) {
        if (rows < 0 || cols < 0) {
            throw new IllegalArgumentException("Dimensions must be non-negative");
        }
        this.rows = rows;
        this.cols = cols;
        this.matrix = new HashMap<>();
    }
    
    /**
     * Sets the value at the specified position.
     * 
     * @param row row index (0-based)
     * @param col column index (0-based)
     * @param value value to set
     * @throws IndexOutOfBoundsException if indices are out of bounds
     */
    public void set(int row, int col, int value) {
        validateIndices(row, col);
        String key = getKey(row, col);
        if (value == 0) {
            matrix.remove(key); // Remove zero values to maintain sparsity
        } else {
            matrix.put(key, value);
        }
    }
    
    /**
     * Gets the value at the specified position.
     * 
     * @param row row index (0-based)
     * @param col column index (0-based)
     * @return the value at the position (0 if not set)
     * @throws IndexOutOfBoundsException if indices are out of bounds
     */
    public int get(int row, int col) {
        validateIndices(row, col);
        String key = getKey(row, col);
        return matrix.getOrDefault(key, 0);
    }
    
    /**
     * Returns the number of non-zero elements.
     * 
     * @return count of non-zero elements
     */
    public int getNonZeroCount() {
        return matrix.size();
    }
    
    /**
     * Returns the number of rows.
     * 
     * @return number of rows
     */
    public int getRows() {
        return rows;
    }
    
    /**
     * Returns the number of columns.
     * 
     * @return number of columns
     */
    public int getCols() {
        return cols;
    }
    
    /**
     * Calculates memory usage in terms of stored elements.
     * 
     * @return number of stored non-zero elements
     */
    public int getMemoryUsage() {
        return getNonZeroCount();
    }
    
    /**
     * Clears all values from the matrix.
     */
    public void clear() {
        matrix.clear();
    }
    
    private void validateIndices(int row, int col) {
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            throw new IndexOutOfBoundsException(
                String.format("Index out of bounds: [%d, %d] for matrix [%d, %d]", 
                    row, col, rows, cols));
        }
    }
    
    private String getKey(int row, int col) {
        return row + "," + col;
    }
}

