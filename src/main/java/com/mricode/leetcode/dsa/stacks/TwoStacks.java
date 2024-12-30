package com.mricode.leetcode.dsa.stacks;

import java.util.Arrays;
import java.util.List;

public class TwoStacks {

    static int twoStacks(int x, int[] a, int[] b) {
        return twoStacks(x, a, b, 0, 0) -1;
    }

    private static int twoStacks(int x, int[] a, int[] b, int sum, int count) {

        if (sum > x) {
            return count;
        }

        if (a.length == 0 || b.length ==0) {
            return count;
        }

        int ans1 = twoStacks(x, Arrays.copyOfRange(a,1, a.length), b, sum + a[0], count+1);
        int ans2 = twoStacks(x, a, Arrays.copyOfRange(b,1, b.length), sum + b[0], count+1);

        return Math.max(ans1, ans2);
    };

    private static int twoStacks(int x, List<Integer> a, List<Integer> b, int sum, int count) {

        if (sum > x) {
            return count;
        }

        if (a.size() == 0 || b.size() ==0) {
            return count;
        }

        int ans1 = twoStacks(x, a.subList(1, a.size()), b, sum + a.get(0), count+1);
        int ans2 = twoStacks(x, a, b.subList(1, b.size()), sum + b.get(0), count+1);

        return Math.max(ans1, ans2);
    };
}
