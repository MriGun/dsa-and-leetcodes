package com.mricode.leetcode.dsa.recursion.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Maze {
    public static void main(String[] args) {
        System.out.println(count(3, 3));
        path("",3, 3);
        System.out.println(pathRet("",3, 3));
        System.out.println(pathRetDiagonal("",3, 3));
    }

    static int count(int r, int c) {

        if (r==1 || c==1) {
            return 1;
        }

        int left = count(r-1, c);
        int right = count(r, c-1);

        return left+right;
    }

    static void path(String processed, int r, int c) {

        if (r==1 && c==1) {
            System.out.println(processed);
            return;
        }

        if (r > 1) {
            path(processed + 'D', r-1, c);
        }

        if (c > 1) {
            path(processed + 'R', r, c-1);
        }
    }

    static List<String> pathRet(String processed, int r, int c) {

        if (r==1 && c==1) {
            //System.out.println(processed);
            List<String> list = new ArrayList<>();
            list.add(processed);
            return list;
        }

        List<String> list = new ArrayList<>();

        if (r > 1) {
            list.addAll(pathRet(processed + 'D', r-1, c));
        }

        if (c > 1) {
            list.addAll(pathRet(processed + 'R', r, c-1));
        }

        return list;
    }

    static List<String> pathRetDiagonal(String processed, int r, int c) {

        if (r==1 && c==1) {
            //System.out.println(processed);
            List<String> list = new ArrayList<>();
            list.add(processed);
            return list;
        }

        List<String> list = new ArrayList<>();

        if (r > 1) {
            list.addAll(pathRetDiagonal(processed + 'V', r-1, c));
        }

        if (c > 1) {
            list.addAll(pathRetDiagonal(processed + 'H', r, c-1));
        }

        if (r > 1 && c > 1) {
            list.addAll(pathRetDiagonal(processed + 'D', r-1, c-1));
        }

        return list;
    }
}
