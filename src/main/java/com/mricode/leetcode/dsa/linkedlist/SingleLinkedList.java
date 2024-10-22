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

    //https://leetcode.com/problems/merge-two-sorted-lists/
    public static SingleLinkedList merge(SingleLinkedList first, SingleLinkedList second) {
         Node f = first.head;
         Node s = second.head;

         SingleLinkedList ans = new SingleLinkedList();

         while (f !=null && s != null) {
             if (f.value < s.value) {
                 ans.insertLast(f.value);
                 f = f.next;
             }
             else {
                 ans.insertLast(s.value);
                 s = s.next;
             }
         }

         while (f != null) {
             ans.insertLast(f.value);
             f = f.next;
         }

        while (s != null) {
            ans.insertLast(s.value);
            s = s.next;
        }

        return ans;
    }

    public void bubbleSort() {
        bubbleSort(size-1, 0);
    }

    private void bubbleSort(int row, int col) {

        if (row < 0) {
            return;
        }

        if (col < row) {
            Node first = getIndexValue(col);
            Node second = getIndexValue(col + 1);

            if (first.value > second.value) {
                //swap
                if (first == head) {
                    head = second;
                    first.next = second.next;
                    second.next = first;
                }
                else if (second == tail) {
                    Node prev = getIndexValue(col -1);
                    prev.next = second;
                    tail = first;
                    first.next = null;
                    second.next = tail;
                }
                else {
                    Node prev = getIndexValue(col -1);
                    prev.next = second;
                    first.next = second.next;
                    second.next = first;
                }

            }
            bubbleSort(row, col +1);
        }
        else {
            bubbleSort(row-1, 0);
        }
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

        System.out.println();
        System.out.println();

        SingleLinkedList s1 = new SingleLinkedList();
        s1.insertLast(1);
        s1.insertLast(2);
        s1.insertLast(4);

        SingleLinkedList s2 = new SingleLinkedList();
        s2.insertLast(1);
        s2.insertLast(3);
        s2.insertLast(4);

        SingleLinkedList ans = merge(s1, s2);
        ans.display();

        ans.bubbleSort();
        System.out.println("Bubble sort");
        ans.display();

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
