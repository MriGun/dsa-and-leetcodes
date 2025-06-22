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

    //https://leetcode.com/problems/flood-fill/
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int rows = image.length;
        int cols = image[0].length;


        //boolean visited[][] = new boolean[rows][cols]; //fasle


        floodFillDfs(image, sr, sc, color, image[sr][sc], rows, cols);

        return image;
    }

    public void floodFillDfs(int[][] image, int row, int col, int newColor, int curColor, int totalRows, int totalCols){
        if (row < 0 || row >= totalRows || col < 0 || col >= totalCols) {
            return;
        }

        if (image[row][col] != curColor) {
            return;
        }

        if (image[row][col] == newColor) {
            return;
        }

        image[row][col] = newColor;
        //visited[row][col] = true;

        //visit neighbours [up, right, down, left]
        int adjList[][] = {
                {row - 1, col},
                {row, col + 1},
                {row +1, col},
                {row, col -1}
        };

        for (int neighbour[] : adjList) {
            floodFillDfs(image, neighbour[0], neighbour[1], newColor, curColor, totalRows, totalCols);
        }

    }

}
