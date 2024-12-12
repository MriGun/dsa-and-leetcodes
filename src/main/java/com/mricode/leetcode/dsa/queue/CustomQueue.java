package com.mricode.leetcode.dsa.queue;

public class CustomQueue {

    private int[] data;

    private static final int DEFAULT_SIZE = 10;

    int end = 0;

    public CustomQueue() {
        this(DEFAULT_SIZE);
    }

    public CustomQueue(int size) {
        this.data = new int[size];
    }

    public boolean isFull() {
        return end == data.length; //ptr at last index
    }

    public boolean isEmpty() {
        return end == 0;
    }

    public boolean insert(int item) {

        if (isFull()) {
            System.out.println("Queue is full!");
            return false;
        }

        data[end] = item;
        end++;

        //data[end++] = item;
        return true;
    }

    public int remove() {

        if (isEmpty()) {
            throw new RuntimeException("Queue is empty!");
        }

        int removed = data[0];
         //shift the items to the left
        for (int i = 1; i < end; i++) {
             data[i-1] = data[i];
        }

        end--;

        return removed;
    }

    public int front() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty!");
        }

        return data[0];
    }

    public void display() {
        for (int i = 0; i < end; i++) {
            System.out.print(data[i] + "<-") ;
        }
        System.out.println("END!");
    }
}
