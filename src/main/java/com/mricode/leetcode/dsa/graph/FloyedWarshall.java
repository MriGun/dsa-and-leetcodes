package com.mricode.leetcode.dsa.graph;

import java.util.Arrays;

public class FloyedWarshall {

    public void floydWarshall(int[][] dist) {
        // Code here
        //matrix[i][j] = -1
        int size = dist.length;
        for (int i=0; i<size; i++) {
            for (int j = 0; j < size; j++) {
                if (dist[i][j] == -1) {
                    dist[i][j] = 1001; //check the constraints and assign accordingly
                }
            }
        }

        //apply floyed warshall
        for (int k=0; k < size; k++) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        for (int i=0; i<size; i++) {
            for (int j = 0; j < size; j++) {
                if (dist[i][j] == 1001) {
                    dist[i][j] = -1; //check the constraints and assign accordingly
                }
            }
        }

    }

    //https://leetcode.com/problems/minimum-cost-to-convert-string-i/
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {

        int[][] distance = new int[26][26];
        for (int i = 0; i < 26; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);
            distance[i][i]=0;
        }

        for (int i = 0; i < cost.length; i++) {
            //converting to index
            int start = original[i] - 'a';
            int end = changed[i] - 'a';
            distance[start][end] = Math.min(distance[start][end], cost[i]);
        }

        for (int k=0; k<26; k++) {
            for (int i = 0; i < 26; i++) {
                if (distance[i][k] < Integer.MAX_VALUE) {
                    for (int j = 0; j < 26; j++) {
                        if (distance[k][j] < Integer.MAX_VALUE) {
                            distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
                        }
                    }
                }

            }
        }

        long ans = 0L;
        for (int i = 0; i < source.length(); i++) {
            int c1 = source.charAt(i) - 'a';
            int c2 = target.charAt(i) - 'a';
            if (distance[c1][c2] == Integer.MAX_VALUE) {
                return -1L;
            }
            else {
                ans = ans + distance[c1][c2];
            }
        }

        return ans;

    }

}
