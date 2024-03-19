package com.mricode.leetcode.dsa.pattern;

public class Pattern {
    public static void main(String[] args) {
        pattern4(5);
    }

    static void pattern1(int n) {
        for (int row=0; row<n; row++) {
            for (int col=0; col<n; col++) {
                System.out.print("*");
            }
            //when one row is printed , we need a new line
            System.out.println();
        }
    }

    static void pattern2(int n) {
        for (int row=0; row<n; row++) {
            for (int col=0; col<=row; col++) {
                System.out.print("*");
            }
            //when one row is printed , we need a new line
            System.out.println();
        }
    }

    static void pattern3(int n) {
        for (int row=0; row<n; row++) {
            //for (int col=n; col>row; col--) {
            for (int col=0; col<n-row; col++) {
                System.out.print("*");
            }
            //when one row is printed , we need a new line
            System.out.println();
        }
    }

    static void pattern4(int n) {
        for (int row=0; row<n; row++) {
            for (int col=0; col<=row; col++) {
                System.out.print(col+1+ " ");
            }
            //when one row is printed , we need a new line
            System.out.println();
        }
    }
}
