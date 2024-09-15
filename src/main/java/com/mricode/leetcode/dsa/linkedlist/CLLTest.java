package com.mricode.leetcode.dsa.linkedlist;

public class CLLTest {

    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();
        list.insert(3);
        list.insert(7);
        list.insert(5);
        list.insert(9);
        list.insert(3);
        list.insert(17);

        list.display();

        list.delete(17);
        list.display();

    }
}
