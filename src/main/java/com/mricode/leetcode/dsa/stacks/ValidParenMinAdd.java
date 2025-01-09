package com.mricode.leetcode.dsa.stacks;

import java.util.Stack;

public class ValidParenMinAdd {
    public int minAddToMakeValid(String s) {

        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                     stack.pop();
                }
                else {
                    stack.push(ch);
                }
            }
            else {
                stack.push(ch);
            }
        }
        return stack.size();
    }

    public int minInsertions(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {

        }
        return stack.size();
    }
}
