package com.mricode.leetcode.dsa.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HuffmanCoder {

    HashMap<Character, String> encoder;
    HashMap<String, Character> decoder;

    private class Node implements Comparable<Node> {

        Character data;
        int cost; //frequency
        Node left;
        Node right;

        public Node(Character data, int cost) {
            this.data = data;
            this.cost = cost;
            this.left = null;
            this.right = null;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    public HuffmanCoder(String feeder) throws Exception {

        HashMap<Character, Integer> frequencyMap = new HashMap<>();
        for (int i = 0; i < feeder.length(); i++) {
            char ch = feeder.charAt(i);
            if (frequencyMap.containsKey(ch)) {
                int originalValue = frequencyMap.get(ch);
                originalValue +=1;
                frequencyMap.put(ch, originalValue);
            }
            else {
                frequencyMap.put(ch, 1);
            }
        }

        Heap<Node> minHeap = new Heap<>();
        Set<Map.Entry<Character, Integer>> entrySet = frequencyMap.entrySet();

        for (Map.Entry<Character, Integer> entry : entrySet) {
            Node node = new Node(entry.getKey(), entry.getValue());
            minHeap.insert(node);
        }

        while (minHeap.size() != 1) {
            Node first = minHeap.remove();
            Node second = minHeap.remove();

            Node newNode = new Node('\0', first.cost + second.cost);
            newNode.left = first;
            newNode.right = second;

            minHeap.insert(newNode);
        }

        Node fullTree = minHeap.remove();

        this.encoder = new HashMap<>();
        this.decoder = new HashMap<>();

        this.initEncoderDecoder(fullTree, "");
    }

    private void initEncoderDecoder(Node node, String outputSoFar) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            this.encoder.put(node.data, outputSoFar);
            this.decoder.put(outputSoFar, node.data);
        }

        this.initEncoderDecoder(node.left, outputSoFar + "0");
        this.initEncoderDecoder(node.right, outputSoFar + "1");
    }

    public String encode(String source) {
        String ans = "";

        for (int i = 0; i < source.length(); i++) {
            ans = ans + encoder.get(source.charAt(i));
        }
        
        return ans;
    }

    public String decode(String encodedSource) {
        String key = "";
        String ans = "";
        for (int i = 0; i < encodedSource.length(); i++) {
            key = key + encodedSource.charAt(i);

            if (decoder.containsKey(key)) {
                ans = ans + decoder.get(key);
                key = "";
            }
        }
        return ans;
    }

    public static void main(String[] args) throws Exception {
        String str = "abbccda";
        HuffmanCoder hf = new HuffmanCoder(str);

        String codedString  = hf.encode(str);
        String deccodedString  = hf.decode(codedString);
        System.out.println("codedString : " + codedString);
        System.out.println("deccodedString : " + deccodedString);
    }

}
