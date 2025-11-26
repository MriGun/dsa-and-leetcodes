package com.mricode.leetcode.dsa.graph;

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

}
