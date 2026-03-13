package com.mricode.leetcode.dsa.dp;

public class KnapSack01 {

    public int knapsack(int W, int val[], int wt[]) {
        // code here
        int n = val.length;
        int dp[][] = new int[n][W+1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < W+1; j++) {
                dp[i][j] = -1;
            }
        }
        return knapsackRecur(W, val, wt, n-1, dp);

    }

    public int knapsackRecur(int capacity, int val[], int wt[], int index, int dp[][]) {
        //base case
        if (capacity == 0) {
            dp[index][capacity] = 0;
            return 0;
        }
        if (index == 0) {
            if (wt[index] <= capacity) {
                dp[index][capacity] = val[index];
                return val[index];
            }
            else {
                dp[index][capacity] = 0;
                return 0;
            }
        }

        if (dp[index][capacity] != -1) {
            return dp[index][capacity];

        }

        int pick = 0;
        if (wt[index] <= capacity) {
            pick = knapsackRecur(capacity-wt[index], val, wt, index-1, dp) + val[index];
        }

        int noPick = knapsackRecur(capacity, val, wt, index-1, dp) + 0;
        dp[index][capacity] = Math.max(pick, noPick);

        return dp[index][capacity];

    }


    public int knapsackBottomUp(int W, int val[], int wt[]) {
        // code here
        int n = val.length;
        int dp[][] = new int[n][W+1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = 0;
        }

        for (int c = 0; c < W+1; c++) {
            if (wt[0] <= c) {
                dp[0][c] = val[0];
            }
            else {
                dp[0][c] = 0;
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < W+1; j++) {
                int pick = 0;
                if (wt[i] <= j) {
                    pick = val[i] + dp[i-1][j-wt[i]]; //knapsackRecur(j-wt[i], val, wt, i-1, dp) + val[i];
                }

                int noPick = 0 + dp[i-1][j]; //knapsackRecur(j, val, wt, i-1, dp) + 0;
                dp[i][j] = Math.max(pick, noPick);

            }
        }
        return  dp[n-1][W]; //knapsackRecur(W, val, wt, n-1, dp);

    }

    public int knapsackBottomUpSpaceOptimized(int W, int val[], int wt[]) {
        // code here
        int n = val.length;
        int prev[] = new int[W+1];


        for (int c = 0; c < W+1; c++) {
            if (wt[0] <= c) {
                prev[c] = val[0];
            }
            else {
                prev[c] = 0;
            }
        }

        for (int i = 1; i < n; i++) {
            int cur[] = new int[W+1];
            cur[0] = 0;

            for (int j = 1; j < W+1; j++) {
                int pick = 0;
                if (wt[i] <= j) {
                    pick = val[i] + prev[j-wt[i]]; //knapsackRecur(j-wt[i], val, wt, i-1, dp) + val[i];
                }

                int noPick = 0 + prev[j]; //knapsackRecur(j, val, wt, i-1, dp) + 0;
                cur[j] = Math.max(pick, noPick);

            }

            prev = cur;
        }
        return  prev[W]; //knapsackRecur(W, val, wt, n-1, dp);

    }
}
