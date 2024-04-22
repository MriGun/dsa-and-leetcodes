package com.mricode.leetcode.dsa.recursion;

public class CountZeros {
    public static void main(String[] args) {
       int count = countZeros(1020400);
        System.out.println(count);
    }

    static int countZeros(int n) {
        return helper(n, 0);
    }

    private static int helper(int n, int count) {
        if (n == 0)  {
            return count;
        }
        if (n%10 == 0) {
            return helper(n/10, ++count);
        }
        return helper(n/10, count);
    }
}
