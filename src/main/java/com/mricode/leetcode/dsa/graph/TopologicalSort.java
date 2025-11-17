package com.mricode.leetcode.dsa.graph;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSort {

    //https://www.geeksforgeeks.org/problems/topological-sort/1
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i=0; i<V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge: edges) {
            int from = edge[0];
            int to = edge[1];

            adj.get(from).add(to);  //as directed only u-->v
        }


        boolean visited[] = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
               dfsTopo(i, adj, visited, stack);
            }
        }

        int res[] = new int[V];
        ArrayList<Integer> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }

        return result;

    }

    private void dfsTopo(int src, ArrayList<ArrayList<Integer>> adj, boolean[] visited, Stack<Integer> stack) {
        visited[src] = true;

        for (int neighbour : adj.get(src)) {
            if (!visited[neighbour]) {
                dfsTopo(neighbour, adj, visited, stack);
            }
        }
        stack.push(src);
    }
}
