package com.mricode.leetcode.dsa.linkedlist;

public class DLLTest {

    public static void main(String[] args) {

        DoublyLinkedList list = new DoublyLinkedList();
        list.insertFirst(3);
        list.insertFirst(7);
        list.insertFirst(5);
        list.insertFirst(9);
        list.insertFirst(3);
        list.insertFirst(17);

        list.display();
    }
    }


