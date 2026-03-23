package com.mricode.leetcode.dsa.dp;

import java.util.Arrays;

public class LongestCommonSubsequence {

    //https://leetcode.com/problems/longest-common-subsequence/description/
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        return longestCommonSubsequenceRecur(n-1, m-1, text1, text2);
    }

    public int longestCommonSubsequenceRecur(int i, int j, String text1, String text2) {

        //base case
        if (i < 0 || j < 0) {
            return 0;
        }

        if (text1.charAt(i) == text2.charAt(j)) {
            return 1 + longestCommonSubsequenceRecur(i-1, j-1, text1, text2);
        }
        else {
            int case1 = longestCommonSubsequenceRecur(i-1, j, text1, text2);
            int case2 = longestCommonSubsequenceRecur(i, j-1, text1, text2);
            return Math.max(case1, case2);
        }
    }

    public int longestCommonSubsequenceTopDown(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n+1][m+1];
        for (int i = 0; i < n+1; i++) {
            Arrays.fill(dp[i], -1);
        }
        return longestCommonSubsequenceRecurTopDown(n, m, text1, text2, dp);
    }

    public int longestCommonSubsequenceRecurTopDown(int i, int j, String text1, String text2, int[][] dp) {

        //base case
        if (i < 0 || j < 0) {
            dp[i][j] = 0;
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (text1.charAt(i-1) == text2.charAt(j-1)) {
            dp[i][j] = 1 + longestCommonSubsequenceRecurTopDown(i-1, j-1, text1, text2, dp);
            return dp[i][j];
            //return 1 + longestCommonSubsequenceRecurTopDown(i-1, j-1, text1, text2, dp);
        }
        else {
            int case1 = longestCommonSubsequenceRecurTopDown(i-1, j, text1, text2, dp);
            int case2 = longestCommonSubsequenceRecurTopDown(i, j-1, text1, text2, dp);
            dp[i][j] = Math.max(case1, case2);
            return dp[i][j];
        }
    }

    public int longestCommonSubsequenceBottomUp (String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n+1][m+1];
        dp[0][0] = 0;
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1]; //longestCommonSubsequenceRecurTopDown(i-1, j-1, text1, text2, dp);
                }
                else {
                    int case1 = dp[i-1][j]; //longestCommonSubsequenceRecurTopDown(i-1, j, text1, text2, dp);
                    int case2 = dp[i][j-1]; //longestCommonSubsequenceRecurTopDown(i, j-1, text1, text2, dp);
                    dp[i][j] = Math.max(case1, case2);
                }
            }
        }
        return dp[n][m];
    }

    public int longestCommonSubsequenceBottomUpSpaceOptimized(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[] prev = new int[m+1];
        prev[0] = 0;
        for (int i = 1; i < n+1; i++) {
            int[] cur = new int[m+1];
            cur[0] = 0;
            for (int j = 1; j < m+1; j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    cur[j] = 1 + prev[j-1]; //longestCommonSubsequenceRecurTopDown(i-1, j-1, text1, text2, dp);
                }
                else {
                    int case1 = prev[j]; //longestCommonSubsequenceRecurTopDown(i-1, j, text1, text2, dp);
                    int case2 = cur[j-1]; //longestCommonSubsequenceRecurTopDown(i, j-1, text1, text2, dp);
                    cur[j] = Math.max(case1, case2);
                }
            }
            prev = cur;
        }
        return prev[m];
    }

    //https://leetcode.com/problems/longest-palindromic-subsequence/description/
    public int longestPalindromeSubseq(String s) {
        StringBuilder str = new StringBuilder(s);
        return longestCommonSubsequenceBottomUpSpaceOptimized(s, str.reverse().toString());
    }

    //https://leetcode.com/problems/shortest-common-supersequence/description/
    public String shortestCommonSupersequence(String str1, String str2) {
        int dp[][] = longestCommonSubsequenceBottomUpForshortestCommonSupersequence(str1, str2);
        int n = dp.length;
        int m = dp[0].length;
        int i=n-1;
        int j=m-1;
        StringBuilder sb = new StringBuilder();
        while (i>0 && j>0) {
            if(str1.charAt(i-1) == str2.charAt(j-1)){ //lcs
                sb.append(str1.charAt(i-1));
                i--;
                j--;
            }else if(dp[i-1][j]>dp[i][j-1]){
                sb.append(str1.charAt(i-1));
                i--;
            }else {
                sb.append(str2.charAt(j-1));
                j--;
            }
        }
        while(i>0) {
            sb.append(str1.charAt(i-1));
            i--;
        }
        while(j>0) {
            sb.append(str2.charAt(j-1));
            j--;
        }
        return sb.reverse().toString();
    }

    public int[][] longestCommonSubsequenceBottomUpForshortestCommonSupersequence (String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n+1][m+1];
        dp[0][0] = 0;
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1]; //longestCommonSubsequenceRecurTopDown(i-1, j-1, text1, text2, dp);
                }
                else {
                    int case1 = dp[i-1][j]; //longestCommonSubsequenceRecurTopDown(i-1, j, text1, text2, dp);
                    int case2 = dp[i][j-1]; //longestCommonSubsequenceRecurTopDown(i, j-1, text1, text2, dp);
                    dp[i][j] = Math.max(case1, case2);
                }
            }
        }
        return dp;
    }

}
