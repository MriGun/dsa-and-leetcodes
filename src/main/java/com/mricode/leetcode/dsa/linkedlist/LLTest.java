package com.mricode.leetcode.dsa.linkedlist;

public class LLTest {

    public static void main(String[] args) {
        SingleLinkedList ll = new SingleLinkedList();

        ll.insertFirst(3);
        ll.insertFirst(7);
        ll.insertFirst(5);
        ll.insertFirst(9);
        ll.insertFirst(3);
        ll.insertLast(17);
        ll.insertAtParticularIndex(100, 3);
        ll.display();
        System.out.println();
        System.out.println(ll.deleteFirst());
        System.out.println();
        ll.display();
        System.out.println();
        System.out.println(ll.deleteLast());
        System.out.println();
        ll.display();
    }
}
