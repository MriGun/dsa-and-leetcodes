package com.mricode.leetcode.dsa.stacks;

public class CustomStack {

    protected int[] data;

    private static final int DEFAULT_SIZE = 10;

    int ptr = -1;

    public CustomStack() {
        this(DEFAULT_SIZE);
    }

    public CustomStack(int size) {
        this.data = new int[size];
    }

    public boolean push(int item) {

        if (isFull()) {
            System.out.println("Stack is full!");
            return false;
        }

        ptr++;
        data[ptr] = item;
        return true;
    }

    public int pop() {

        if (isEmpty()) {
            throw new RuntimeException("Cant pop from empty stack!");
        }

        /*int removed = data[ptr];
        ptr--;
        return removed;*/

        return data[ptr--];
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Cant peek from empty stack!");
        }
        return data[ptr];
    }

    private boolean isFull() {
        return ptr == data.length - 1; //ptr at last index
    }

    private boolean isEmpty() {
        return ptr == - 1;
    }
}
