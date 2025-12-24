# Comment Locations - Simple List

This is a simple list of which files have comments and on which lines.

---

## Inline Comments (//) Locations

### 1. HeapSort.java
- Line 21: `// Utility class - no instantiation`
- Line 36: `// Build max heap`
- Line 41: `// Extract elements from heap one by one`
- Line 43: `// Move root to end`
- Line 48: `// Call heapify on reduced heap`

### 2. KMPAlgorithm.java
- Line 25: `// Default constructor`
- Line 42: `int i = 0; // index for text`
- Line 43: `int j = 0; // index for pattern`

### 3. HuffmanCoding.java
- Line 95: `// Special case: single character (root is leaf)`
- Line 163: `int originalBits = originalText.length() * 8; // Assuming 8 bits per character`

### 4. FileOperations.java
- Line 84: `// Linear probing`
- Line 87: `// Update existing`
- Line 93: `// Table is full`

### 5. BPlusTree.java
- Line 124: `// Key already exists, update value`
- Line 127: `// Insert new key-value pair`
- Line 200: `// Simplified check - in real implementation, verify all paths have same height`

### 6. SparseMatrix.java
- Line 30: `private final Map<String, Integer> matrix; // Key: "row,col", Value: non-zero value`
- Line 60: `matrix.remove(key); // Remove zero values to maintain sparsity`

### 7. XORLinkedList.java
- Line 34: `Node<T> xorPtr; // Stores XOR of previous and next node addresses`

### 8. StronglyConnectedComponents.java
- Line 63: `// Step 1: Fill stack with vertices in order of finishing times (DFS)`
- Line 70: `// Step 2: Reverse the graph (already done in constructor)`
- Line 71: `// Step 3: Process vertices in reverse order of finishing times`

### 9. HashTable.java
- Line 90: `// Check if key already exists`
- Line 98: `// Add new entry`
- Line 102: `// Resize if load factor exceeded`

---

## Javadoc Comments (/** ... */) Locations

All classes have Javadoc comments at the top (class documentation) and before each public method.

### Files with Javadoc:
- DoubleLinkedList.java - Class doc + all method docs
- XORLinkedList.java - Class doc + all method docs
- SparseMatrix.java - Class doc + all method docs
- Stack.java - Class doc + all method docs
- Queue.java - Class doc + all method docs
- MinHeap.java - Class doc + all method docs
- HeapSort.java - Class doc + all method docs
- Graph.java - Class doc + all method docs
- HashTable.java - Class doc + all method docs
- StronglyConnectedComponents.java - Class doc + all method docs
- KMPAlgorithm.java - Class doc + all method docs
- HuffmanCoding.java - Class doc + all method docs
- BPlusTree.java - Class doc + all method docs
- FileOperations.java - Class doc + all method docs

---

## Summary

**Total Inline Comments**: 19 comments in 9 files
**Total Javadoc Comments**: All 14 classes have Javadoc

**Files with Inline Comments**:
1. HeapSort.java (5 comments)
2. FileOperations.java (3 comments)
3. HashTable.java (3 comments)
4. BPlusTree.java (3 comments)
5. StronglyConnectedComponents.java (3 comments)
6. KMPAlgorithm.java (3 comments)
7. HuffmanCoding.java (2 comments)
8. SparseMatrix.java (2 comments)
9. XORLinkedList.java (1 comment)

**Files with Only Javadoc** (no inline comments):
- DoubleLinkedList.java
- Stack.java
- Queue.java
- MinHeap.java
- Graph.java

