package com.mricode.leetcode.dsa.recursion.strings;

public class SubSeq {
    public static void main(String[] args) {
        subseq("", "abc");
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
}
