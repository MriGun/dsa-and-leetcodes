package com.mricode.leetcode.dsa.greedy;

import java.util.Arrays;

public class GreedyApproach {

    //https://www.geeksforgeeks.org/problems/activity-selection-1587115620/1
    public int activitySelection(int[] start, int[] finish) {
        // code here

        int n = start.length;
        int[][] interval = new int[n][2];

        for (int i = 0; i < n; i++) {
            interval[i][0] = start[i];
            interval[i][1] = finish[i];
        }

        Arrays.sort(interval, (a,b) -> a[1] - b[1]);

        int activityCount = 1;
        int lastfinish=interval[0][1];
        for (int i = 0; i < interval.length; i++) {
            if (interval[i][0] > lastfinish) {
                activityCount++;
                lastfinish = interval[i][1];
            }
        }

        return activityCount;

    }

    //https://leetcode.com/problems/non-overlapping-intervals/description/
    public int eraseOverlapIntervals(int[][] intervals) {
        //[[s,e], [s,e]]
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int removed = 0;
        int lastEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < lastEnd) {
                //overlap
                removed++;
            }
            else {
                lastEnd = intervals[i][1];
            }
        }

        return removed;
    }
}
