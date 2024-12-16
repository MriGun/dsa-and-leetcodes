package com.mricode.leetcode.dsa.stacks;

import java.util.Queue;
import java.util.Stack;

public class Problems {
    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();

        stack.push(5);

        System.out.println(stack.pop());
    }
}

//https://leetcode.com/problems/implement-queue-using-stacks/
class QueueUsingStack {
    private Stack<Integer> first;
    private Stack<Integer> second;

    public QueueUsingStack() {
        first = new Stack<>();
        second = new Stack<>();
    }

    public void insert(int item) {
        //insert efficient
        first.push(item);
    }

    public int remove() {
        while (!first.isEmpty()) {
            second.push(first.pop());
        }

        int removed = second.pop();

        while (!second.isEmpty()) {
            first.push(second.pop());
        }

        return removed;
    }

    public boolean isEmpty() {
        return first.isEmpty();
    }

    public int peek() {
        while (!first.isEmpty()) {
            second.push(first.pop());
        }

        int peeked = second.peek();

        while (!second.isEmpty()) {
            first.push(second.pop());
        }

        return peeked;
    }

}


//remove efficient
class QueueUsingStackRemoveEfficient {
    private Stack<Integer> first;
    private Stack<Integer> second;

    public QueueUsingStackRemoveEfficient() {
        first = new Stack<>();
        second = new Stack<>();
    }

    public void insert(int item) {
        //remove efficient
        while (!first.isEmpty()) {
            second.push(first.pop());
        }

        first.push(item);

        while (!second.isEmpty()) {
            first.push(second.pop());
        }
    }

    public int remove() {
        while (!first.isEmpty()) {
            second.push(first.pop());
        }

        int removed = second.pop();

        while (!second.isEmpty()) {
            first.push(second.pop());
        }

        return removed;
    }

    public boolean isEmpty() {
        return first.isEmpty();
    }

    public int peek() {
        return first.peek();
    }

}
