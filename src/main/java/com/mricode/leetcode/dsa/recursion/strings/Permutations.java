package com.mricode.leetcode.dsa.recursion.strings;

import java.util.ArrayList;

public class Permutations {

    public static void main(String[] args) {
        permutatations("", "abc");
        ArrayList<String> list = permutatationList("", "abc");
        System.out.println(list);
        System.out.println(permutatationsCount("", "abc"));
    }

    static void permutatations(String processed, String unprocessed) {

        if (unprocessed.isEmpty()) {
            System.out.println(processed);
            return;
        }

        char ch = unprocessed.charAt(0);

        for (int i = 0; i <= processed.length(); i++) {

                String f = processed.substring(0, i);
                String s = processed.substring(i, processed.length());
                permutatations(f + ch+ s, unprocessed.substring(1));
        }


    }

    static ArrayList<String> permutatationList(String processed, String unprocessed) {

        if (unprocessed.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(processed);
            return list;
        }

        char ch = unprocessed.charAt(0);

        //local to this call
        ArrayList<String> ans = new ArrayList<>();

        for (int i = 0; i <= processed.length(); i++) {

            String f = processed.substring(0, i);
            String s = processed.substring(i, processed.length());
            ans.addAll(permutatationList(f + ch+ s, unprocessed.substring(1)));
        }

       return ans;
    }

    static int permutatationsCount(String processed, String unprocessed) {

        if (unprocessed.isEmpty()) {
            return 1;
        }

        int count = 0;
        char ch = unprocessed.charAt(0);

        for (int i = 0; i <= processed.length(); i++) {

            String f = processed.substring(0, i);
            String s = processed.substring(i, processed.length());
            count = count + permutatationsCount(f + ch+ s, unprocessed.substring(1));
        }

         return count;
    }
}
