package com.mricode.leetcode.dsa.recursion;

public class ProdofDigit {
    public static void main(String[] args) {
        System.out.println(prod(1342));
    }

    static int prod (int n) {
        if (n%10==n) {
            return n;
        }

        return (n%10) * prod(n/10);
    }
}
