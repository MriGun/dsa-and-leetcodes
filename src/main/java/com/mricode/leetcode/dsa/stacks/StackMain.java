package com.mricode.leetcode.dsa.stacks;

public class StackMain {
    public static void main(String[] args) {
        //CustomStack customStack = new CustomStack(5);
        DynamicStack customStack = new DynamicStack(5);

        customStack.push(19);
        customStack.push(8);
        customStack.push(90);
        customStack.push(17);
        customStack.push(11);
        customStack.push(41);

        System.out.println(customStack.pop());
        System.out.println(customStack.pop());
        System.out.println(customStack.pop());
        System.out.println(customStack.pop());
        System.out.println(customStack.pop());
        System.out.println(customStack.pop());
    }
}
