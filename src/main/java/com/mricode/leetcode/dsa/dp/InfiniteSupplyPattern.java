package com.mricode.leetcode.dsa.dp;

import java.util.Arrays;

public class InfiniteSupplyPattern {

    //https://leetcode.com/problems/coin-change/
    public int coinChange(int[] coins, int amount) {

        int n = coins.length;
        int result = coinChangeRecur(coins, amount, n-1);
        if (result == (int)(1e9)) {
            return -1;
        }
        return result;
    }

    public int coinChangeRecur(int[] coins, int amount, int index) {
        //base case
        if (index == 0) {
            if (amount % coins[index] == 0) {
                return amount/coins[index];
            }
            else {
                return (int)(1e9);
            }
        }

        int pick = (int)(1e9);
        if (amount >= coins[index]) {
            pick = 1 + coinChangeRecur(coins, amount-coins[index], index);
        }

        int noPick = coinChangeRecur(coins, amount, index-1);

        return Math.min(pick, noPick);

    }


    public int coinChangeTopDown(int[] coins, int amount) {

        int n = coins.length;
        int dp[][] = new int[n][amount+1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        int result = coinChangeRecurTopDown(coins, amount, n-1, dp);
        if (result == (int)(1e9)) {
            return -1;
        }
        return result;
    }

    public int coinChangeRecurTopDown(int[] coins, int amount, int index,  int dp[][] ) {
        //base case
        if (index == 0) {
            if (amount % coins[index] == 0) {
                dp[index][amount] = amount/coins[index];
                return amount/coins[index];
            }
            else {
                dp[index][amount] = (int)(1e9);
                return (int)(1e9);
            }
        }

        if (dp[index][amount] != -1) {
            return dp[index][amount];
        }

        int pick = (int)(1e9);
        if (amount >= coins[index]) {
            pick = 1 + coinChangeRecurTopDown(coins, amount-coins[index], index, dp);
        }

        int noPick = coinChangeRecurTopDown(coins, amount, index-1, dp);
        dp[index][amount] =Math.min(pick, noPick);
        return dp[index][amount];

    }


    //bottom up
    public int coinChangeBottomUp(int[] coins, int amount) {

        int n = coins.length;
        int dp[][] = new int[n][amount+1];
        for (int a = 0; a < amount +1; a++) {
            if (a % coins[0] == 0) {
                dp[0][a] = a/coins[0];
            }
            else {
                dp[0][a] = (int)(1e9);
            }
        }

        for (int i = 1; i < n; i++) {
            for (int a = 0; a < amount +1; a++) {
                int pick = (int)(1e9);
                if (a >= coins[i]) {
                    pick = 1 + dp[i][a-coins[i]];//coinChangeRecurTopDown(coins, a-coins[i], i, dp);
                }

                int noPick = dp[i-1][a]; //coinChangeRecurTopDown(coins, a, i-1, dp);
                dp[i][a] =Math.min(pick, noPick);
            }
        }

        if (dp[n-1][amount]  == (int)(1e9)) {
            return -1;
        }
        return dp[n-1][amount];
    }
}
