package com.mricode.leetcode.dsa.graph;

import java.util.ArrayList;
import java.util.Stack;

public class StronglyConnectedComponent {

    // Function to find number of strongly connected components in the graph.
    public int kosaraju(ArrayList<ArrayList<Integer>> adj) {
        // code here

        boolean[] visited = new boolean[adj.size()];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < adj.size(); i++) {
            if (!visited[i]) {
               dfs(i, visited, st, adj);
            }
        }


        //transpose
        ArrayList<ArrayList<Integer>> tranPoseAdjList = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < adj.size(); i++) {
            tranPoseAdjList.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < adj.size(); i++) {
            visited[i] = false;
            for (Integer it : adj.get(i)) {
                tranPoseAdjList.get(it).add(i);
            }
        }

        int count = 0;
        while (!st.isEmpty()) {
            int node = st.peek();
            st.pop();
            if (!visited[node]) {
                count++;
                dfsCount(node, visited, tranPoseAdjList);
            }
        }

        return count;


    }

    private void dfsCount(int node, boolean[] visited, ArrayList<ArrayList<Integer>> tranPoseAdjList) {
        visited[node] = true;
        for (Integer it : tranPoseAdjList.get(node)) {
            if (!visited[it]) {
                dfsCount(it, visited, tranPoseAdjList);
            }
        }
    }

    private void dfs(int node, boolean[] visited, Stack<Integer> st, ArrayList<ArrayList<Integer>> adj) {
        visited[node] = true;
        ArrayList<Integer> integers = adj.get(node);

        for (Integer neighbour : integers) {
            if (!visited[neighbour]) {
                dfs(neighbour, visited, st, adj);
            }
        }

        st.push(node);

    }
}
