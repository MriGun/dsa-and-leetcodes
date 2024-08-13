package com.mricode.leetcode.dsa.linkedlist;

public class LLTest {

    public static void main(String[] args) {
        SingleLinkedList ll = new SingleLinkedList();

        ll.insertFirst(3);
        ll.insertFirst(7);
        ll.insertFirst(5);
        ll.insertFirst(9);
        ll.insertFirst(3);
        ll.insertlast(17);

        ll.display();
    }
}
