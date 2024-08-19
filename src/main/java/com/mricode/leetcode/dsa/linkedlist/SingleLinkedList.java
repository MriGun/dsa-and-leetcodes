package com.mricode.leetcode.dsa.linkedlist;

public class SingleLinkedList {

    private Node head;
    private Node tail;
    private int size;

    public SingleLinkedList() {
        this.size=0;
    }

    public void insertFirst(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;

        if (tail == null) {
            tail=head;
        }

        size += 1;
    }


    public void insertLast(int val) {

        if (tail == null) {
            insertFirst(val);
            return;
        }

        Node node = new Node(val);
        tail.next = node;
        tail = node;
        size += 1;
    }

    public void insertAtParticularIndex(int val, int index) {

        if (index ==0) {
            insertFirst(val);
            return;
        }

        if (index == size) {
            insertLast(val);
            return;
        }

        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;

        }

        Node node = new Node(val, temp.next);
        temp.next = node;

        size++;

    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }

        System.out.print("END");
    }

    public int deleteFirst() {
        int val = head.value;
        head = head.next;

        if (head == null) {
            tail = null;
        }

        size--;

        return val;
    }

    public int deleteLast() {

        if (size <= 1) {
            deleteFirst();
        }

        Node secondLast = getIndexValue(size -2);
        int val = tail.value;

        tail = secondLast;
        tail.next = null;

        return val;
    }

    public Node getIndexValue(int index) {
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }

        return node;
    }

    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(Node node) {
            this.next = node;
        }


        public Node(int value, Node node) {
            this.value = value;
            this.next = node;
        }
    }
}
