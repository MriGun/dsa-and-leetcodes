package com.mricode.leetcode.dsa.linear;

public class RichestCustomerWealth1672 {

    //https://leetcode.com/problems/richest-customer-wealth/

    public static void main(String[] args) {
        int[][] nums = {{1,2,3}, {3,2,1}};
        System.out.println(maximumWealth(nums));
    }

    public static int maximumWealth(int[][] accounts) {
        int richestMan = Integer.MIN_VALUE;

        for (int row = 0; row < accounts.length; row++) {
            int wealth = 0;
            for (int col = 0; col < accounts[row].length; col++) {
                wealth = wealth + accounts[row][col];
            }
            if (wealth > richestMan) {
                richestMan = wealth;
            }
        }
        return richestMan;
    }

}
