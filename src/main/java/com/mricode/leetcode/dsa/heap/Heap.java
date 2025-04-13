package com.mricode.leetcode.dsa.heap;

import java.util.ArrayList;

public class Heap<T extends Comparable> {

    private ArrayList<T> list;

    public Heap() {
        list = new ArrayList<>();
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


}
