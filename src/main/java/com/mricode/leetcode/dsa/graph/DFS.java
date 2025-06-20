package com.mricode.leetcode.dsa.graph;

import java.util.ArrayList;

public class DFS {

    //https://www.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // Code here

        boolean[] visited = new boolean[adj.size()];
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < visited.length; i++) {

            if (!visited[i]) {
                dfsHelper(i, visited, adj, result);
            }
        }

        return result;

    }

    private void dfsHelper(int node, boolean[] visited, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> result) {

        visited[node] = true;
        result.add(node);

        ArrayList<Integer> neighbours = adj.get(node);

        for (Integer neighbour : neighbours) {
            if (!visited[neighbour]) {
                dfsHelper(neighbour, visited, adj, result);
            }
        }
    }
}
