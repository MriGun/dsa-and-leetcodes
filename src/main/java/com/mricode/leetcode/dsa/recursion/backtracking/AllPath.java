package com.mricode.leetcode.dsa.recursion.backtracking;

import java.util.Arrays;

public class AllPath {

    public static void main(String[] args) {

        boolean[][] board = {
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };
        //allPath("",0, 0, board);

        int[][] path = new int[board.length][board[0].length];
        allPathPrint("",0, 0, board, path, 1);
    }
    static void allPath(String processed, int r, int c, boolean[][] maze) {

        if (r== maze.length -1 && c==maze[0].length -1) {
            System.out.println(processed);
            return;
        }

        if (!maze[r][c]) {
            return;
        }

        //I am considering this path in my block
        maze[r][c] = false;

        if (r < maze.length -1) {
            allPath(processed + 'D', r+1, c, maze);
        }

        if (c < maze[0].length -1) {
            allPath(processed + 'R', r, c+1, maze);
        }

        if (r > 0) {
            allPath(processed + 'U', r-1, c, maze);
        }

        if (c > 0) {
            allPath(processed + 'L', r, c-1, maze);
        }

        //In this line function will be over
        //so before the function gets removed, also remove the changes that were made by that function
        maze[r][c] = true;
    }

    static void allPathPrint(String processed, int r, int c, boolean[][] maze, int[][] path, int step) {

        if (r== maze.length -1 && c==maze[0].length -1) {
            path[r][c] = step;
            for (int[] arr : path) {
                System.out.println(Arrays.toString(arr));
            }

            System.out.println(processed);
            System.out.println();
            return;
        }

        if (!maze[r][c]) {
            return;
        }

        //I am considering this path in my block
        maze[r][c] = false;
        path[r][c] = step;

        if (r < maze.length -1) {
            allPathPrint(processed + 'D', r+1, c, maze, path, step+1);
        }

        if (c < maze[0].length -1) {
            allPathPrint(processed + 'R', r, c+1, maze, path, step+1);
        }

        if (r > 0) {
            allPathPrint(processed + 'U', r-1, c, maze, path, step+1);
        }

        if (c > 0) {
            allPathPrint(processed + 'L', r, c-1, maze, path, step+1);
        }

        //In this line function will be over
        //so before the function gets removed, also remove the changes that were made by that function
        maze[r][c] = true;
        path[r][c] = 0;
    }
}
