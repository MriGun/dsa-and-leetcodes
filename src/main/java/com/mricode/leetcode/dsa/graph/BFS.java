package com.mricode.leetcode.dsa.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    //https://www.geeksforgeeks.org/problems/bfs-traversal-of-graph/1
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        boolean visited[] = new boolean[adj.size()];
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();

        visited[0] = true;
        queue.offer(0);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            result.add(node);
            ArrayList<Integer> neighbours = adj.get(node);
            for (Integer neighbour : neighbours) {
                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    queue.offer(neighbour);
                }
            }
        }
        return result;

    }

    public ArrayList<Integer> bfsTraversalWithComponent(ArrayList<ArrayList<Integer>> adj) {
        // code here
        boolean visited[] = new boolean[adj.size()];
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                result = bfsTraversalWithComponentHelper(i, visited, queue, result, adj);
            }
        }


        return result;

    }

    private ArrayList<Integer> bfsTraversalWithComponentHelper(int sourceN0de, boolean visited[], Queue<Integer> queue, ArrayList<Integer> result, ArrayList<ArrayList<Integer>> adj) {
        visited[sourceN0de] = true;
        queue.offer(sourceN0de);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            result.add(node);
            ArrayList<Integer> neighbours = adj.get(node);
            for (Integer neighbour : neighbours) {
                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    queue.offer(neighbour);
                }
            }
        }
        return result;
    }


    //https://www.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1
    //cycle detection in undirected graph
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
         boolean visited[] = new boolean[V];
         for (int i=0; i<V; i++) {
             if (!visited[i] && bfsForCycle(i, adj, visited)) {
                 return true;
             }
         }
         return false;
    }

    public boolean bfsForCycle(int src, ArrayList<ArrayList<Integer>> adj, boolean visited[]) {
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{src, -1});
            visited[src] = true;

            while (!queue.isEmpty()) {
                int pair[] = queue.poll();
                int node = pair[0];
                int parent = pair[1];

                for (int neighbour : adj.get(node)) {
                    if (neighbour == parent) {
                        continue;
                    }
                    if (visited[neighbour]) {
                        return true;
                    }
                    else {
                        queue.offer(new int[]{neighbour, node});
                        visited[neighbour] = true;
                    }
                }

            }

            return false;

    }


    //cycle detection in undirected graph using dfs
    public boolean isCycleUsingDfs(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean visited[] = new boolean[V];
        for (int i=0; i<V; i++) {
            if (!visited[i] && dfsForCycle(i, -1, adj, visited)) {
                return true;
            }
        }
        return false;
    }

    public boolean isCycleUsingDfs(int V, int[][] edges) {
        // Code here
        boolean visited[] = new boolean[V];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i=0; i<V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[0][i];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        for (int i=0; i<V; i++) {

            if (!visited[i] && dfsForCycle(i, -1, adj, visited)) {
                return true;
            }
        }
        return false;
    }
    public boolean dfsForCycle(int src, int parent, ArrayList<ArrayList<Integer>> adj, boolean visited[]) {

        visited[src] = true;
        for (int neighbour : adj.get(src)) {
            if (neighbour == parent) {
                continue;
            }
            if (visited[neighbour]) {
                return true;
            }
            else {
                if (dfsForCycle(neighbour, src, adj, visited)) {
                    return true;
                }
            }

        }

        return false;

    }

    public boolean dfsForCycle(int src, int parent, int[][] edges, boolean visited[]) {

        visited[src] = true;
        for (int neighbour : edges[src]) {
            if (neighbour == parent) {
                continue;
            }
            if (visited[neighbour]) {
                return true;
            }
            else {
                if (dfsForCycle(neighbour, src, edges, visited)) {
                    return true;
                }
            }

        }

        return false;

    }


}
