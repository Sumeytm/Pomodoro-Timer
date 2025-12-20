package com.pomodorotimer.pomodorotimer;

import java.util.*;

/**
 * Huffman Coding implementation for text compression/decompression.
 * Used for lossless text compression.
 * 
 * <p>Use-case: Text compression/decompression tool where we need to
 * reduce file size while maintaining lossless decompression.</p>
 * 
 * <p>Time Complexity: O(n log n) where n is the number of unique characters</p>
 * <p>Space Complexity: O(n)</p>
 * 
 * @author Data Structures Project Team
 * @version 1.0
 */
public class HuffmanCoding {
    
    /**
     * Inner class representing a Huffman tree node.
     */
    private static class Node implements Comparable<Node> {
        char character;
        int frequency;
        Node left;
        Node right;
        
        Node(char character, int frequency) {
            this.character = character;
            this.frequency = frequency;
            this.left = null;
            this.right = null;
        }
        
        Node(int frequency, Node left, Node right) {
            this.character = '\0';
            this.frequency = frequency;
            this.left = left;
            this.right = right;
        }
        
        boolean isLeaf() {
            return left == null && right == null;
        }
        
        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.frequency, other.frequency);
        }
    }
    
    private Node root;
    private Map<Character, String> encodingMap;
    private Map<String, Character> decodingMap;
    
    /**
     * Constructs a Huffman coding from input text.
     * 
     * @param text the text to encode
     */
    public HuffmanCoding(String text) {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("Text cannot be null or empty");
        }
        buildTree(text);
        buildEncodingMap();
    }
    
    private void buildTree(String text) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : text.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            pq.offer(new Node(entry.getKey(), entry.getValue()));
        }
        
        while (pq.size() > 1) {
            Node left = pq.poll();
            Node right = pq.poll();
            Node parent = new Node(left.frequency + right.frequency, left, right);
            pq.offer(parent);
        }
        
        root = pq.poll();
    }
    
    private void buildEncodingMap() {
        encodingMap = new HashMap<>();
        decodingMap = new HashMap<>();
        if (root != null) {
            // Special case: single character (root is leaf)
            if (root.isLeaf()) {
                encodingMap.put(root.character, "0");
                decodingMap.put("0", root.character);
            } else {
                buildEncodingMapHelper(root, "");
            }
        }
    }
    
    private void buildEncodingMapHelper(Node node, String code) {
        if (node.isLeaf()) {
            encodingMap.put(node.character, code);
            decodingMap.put(code, node.character);
        } else {
            if (node.left != null) buildEncodingMapHelper(node.left, code + "0");
            if (node.right != null) buildEncodingMapHelper(node.right, code + "1");
        }
    }
    
    /**
     * Encodes text using Huffman coding.
     * 
     * @param text the text to encode
     * @return encoded binary string
     */
    public String encode(String text) {
        StringBuilder encoded = new StringBuilder();
        for (char c : text.toCharArray()) {
            String code = encodingMap.get(c);
            if (code == null) {
                throw new IllegalArgumentException("Character not in encoding map: " + c);
            }
            encoded.append(code);
        }
        return encoded.toString();
    }
    
    /**
     * Decodes binary string using Huffman coding.
     * 
     * @param encoded the encoded binary string
     * @return decoded text
     */
    public String decode(String encoded) {
        StringBuilder decoded = new StringBuilder();
        StringBuilder currentCode = new StringBuilder();
        
        for (char bit : encoded.toCharArray()) {
            currentCode.append(bit);
            Character character = decodingMap.get(currentCode.toString());
            if (character != null) {
                decoded.append(character);
                currentCode.setLength(0);
            }
        }
        
        return decoded.toString();
    }
    
    /**
     * Gets the compression ratio.
     * 
     * @param originalText original text
     * @param encodedText encoded text
     * @return compression ratio (original size / encoded size)
     */
    public double getCompressionRatio(String originalText, String encodedText) {
        int originalBits = originalText.length() * 8; // Assuming 8 bits per character
        int encodedBits = encodedText.length();
        return (double) originalBits / encodedBits;
    }
    
    /**
     * Returns the encoding map.
     * 
     * @return encoding map
     */
    public Map<Character, String> getEncodingMap() {
        return new HashMap<>(encodingMap);
    }
}

