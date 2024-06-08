package com.mricode.leetcode.dsa.recursion.strings;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
public class PhonePad {

    public static void main(String[] args) {
        //keyPad("", "12");
        //System.out.println(keyPadRet("", ""));
        System.out.println(letterCombinations( "23"));
        //System.out.println(keyPadCount("", "12"));
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

    static ArrayList<String> keyPadRet(String processed, String unprocessed) {
        if (unprocessed.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(processed);
            return list;
        }
        int digit = unprocessed.charAt(0) - '0'; // this will convert '2' into 2
        ArrayList<String> list = new ArrayList<>();

        for (int i =(digit -2)*3 ; i< (digit -1)*3; i++) {
            char ch = (char) ('a' + i);
            list.addAll(keyPadRet(processed + ch, unprocessed.substring(1)));
        }

        return list;
    }

    static int keyPadCount(String processed, String unprocessed) {
        if (unprocessed.isEmpty()) {
            System.out.println(processed);
            return 1;
        }
        int count = 0;
        int digit = unprocessed.charAt(0) - '0'; // this will convert '2' into 2

        for (int i =(digit -1)*3 ; i< digit*3; i++) {
            char ch = (char) ('a' + i);
            count = count + keyPadCount(processed + ch, unprocessed.substring(1));
        }

        return count;
    }

    public static List<String> letterCombinations(String digits) {
        return keyPadRetWithList("", digits);
    }

    static List<String> keyPadRetWithList(String processed, String unprocessed) {
        if (unprocessed.isEmpty()) {
            List<String> list = new ArrayList<>();
            if (!processed.isEmpty()) {
                list.add(processed);
            }
            return list;
        }

        String[] mapping = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        int digit = unprocessed.charAt(0) - '0'; // this will convert '2' into 2
        String equivalentString = mapping[digit];
        List<String> list = new ArrayList<>();

        for (int i = 0; i < equivalentString.length(); i++) {
            char ch = equivalentString.charAt(i);
            list.addAll(keyPadRetWithList(processed + ch, unprocessed.substring(1)));
        }

        return list;
    }

}
