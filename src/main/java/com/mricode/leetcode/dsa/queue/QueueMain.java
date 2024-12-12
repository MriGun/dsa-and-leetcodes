package com.mricode.leetcode.dsa.queue;

public class QueueMain {
    public static void main(String[] args) {

        CustomQueue customQueue = new CustomQueue(5);
        customQueue.insert(3);
        customQueue.insert(16);
        customQueue.insert(7);
        customQueue.insert(21);
        customQueue.insert(4);


        customQueue.display();
        System.out.println(customQueue.remove());
        customQueue.display();


    }
}
