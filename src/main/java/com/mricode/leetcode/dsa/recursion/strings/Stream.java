package com.mricode.leetcode.dsa.recursion.strings;

public class Stream {
    public static void main(String[] args) {
        //skip("", "baccadh");
        System.out.println(skip("baccadh"));
    }

    static void skip(String processed, String up) {

        if (up.isEmpty()) {
            System.out.println(processed);
            return;
        }

        char ch = up.charAt(0);

        if (ch == 'a') {
            skip(processed, up.substring(1));
        }
        else {
            skip(processed + ch, up.substring(1));
        }

    }

    static String skip(String up) {

        if (up.isEmpty()) {
            return "";
        }

        char ch = up.charAt(0);

        if (ch == 'a') {
            return "" + skip( up.substring(1));
        }
        else {
            return  ch + skip(up.substring(1));
        }

    }
}
