package com.mricode.leetcode.dsa.recursion;

public class Recursion {
    public static void main(String[] args) {
         //fun(5);
        //revFun(5);
        //funBoth(5);
        //System.out.println(factorial(5));
        System.out.println(factorialSum(5));
    }

    static void fun(int n) {
        if (n==0) {
            return;
        }

        System.out.println(n);
        fun(n-1);
    }

    static void revFun(int n) {
        if (n==0) {
            return;
        }

        revFun(n-1);
        System.out.println(n);
    }

    static void funBoth(int n) {
        if (n==0) {
            return;
        }

        System.out.println(n);
        funBoth(n-1);
        System.out.println(n);
    }

    static int factorial(int n) {
        if (n<=1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    static int factorialSum(int n) {
        if (n<=1) {
            return 1;
        }
        return n + factorialSum(n - 1);
    }
}
