package com.mricode.leetcode.dsa.queue;

public class QueueMain {
    public static void main(String[] args) {

        CircularQueue customQueue = new CircularQueue(5);
        customQueue.insert(3);
        customQueue.insert(16);
        customQueue.insert(7);
        customQueue.insert(21);
        customQueue.insert(4);


        customQueue.display();
        System.out.println(customQueue.remove());
        customQueue.insert(45);
        System.out.println(customQueue.remove());
        customQueue.display();


    }
}
