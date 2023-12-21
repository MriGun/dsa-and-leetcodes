package com.mricode.leetcode.dsa.binarysearch;

public class SmalletsLetter {

    //https://leetcode.com/problems/find-smallest-letter-greater-than-target/
    public static void main(String[] args) {
        char [] arr = {'a', 'b', 'g', 'k'};
        char target = 'k';
        /*int index = nextGreatestLetter(arr, target);
        int result = index != -1 ? arr[index] : index;
        System.out.println(result);*/
        System.out.println(nextGreatestLetter(arr, target));
    }

    public static char nextGreatestLetter(char[] letters, char target) {


        int start = 0;
        int end = letters.length -1;
        while (end >= start) {
            //find the middle element
            //int middle = (start + end) / 2;
            int middle = start + (end -start) / 2;

            if (target > letters[middle]) {
                start = middle + 1;
            }
            else  if (target == letters[middle]) {
                start = middle + 1;
            }
            else {
                end = middle - 1;
            }


            /*if (target < letters[middle]) {
                end = middle - 1;
            }
            else  {
                start = middle + 1;
            }*/

        }
        return letters[start % letters.length];
    }
}
