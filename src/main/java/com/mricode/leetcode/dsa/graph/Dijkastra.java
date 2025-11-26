package com.mricode.leetcode.dsa.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Dijkastra {

    //https://www.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1
    public int[] dijkstra(int V, int[][] edges, int src) {
        // code here

        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();

        for (int i=0; i<V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge: edges) {
            int from = edge[0];
            int to = edge[1];
            int wight = edge[2];

            adj.get(from).add(new int[]{to, wight});  //as directed only u-->v
            adj.get(to).add(new int[]{from, wight});  //as directed only u-->v
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] p1, int[] p2) {
                return p1[1] - p2[1];
            }
        });

        int dist[] = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        pq.offer(new int[]{src, 0});

        while (!pq.isEmpty()) {
            int pair[] = pq.poll();
            int u = pair[0];
            int d = pair[1];
            if (d > dist[u]) {
                continue;
            }

            for (int[] neighbour : adj.get(u)) {
                 int v = neighbour[0];
                 int w = neighbour[1];

                 if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    pq.offer(new int[]{v, dist[v]});
                 }
            }

        }

        return dist;
    }
}
