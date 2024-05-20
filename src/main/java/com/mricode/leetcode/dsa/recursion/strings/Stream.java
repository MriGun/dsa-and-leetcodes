package com.mricode.leetcode.dsa.recursion.strings;

public class Stream {
    public static void main(String[] args) {
        //skip("", "baccadh");
        System.out.println(skip("baccadh"));
        System.out.println(skipApple("baccappleyg"));
        System.out.println(skipAppNotApple("baccappeyg"));
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

    static String skipApple(String up) {

        if (up.isEmpty()) {
            return "";
        }

        char ch = up.charAt(0);

        if (up.startsWith("apple")) {
            return skipApple(up.substring(5));
        }
        else {
            return  ch + skipApple(up.substring(1));
        }

    }

    static String skipAppNotApple(String up) {

        if (up.isEmpty()) {
            return "";
        }

        char ch = up.charAt(0);

        if (up.startsWith("app") && !up.startsWith("apple")) {
            return skipAppNotApple(up.substring(3));
        }
        else {
            return  ch + skipAppNotApple(up.substring(1));
        }

    }
}
