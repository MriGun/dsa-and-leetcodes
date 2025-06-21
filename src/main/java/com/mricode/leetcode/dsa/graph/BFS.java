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

}
