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



    //https://leetcode.com/problems/minimum-insertions-to-balance-a-parentheses-string/description/
    public int minInsertions(String s) {
        Stack<Character> stack = new Stack<>();
        boolean popCounter = false;
        boolean closingCondintion = false;
        int requires = 0;

        for (int i = 0; i<s.length(); i++) {

            if (s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            }
            else {
                if (i+1 < s.length() && s.charAt(i+1) == ')') {
                    i++; // skip the char
                }
                else {
                    requires++;
                }
                if (!stack.isEmpty()) {
                    stack.pop();
                }
                else {
                    requires++;
                }
            }
        }

        return requires + 2 * stack.size();
    }

    static public int minInsertions2(String s) {

        Stack<Character> stack = new Stack<>();
        boolean popCounter = false;
        boolean closingCondintion = false;
        int requires = 0;

        for (int i = 0; i<s.length(); i++) {
            if (popCounter) {
                popCounter = false;
                continue;
            }
            if (s.charAt(i) == ')') {
                if (closingCondintion) {
                    closingCondintion = false;
                    continue;
                }
                if (i <s.length() -1 && s.charAt(i+1) == ')') {
                    if (!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                        popCounter = true;
                        requires = requires - 2;
                    }
                    else {
                        stack.push(s.charAt(i));
                        popCounter = false;
                        requires = requires + 1;
                        closingCondintion = true;

                    }
                }
                else {
                    //if (i != s.length() -1) {

                    popCounter = false;
                    if (!stack.isEmpty() && stack.peek() == '(') {
                        requires = requires - 1;
                    }
                    else {
                        requires = requires + 2;
                        if (i == s.length() -1) {

                        }
                    }

                    stack.push(s.charAt(i));
                    //}
                }
            }
            else {
                stack.push(s.charAt(i));
                popCounter = false;
                requires = requires + 2;
            }
        }

        return requires;
    }
}
