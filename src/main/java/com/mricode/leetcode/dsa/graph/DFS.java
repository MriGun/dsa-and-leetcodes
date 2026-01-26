package com.mricode.leetcode.dsa.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

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



    public int[][] floodFillBfs(int[][] image, int sr, int sc, int color) {

        int rows = image.length;
        int cols = image[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {sr, sc});
        int curColour = image[sr][sc];
        image[sr][sc] = color;



        while (!queue.isEmpty()) {
            int node[] = queue.poll();
            int row = node[0];
            int col = node[1];

            int adjList[][] = {
                    {row - 1, col},
                    {row, col + 1},
                    {row +1, col},
                    {row, col -1}
            };

            for (int[] neighbour : adjList) {
                int r = neighbour[0];
                int c = neighbour[1];

                if (r < 0 || r >= rows || c < 0 || c >= cols || image[r][c] != curColour || image[r][c] == color) {
                    continue;
                }

                image[r][c] = color;
                queue.offer(new int[]{r, c});

            }
        }


        return image;
    }

    //https://leetcode.com/problems/number-of-islands/description/
    public int numIslands(char[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;
        int islands = 0;

        boolean visited[][] = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
               if (grid[i][j] == '1' && !visited[i][j]) {
                   numIslandsDfs(i, j, grid, visited, rows, cols);
                   islands++;
               }
            }
        }

        return islands;

    }

    private void numIslandsDfs(int row, int col, char[][] grid, boolean[][] visited, int rows, int cols) {

        //out of bound
        if (row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] == '0' || visited[row][col]) {
            return;
        }

        visited[row][col] = true;
        //visit neighbours [up, right, down, left]
        int adjList[][] = {
                {row - 1, col},
                {row, col + 1},
                {row +1, col},
                {row, col -1}
        };

        for (int[] neighbour : adjList) {
            numIslandsDfs(neighbour[0], neighbour[1], grid, visited, rows, cols);
        }


    }

    public int numIslands2(char[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;
        int islands = 0;

        boolean visited[][] = new boolean[rows][cols];
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    visited[i][j] = true;
                    queue.offer(new int[]{i,j});
                    numIslandsQueue(queue, grid, visited, rows, cols);
                    islands++;
                }
            }
        }

        return islands;

    }

    private void numIslandsQueue(Queue<int[]> queue, char[][] grid, boolean[][] visited, int rows, int cols) {
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int row = node[0];
            int col = node[1];

            int adjList[][] = {
                    {row - 1, col},
                    {row, col + 1},
                    {row + 1, col},
                    {row, col - 1}
            };

            for (int[] neighbour : adjList) {
                {
                    int r = neighbour[0];
                    int c = neighbour[1];

                    //out of bound
                    if (r < 0 || r >= rows || c < 0 || c >= cols || grid[r][c] == '0' || visited[r][c]) {
                        continue;
                    }
                    visited[r][c] = true;
                    queue.offer(new int[]{r, c});

                }
            }
        }
    }

    //https://leetcode.com/problems/is-graph-bipartite/description/
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int colour[] = new int[n];
        Arrays.fill(colour, -1);
        for (int i = 0; i < n; i++) {
            if (colour[i] == -1) {
                if (!colour(i, graph, colour, 0)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean colour(int src, int[][] graph, int[] colour, int c) {

        colour[src] = c;

        for (int neighbour : graph[src]) {
            if (colour[neighbour] == -1) {
                if (!colour(neighbour, graph, colour, 1-c)) {
                    return false;
                }
            }
            else if (colour[neighbour] == c) {
                return false;
            }
        }
        return true;
    }


}
