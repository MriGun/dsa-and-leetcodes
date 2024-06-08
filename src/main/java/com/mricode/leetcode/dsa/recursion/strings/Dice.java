package com.mricode.leetcode.dsa.recursion.strings;

import java.util.ArrayList;
import java.util.List;

public class Dice {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        getDiceCombination("", 4);
        System.out.println(getDiceCombinationRet("", 4));

    }

    static void getDiceCombination(String processed, int target) {
        if (target == 0) {
            System.out.println(processed);
            return;
        }

        for (int i = 1; i <= 6 && i <= target; i++) {
            getDiceCombination(processed +i, target-i);
        }

    }

    static void getDiceCombinationFace(String processed, int target, int face) {
        if (target == 0) {
            System.out.println(processed);
            return;
        }

        for (int i = 1; i <= face && i <= target; i++) {
            getDiceCombinationFace(processed +i, target-i, face);
        }

    }



    static List<String> getDiceCombinationRet(String processed, int target) {
        if (target == 0) {
            List<String> list = new ArrayList<>();
            list.add(processed);
            return list;
        }

        List<String> list = new ArrayList<>();

        for (int i = 1; i <= 6 && i <= target; i++) {
            list.addAll(getDiceCombinationRet(processed +i, target-i));
        }

        return list;
    }

    static List<String> getDiceCombinationRetFace(String processed, int target, int face) {
        if (target == 0) {
            List<String> list = new ArrayList<>();
            list.add(processed);
            return list;
        }

        List<String> list = new ArrayList<>();

        for (int i = 1; i <= 6 && i <= target; i++) {
            list.addAll(getDiceCombinationRetFace(processed +i, target-i, face));
        }

        return list;
    }
}
