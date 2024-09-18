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

    //insert using recursion
    public void insertRecursion(int val, int index) {
        head = insertRec(val, index, head);
    }

    private Node insertRec(int val, int index, Node node) {
        if (index == 0) {
            Node temp = new Node(val, node);
            size++;
            return temp;
        }

        node.next = insertRec(val, index-1, node.next);
        return node;
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

    public int deleteParticularIndex(int index) {
        if (index == 0) {
            return deleteFirst();
        }

        if (index == size-1) {
            return deleteLast();
        }

        Node prev = getIndexValue(index-1);
        int val = prev.next.value;

        prev.next = prev.next.next;

        return val;
    }

    public Node getIndexValue(int index) {
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }

        return node;
    }

    public Node findValue(int val) {
        Node node = head;
        while (node != null) {
            if (node.value == val) {
                return node;
            }

            node = node.next;
        }

        return null;
    }

    //https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/
    public void duplicates() {

        Node node = head;

        while (node.next != null) {
            if (node.next != null && node.value == node.next.value) {
                node.next = node.next.next;
                size--;
            }
            else {
                node = node.next;
            }
        }
        tail = node;
        tail.next = null;
    }

    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();
        list.insertLast(1);
        list.insertLast(1);
        list.insertLast(2);
        list.insertLast(3);
        list.insertLast(3);
        list.insertLast(3);

        list.display();
        list.duplicates();
        list.display();
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
