package com.mricode.leetcode.dsa.heap;

import java.util.ArrayList;

public class Heap<T extends Comparable> {

    private ArrayList<T> list;

    public Heap() {
        list = new ArrayList<>();
    }

    public int size(){
        return list.size();
    }

    private void swap(int first, int second) {
        T temp = list.get(first);
        list.set(first, list.get(second));
        list.set(second, temp);
    }

    private int parent(int index) {
        return (index -1) / 2;
    }

    private int left(int index) {
        return (index * 2) + 1;
    }

    private int right(int index) {
        return (index * 2) + 2;
    }

    public void insert(T value) {
        list.add(value);
        upheap(list.size() -1);
    }

    private void upheap(int index) {
        if (index == 0) {
            return;
        }

        int parent = parent(index);

        if (list.get(index).compareTo(list.get(parent)) < 0) {
            swap(index, parent);
            upheap(parent);
        }
    }

    public T remove() throws Exception {
        if (list.isEmpty()) {
            throw new Exception("Removing from an empty heap!");
        }

        T temp = list.get(0);

        T last = list.remove(list.size() -1);

        if (!list.isEmpty()) {
            list.set(0, last);
            downheap(0);
        }

        return temp;
    }

    private void downheap(int index) {
        int min = index;
        int left = left(index);
        int right = right(index);

        if (left < list.size() && list.get(min).compareTo(list.get(left)) > 0) {
            min = left;
        }

        if (right < list.size() && list.get(min).compareTo(list.get(right)) > 0) {
            min = right;
        }

        if (min != index) {
            swap(min, index);
            downheap(min);
        }
    }


    //heap sort?
    public ArrayList<T> heapSort() throws Exception {
        ArrayList<T> data = new ArrayList<>();

        while (!list.isEmpty()) {
            data.add(this.remove());
        }

        return data;
    }

    public static void main(String[] args) throws Exception {
        Heap<Integer> heap = new Heap<>();

        heap.insert(34);
        heap.insert(45);
        heap.insert(22);
        heap.insert(89);
        heap.insert(76);

//        System.out.println(heap.remove());

        ArrayList list1 = heap.heapSort();

        System.out.println(list1);

        String a = "Mrinmoy1";
        Integer b = 2;

        System.out.println("hashCode of a is : " + a.hashCode());
        System.out.println("hashCode of b is : " + b.hashCode());

    }


}
