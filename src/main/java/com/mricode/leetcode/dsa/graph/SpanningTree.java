package com.mricode.leetcode.dsa.graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class SpanningTree {

    //https://www.geeksforgeeks.org/problems/minimum-spanning-tree/1
    public int spanningTree(int V, int[][] edges) {
        // code here
        //(parent, node, weight)
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<>() {
            @Override
            public int compare(int pair1[], int pair2[]) {
                return pair1[2] - pair2[2];
            }

        });

        List<List<int[]>> adj = new ArrayList<>();

        for(int i = 0; i<V;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0; i< edges.length;i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            adj.get(u).add(new int[]{v, wt});
            adj.get(v).add(new int[]{u, wt});
        }

        int sum=0;
        ArrayList<int[]> edgeList = new ArrayList<>();
        boolean visited[] = new boolean[V];
        priorityQueue.offer(new int[]{-1, 0, 0});

        while (!priorityQueue.isEmpty()) {
            int object[] = priorityQueue.poll();
            int parent = object[0];
            int node = object[1];
            int weight = object[2];

            if (visited[node]) {
                continue;
            }

            visited[node] = true;
            if (parent != -1) {
                edgeList.add(new int[]{parent, node});
                sum = sum + weight;
            }

            for (int neighbourObject[] : adj.get(node)) {
                int neighbourNode = neighbourObject[0];
                int neighbourWeight = neighbourObject[1];

                if (!visited[neighbourNode]) {
                    priorityQueue.offer(new int[] {node, neighbourNode, neighbourWeight});
                }
            }
        }
        return sum;
    }


    //https://www.geeksforgeeks.org/problems/minimum-spanning-tree/1
    //using kruskal algoritham
    //kruskal algorithm uses disjoint set
    public int spanningTree2(int V, int[][] edges) {

        //(u, v, weight)
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<>() {
            @Override
            public int compare(int pair1[], int pair2[]) {
                return pair1[2] - pair2[2];
            }

        });

        List<List<int[]>> adj = new ArrayList<>();

        for(int i = 0; i<V;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0; i< edges.length;i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];
            adj.get(u).add(new int[]{v, w});
            adj.get(v).add(new int[]{u, w});
        }

        for (int i = 0; i < V; i++) {
            for (int[] edge : adj.get(i)) {
               priorityQueue.offer(new int[] {edge[0], edge[1], edge[2]});
            }
        }

        DisjointSet disjointSet = new DisjointSet(V);
        int sum = 0;
        while (!priorityQueue.isEmpty()) {
            int[] object = priorityQueue.poll();
            int u = object[0];
            int v = object[1];
            int w = object[2];

            if (disjointSet.unionBySize(u, v)) {
                sum = sum + w;

            }
        }
        return sum;

    }

    public class DisjointSet {

        int parent[];
        int size[];

        DisjointSet(int nodes) {
            this.parent = new int[nodes];
            this.size = new int[nodes];

            for (int i = 0; i < nodes; i++) {
                this.parent[i] = i;
                this.size[i] = 1;
            }
        }

        public int findRootParent(int node) {
           if (node == parent[node]) {
             return node;
           }

           parent[node] = findRootParent(parent[node]);
           return parent[node];
        }

        public boolean unionBySize(int node1, int node2) {

            //1. find the root parent
            int rootParent1 = findRootParent(node1);
            int rootParent2 = findRootParent(node2);

            if (rootParent1 == rootParent2) {
                return false;
            }

            //2. union of components
            //smaller will be added to the bigger one
            if (size[rootParent1] < size[rootParent2]) {
                parent[rootParent1] = rootParent2;
                size[rootParent2]  += parent[rootParent1];
            }
            else {
                parent[rootParent2] = rootParent1;
                size[rootParent1]  += parent[rootParent2];
            }

            return true;
        }
    }

}
