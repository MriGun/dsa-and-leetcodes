package com.mricode.leetcode.dsa.tree.advancequestions;

import com.mricode.leetcode.dsa.tree.structure.TreeNode;

import java.util.*;

public class VerticalTraversal {

    //https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/

    class Tuple{
        TreeNode node;
        Integer col;
        Integer row;
        Tuple(TreeNode n,Integer c,Integer r){
            node = n;
            col = c;
            row = r;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<Tuple> queue = new ArrayDeque<>();
        Map<Integer, Map<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        queue.offer(new Tuple(root, 0, 0)); // will add element

        while (!queue.isEmpty()) {
            Tuple removed = queue.poll(); //will remove element
            root = removed.node;
            int col = removed.col;
            int row = removed.row;

            if (root != null) {
                if (!map.containsKey(col)) {
                    map.put(col, new TreeMap<>());
                }
                if (!map.get(col).containsKey(row)) {
                    map.get(col).put(row, new PriorityQueue<>());
                }

                map.get(col).get(row).offer(root.val);

                queue.offer(new Tuple(root.left, col-1, row+1));
                queue.offer(new Tuple(root.right, col+1, row+1));
            }
        }


        for (Map<Integer, PriorityQueue<Integer>> mv : map.values()) {

            List<Integer> list = new ArrayList<>();
            for (PriorityQueue<Integer> minHeap : mv.values()) {
                while (!minHeap.isEmpty()) {
                    list.add(minHeap.poll());
                }
            }

            result.add(list);
        }

        return result;
    }
}
