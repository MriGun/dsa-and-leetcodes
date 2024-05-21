package com.mricode.leetcode.dsa.recursion.strings;

import java.util.ArrayList;

public class SubSeq {
    public static void main(String[] args) {
        subseq("", "abc");
        System.out.println(subseqReturn("", "abc"));
        subseqAscii("", "abc");
    }

    static void subseq(String processed, String unProcessed) {

        if (unProcessed.isEmpty()) {
            System.out.println(processed);
            return;
        }
        char ch = unProcessed.charAt(0);
        subseq( processed + ch , unProcessed.substring(1));
        subseq( processed , unProcessed.substring(1));
    }

    static ArrayList<String> subseqReturn(String processed, String unProcessed) {

        if (unProcessed.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(processed);
            return list;
        }

        char ch = unProcessed.charAt(0);
        ArrayList<String> left = subseqReturn( processed + ch , unProcessed.substring(1));
        ArrayList<String> right = subseqReturn( processed , unProcessed.substring(1));

        left.addAll(right);
        return left;
    }


    static void subseqAscii(String processed, String unProcessed) {

        if (unProcessed.isEmpty()) {
            System.out.println(processed);
            return;
        }
        char ch = unProcessed.charAt(0);
        subseqAscii( processed + ch , unProcessed.substring(1));
        subseqAscii( processed , unProcessed.substring(1));
        subseqAscii( processed + (ch + 0), unProcessed.substring(1));
    }
}
