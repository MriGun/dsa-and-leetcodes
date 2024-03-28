package com.mricode.leetcode.dsa.pattern;

public class Pattern {
    public static void main(String[] args) {
        pattern31(5);
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

    static void pattern5(int n) {
        int index= 1;
        for (int row=1; row<2*n; row++) {

            if (row > n) {
                //System.out.println("index = " + index);
                for (int col=1; col<=row-(2*index); col++) {
                    System.out.print("* ");

                }
                index = index+1;
            }
            else {
                for (int col=1; col<=row; col++) {
                    System.out.print("* ");
                }
            }

            //when one row is printed, we need a new line
            System.out.println();
        }
    }

    static void pattern17(int n) {
        for (int row = 1; row <= 2* n; row++) {

            int totalColsInRow = row > n ? 2*n -row : row;
            for (int space = 0; space < n-totalColsInRow ; space++) {
                System.out.print(" ");
            }

            for (int col = totalColsInRow; col >= 1; col--) {
                System.out.print(col);
            }

            for (int col = 2; col <= totalColsInRow; col++) {
                System.out.print(col);
            }
            System.out.println();
        }
    }

    static void pattern28(int n) {
        for (int row=0; row<2*n; row++) {
            int totalColsInRow = row > n ? 2*n -row : row;
            int spaces = n-totalColsInRow;
            for (int s=0; s<spaces; s++) {
                System.out.print(" ");
            }
            for (int col=0; col<totalColsInRow; col++) {
                System.out.print("* ");
            }
            //when one row is printed , we need a new line
            System.out.println();
        }
    }

    static void pattern30(int n) {
        for (int row = 0; row < n; row++) {

            for (int space = 0; space < n-row ; space++) {
                System.out.print(" ");
            }

            for (int col = row; col >= 1; col--) {
                System.out.print(col);
            }

            for (int col = 2; col <= row; col++) {
                System.out.print(col);
            }
            System.out.println();
        }
    }
    
    static void pattern31(int n) {
        int originalN = n;
        n = 2 * n;
        for (int row = 0; row <= n; row++) {
            for (int col = 0; col <= n; col++) {

                //int atEveryIndex = Math.min(Math.min(row, col), Math.min(n-row, n-col));
                int atEveryIndex = originalN - Math.min(Math.min(row, col), Math.min(n-row, n-col));
                System.out.print(atEveryIndex + " ");
            }
            System.out.println();
        }
    }
}
