package com.mricode.leetcode.dsa.recursion;


//https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/
public class StepsToReduce {
    public static void main(String[] args) {
       int steps = numberOfSteps(8);
        System.out.println(steps);
    }
    static int numberOfSteps(int num) {

       return helper(num, 0);
    }

    static int helper(int num, int steps) {
        if (num == 0) {
            return steps;
        }
        if (num%2==0) {
           return helper(num/2, ++steps);
        }
        return helper(num-1, ++steps);
    }
}
