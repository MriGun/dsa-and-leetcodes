package com.mricode.leetcode.dsa.dp;

import java.util.Arrays;

public class DynamicProgramming {

    //https://leetcode.com/problems/fibonacci-number/description/

    //normal recursion style
    // time complexity : 2 ^
    public int fib(int n) {

        //base case
        if (n <= 1) {
            return n;
        }
        return fib(n-1) + fib(n-2);
    }

    //dp style
    // time complexity : O(N)
    public int fib2(int n) {

        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        return fibByDp(n, dp);
    }

    //top  down approach
    public int fibByDp(int n, int[] dp) {

        //base case
        if (n <= 1) {
            dp[n] = n;
            return dp[n] ;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        dp[n] = fib(n-1) + fib(n-2);
        return dp[n];
    }


    //bottom up approach
    //also named as tabulation
    //tc : O(N)
    //sc : O(N)
    public int fib3(int n) {

        if (n <=1) {
            return n;
        }

        int dp[] = new int[n+1];

        //base ecase
        dp[0] = 0;
        dp[1] = 1;

        for (int state = 2; state <=n; state++) {
            dp[state] = dp[state-1] + dp[state-2];
        }

        return dp[n];
    }

    //space optimization
    public int fib4(int n) {

        if (n <=1) {
            return n;
        }
        //base ecase
        int prev2 = 0;
        int prev1 = 1;
        int ans = 0;

        for (int state = 2; state <=n; state++) {
            ans = prev1 + prev2;
            prev2 = prev1;
            prev1 = ans;
        }

        return ans;
    }

}
