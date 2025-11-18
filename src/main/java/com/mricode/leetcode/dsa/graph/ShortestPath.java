package com.mricode.leetcode.dsa.graph;

import java.util.*;

public class ShortestPath {

    //https://www.geeksforgeeks.org/problems/shortest-path-in-undirected-graph-having-unit-distance/1
    public int[] shortestPath(int V, int[][] edges, int src) {
        // code here
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int edge[]: edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        //apply bfs
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(src);
        int dist[] = new int[V];
        Arrays.fill(dist, -1);

        dist[src] = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbour : adj.get(node)) {
                if (dist[neighbour] == -1) {
                    dist[neighbour] = dist[node] + 1;
                    queue.offer(neighbour);
                }
            }
        }
        return dist;
    }

}
