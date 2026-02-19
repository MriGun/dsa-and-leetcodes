package com.mricode.leetcode.dsa.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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

    //https://www.geeksforgeeks.org/problems/fractional-knapsack-1587115620/1
    class Item implements Comparable<Item>{
        int val;
        int wt;
        double ratio;
        Item(int v, int w){
            val = v;
            wt = w;
            ratio = (double)val/(double)wt;
        }
        //decresing order of ratio sort
        public int compareTo(Item that){
            if(this.ratio <= that.ratio) return 1;
            return -1;
        }
    }
    public double fractionalKnapsack(List<Integer> val, List<Integer>  wt, int capacity) {
        // code here
         int n = val.size();
         ArrayList<Item> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Item(val.get(i), wt.get(i)));
        }

        Collections.sort(list);

        double result = 0.0;
        for (Item item : list) {
            if (item.wt >= capacity) {
                result = result + (capacity * item.ratio);
                capacity = 0;
            }
            else {
                result = result + item.val;
                capacity = capacity - item.wt;
            }
            if (capacity == 0) {
                break;
            }
        }

        return result;

    }

    //https://leetcode.com/problems/maximum-units-on-a-truck/description/
    public int maximumUnits(int[][] boxTypes, int truckSize) {

        //sort in decreasing order of ratio
        //a[1], b[1] -> value of 1 item
        Arrays.sort(boxTypes, (a,b) -> b[1] - a[1]);
        int res = 0;
        for (int[] boxType : boxTypes) {
            if (boxType[0] > truckSize) {
                res += (truckSize * boxType[1]);
                truckSize = 0;
            }
            else {
                res += (boxType[0] * boxType[1]);
                truckSize -= boxType[0];
            }

            if (truckSize == 0) {
                break;
            }
        }
        return res;
    }

    //https://leetcode.com/problems/maximum-bags-with-full-capacity-of-rocks/description/
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {

        int size = rocks.length;
        int diff[] = new int[size];

        for (int i = 0; i < size; i++) {
            diff[i] = capacity[i] - rocks[i];
        }

        Arrays.sort(diff);

        int count = 0;
        for (int i = 0; i < size; i++) {
            if (diff[i] <= additionalRocks) {
                additionalRocks -= diff[i];
                diff[i] = 0;
            }
            if (diff[i] == 0) {
                count++;
            }
        }
        return count;
    }
}
