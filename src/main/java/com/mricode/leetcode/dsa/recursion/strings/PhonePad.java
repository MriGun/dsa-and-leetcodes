package com.mricode.leetcode.dsa.recursion.strings;

//https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
public class PhonePad {

    public static void main(String[] args) {
        keyPad("", "12");
    }

    static void keyPad(String processed, String unprocessed) {
        if (unprocessed.isEmpty()) {
            System.out.println(processed);
            return;
        }
        int digit = unprocessed.charAt(0) - '0'; // this will convert '2' into 2

        for (int i =(digit -1)*3 ; i< digit*3; i++) {
            char ch = (char) ('a' + i);
            keyPad(processed + ch, unprocessed.substring(1));
        }
    }

}
