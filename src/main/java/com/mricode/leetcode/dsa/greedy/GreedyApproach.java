package com.mricode.leetcode.dsa.greedy;

import java.util.ArrayList;
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

    //https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/description/
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> (a[1] <= b[1] ? -1 : 1));
        int arrows = 1;
        int lastEnd = points[0][1];
         for (int point[] : points) {
             //if there is no overlaping point , increase the arrow
             if (point[0] > lastEnd) {
                 arrows++;
                 lastEnd = point[1];
             }
         }

         return arrows;

    }

    //https://www.geeksforgeeks.org/problems/job-sequencing-problem-1587115620/1
    /*public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        // code here
        //find the maximum deadline
        int n = 0;
        for (int d : deadline) {
             n = Math.max(n, d);
        }

        int assignedJobs[] = new int[n+1];
        Arrays.fill(assignedJobs, -1);
        Integer index[] = new Integer[profit.length];
        for (int i = 0; i < profit.length; i++) {
            index[i] = i;
        }

        Arrays.sort(index, (a, b) -> profit[b] -profit[a]);

        int count = 0;
        int maxProfit = 0;


        for (int i = 0; i < profit.length; i++) {
            int ind = index[i];
            int d = deadline[ind];
            while (assignedJobs[ind] != -1) {
                d--;
            }

            if (d == 0) {
                continue;
            }

            count++;
            maxProfit += profit[]

        }

    }*/

    //https://www.geeksforgeeks.org/problems/assign-mice-holes3053/0
    public int assignHole(int[] mices, int[] holes) {
        // code here
        Arrays.sort(mices);
        Arrays.sort(holes);

        int maxTime = 0;
        for (int i = 0; i < mices.length; i++) {
            maxTime = Math.max(maxTime, Math.abs(mices[i] - holes[i]));
        }

        return maxTime;

    }

    //https://www.geeksforgeeks.org/problems/police-and-thieves--141631/1
    public int catchThieves(char[] arr, int k) {
        // code here
        int arrSize  = arr.length;
        int thief = -1;
        int police = -1;

        for (int i = 0; i < arrSize; i++) {
            if (police == -1 && arr[i] == 'P') {
               police = i;
            }
            if (thief == -1 && arr[i] == 'T') {
                thief = i;
            }
        }

        if (thief == -1 || police == -1) {
            return 0;
        }

        int caught = 0;
        while (police < arrSize && thief< arrSize) {
              if (Math.abs(police-thief) <=k) {
                 caught++;
                  police++;
                 while (police < arrSize && arr[police] != 'P') {
                     police++;
                 }
                  thief++;
                  while (thief < arrSize && arr[thief] != 'T') {
                      thief++;
                  }
              }
              else if (police < thief) {
                    police++;
                  while (police < arrSize && arr[police] != 'P') {
                      police++;
                  }
              }
              else {
                  thief++;
                  while (thief < arrSize && arr[thief] != 'T') {
                      thief++;
                  }
              }
        }
        return caught;
    }
}
