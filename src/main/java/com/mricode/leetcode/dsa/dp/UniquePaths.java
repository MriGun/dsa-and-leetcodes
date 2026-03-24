package com.mricode.leetcode.dsa.dp;

import java.util.Arrays;

public class UniquePaths {

    //https://leetcode.com/problems/unique-paths/description/
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m+1][n+1];
        for (int i = 0; i < m+1; i++) {
            Arrays.fill(dp[i], -1);
        }
        return uniquePathsRecur(m, n, dp);
    }

    public int uniquePathsRecur(int m, int n, int dp[][]) {

        //base case
        if (m == 1 && n == 1) {
            dp[m][n] = 1;
            return 1;
        }
        if (m == 0 || n == 0) {
            dp[m][n] = 0;
            return 0;
        }

        if (dp[m][n] != -1) {
            return dp[m][n];
        }

        int ways = uniquePathsRecur(m-1, n, dp) + uniquePathsRecur(m, n-1, dp);
        dp[m][n] = ways;
        return dp[m][n] ;
    }

    public int uniquePathsBottomUp(int m, int n) {
        int dp[][] = new int[m+1][n+1];

        for (int i = 0; i < m+1; i++) {
            for (int j = 0; j < n+1; j++) {
                if (i==0 || j==0) {
                    dp[i][j] = 0;
                }
                else if (i==1 && j==1) {
                    dp[1][1] = 1;
                }
                else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[m][n];
    }

    //https://leetcode.com/problems/unique-paths-ii/
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int dp[][] = new int[m+1][n+1];

        for (int i = 0; i < m+1; i++) {
            for (int j = 0; j < n+1; j++) {
                if (i==0 || j==0 || obstacleGrid[i-1][j-1] == 1) {
                    dp[i][j] = 0;
                }
                else if (i==1 && j==1) {
                    dp[i][j] = 1;
                }
                else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[m][n];
    }

}
