package com.mricode.leetcode.dsa.stacks;

import java.util.*;

public class InBuiltExample {

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        stack.push(11);
        stack.push(21);
        stack.push(31);
        stack.push(15);
        stack.push(9);
        stack.push(29);

        /*System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());*/


        Queue<Integer> queue = new LinkedList<>();
        queue.add(3);
        queue.add(6);
        queue.add(5);
        queue.add(9);
        queue.add(15);
        queue.add(1);

        System.out.println(queue.remove());
        System.out.println(queue.remove());

        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(4);
        deque.addLast(67);

        deque.remove();

    }
}
