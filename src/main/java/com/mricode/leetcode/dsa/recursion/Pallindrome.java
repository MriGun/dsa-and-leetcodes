package com.mricode.leetcode.dsa.recursion;

public class Pallindrome {
    public static void main(String[] args) {
        System.out.println(pallindromeNumber(121121));
    }

    static boolean pallindromeNumber(int n) {
        if (n == rev(n)) {
            return true;
        }
        return false;
    }

    static int rev(int n) {

        //sometimes we might need aditional arguments in the function
        //then make another function
        int digits = (int)(Math.log10(n)) + 1;
        return helper(n, digits);

    }

    private static int helper(int n, int digits) {
        if (n%10 == n) {
            return n;
        }
        int rem = n % 10;
        return rem * (int)Math.pow(10, digits-1) + helper(n/10, digits-1);
    }
}
