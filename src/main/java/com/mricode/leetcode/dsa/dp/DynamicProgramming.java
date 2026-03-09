package com.mricode.leetcode.dsa.dp;

import java.util.Arrays;

public class DynamicProgramming {

    //https://leetcode.com/problems/fibonacci-number/description/

    //normal recursion style
    // time complexity : 2 ^
    public int fib(int n) {

        //base case
        if (n <= 1) {
            return n;
        }
        return fib(n-1) + fib(n-2);
    }

    //dp style
    // time complexity : O(N)
    public int fib2(int n) {

        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        return fibByDp(n, dp);
    }

    //top  down approach
    public int fibByDp(int n, int[] dp) {

        //base case
        if (n <= 1) {
            dp[n] = n;
            return dp[n] ;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        dp[n] = fib(n-1) + fib(n-2);
        return dp[n];
    }


    //bottom up approach
    //also named as tabulation
    //tc : O(N)
    //sc : O(N)
    public int fib3(int n) {

        if (n <=1) {
            return n;
        }

        int dp[] = new int[n+1];

        //base ecase
        dp[0] = 0;
        dp[1] = 1;

        for (int state = 2; state <=n; state++) {
            dp[state] = dp[state-1] + dp[state-2];
        }

        return dp[n];
    }

    //space optimization
    public int fib4(int n) {

        if (n <=1) {
            return n;
        }
        //base ecase
        int prev2 = 0;
        int prev1 = 1;
        int ans = 0;

        for (int state = 2; state <=n; state++) {
            ans = prev1 + prev2;
            prev2 = prev1;
            prev1 = ans;
        }

        return ans;
    }

    //https://leetcode.com/problems/climbing-stairs/description/
    //tc: 2^n
    public int climbStairs(int n) {

        //base case
        if (n<=2) {
            return n;
        }

        return climbStairs(n-1) + climbStairs(n-2);
    }


    //dp way
    //top down approach
    //tc : O(n)
    //sc : O(n) + O(n)
    public int climbStairs2(int n) {
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        return recurclimbStairsWithTopDown(n, dp);
    }

    public int recurclimbStairsWithTopDown(int n, int[] dp) {
        //base case
        if (n<=2) {
            dp[n] = n;
            return dp[n] ;
        }

        if (dp[n] != -1) {
           return dp[n];
        }

        dp[n] = climbStairs(n-1) + climbStairs(n-2);
        return dp[n];
    }
    //bottom up approach
    //tc : O(n)
    public int climbStairs3(int n) {
        if (n<=2) {
            return n;
        }
        int dp[] = new int[n+1];

        dp[1] = 1;
        dp[2] = 2;

        for (int state = 3; state <= n; state++) {
            dp[state] = dp[state-1] + dp[state-2];
        }

        return dp[n];
    }

    //optimization
    public int climbStairs4(int n) {
        if (n<=2) {
            return n;
        }

        int prev1 = 2;
        int prev2 = 1;
        int ans = 0;

        for (int state = 3; state <= n; state++) {
            ans = prev1 + prev2;
            prev2 = prev1;
            prev1 = ans;
        }

        return ans;
    }

    //https://leetcode.com/problems/counting-bits/description/
    public int[] countBits(int n) {

        int dp[] = new int[n+1];
        for (int i = 0; i <= n; i++) {
            dp[i] = dp[i>>1] + (i&1);
        }

        return dp;

    }

    //https://leetcode.com/problems/min-cost-climbing-stairs/description/
    public int minCostClimbingStairs(int[] cost) {

        int dp[] = new int[cost.length+1];
        Arrays.fill(dp, -1);

        //return minCostClimbingStairsRecur(cost, cost.length);
        return minCostClimbingStairsRecurDP(cost, cost.length, dp);
    }

    public int minCostClimbingStairsRecur(int[] cost, int n) {
        //base case
        if  (n ==0 || n==1) {
            return 0;
        }

        int oneStep = cost[n-1] + minCostClimbingStairsRecur(cost, n-1);
        int twoStep = cost[n-2] + minCostClimbingStairsRecur(cost, n-2);

        return Math.min(oneStep, twoStep);

    }

    //dp way
    public int minCostClimbingStairsRecurDP(int[] cost, int n, int dp[]) {
        //base case
        if  (n ==0 || n==1) {
            dp[n] = 0;
            return 0;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        int oneStep = cost[n-1] + minCostClimbingStairsRecurDP(cost, n-1, dp);
        int twoStep = cost[n-2] + minCostClimbingStairsRecurDP(cost, n-2, dp);

        dp[n] = Math.min(oneStep, twoStep);

        return dp[n];

    }

    //bottom up solution
    public int minCostClimbingStairsBottomUp(int[] cost) {

        int dp[] = new int[cost.length+1];
        int n = cost.length;
        int prev2 = 0;
        int prev1  = 0;
        int ans = 0;

        for (int state = 2; state <=n; state++) {
            int oneStep = cost[state-1] + dp[state-1];
            int twoStep = cost[state-2] + dp[state-2];
            ans = Math.min(oneStep, twoStep);
            prev2 = prev1;
            prev1 = ans;
        }

        return ans;
    }


    //https://leetcode.com/problems/house-robber/description/
    public int rob(int[] nums) {
        //return  robRecur(nums, nums.length-1);
        int n = nums.length;
        int dp[] = new int [n+1];
        Arrays.fill(dp, -1);
        return robRecurTopDownDp(nums, n, dp);
    }

    //bottom up approach
    public int robWithBottomUp(int[] nums) {
        //return  robRecur(nums, nums.length-1);
        int n = nums.length;
        int dp[] = new int [n+1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int state = 2; state < n+1; state++) {
            int pick = nums[state-1] + dp[state-2];
            int noPick = 0 + dp[state-1];
            dp[state] = Math.max(pick, noPick);
        }

        return dp[n];
    }


    public int robWithBottomUpWithSpaceOptimized(int[] nums) {
        //return  robRecur(nums, nums.length-1);

        int n = nums.length;
        if (n ==1) {
            return nums[0];
        }
        int prev2 = 0;
        int prev1 = nums[0];
        int ans = 0;
        for (int state = 2; state < n+1; state++) {
            int pick = nums[state-1] + prev2;
            int noPick = 0 + prev1;
            ans = Math.max(pick, noPick);
            prev2 = prev1;
            prev1 = ans;
        }

        return ans;
    }



    //normal recursion way
    public int robRecur(int[] nums, int index) {

        //base case
        if (index == 0) {
            return nums[0];
        }

        if (index == -1) {
            return 0;
        }

        //pick and no pick logic
        int pick = nums[index] + robRecur(nums, index-2);
        int noPick = 0 + robRecur(nums, index-1);

        return Math.max(pick, noPick);

    }

    //top down dp way
    //shifting logic
    public int robRecurTopDownDp(int[] nums, int index, int dp[]) {

        //base case
        if (index == 1) {
            dp[index] = nums[0];
            return nums[0];
        }

        if (index == 0) {
            dp[index] = 0;
            return 0;
        }

        if (dp[index] != -1) {
            return dp[index];
        }

         //pick and no pick logic

        //pick and no pick logic
        int pick = nums[index-1] + robRecurTopDownDp(nums, index-2, dp);
        int noPick = 0 + robRecurTopDownDp(nums, index-1, dp);

        dp[index] = Math.max(pick, noPick);
        return dp[index];

    }

    //https://leetcode.com/problems/house-robber-ii/description/
    public int rob2WithBottomUpWithSpaceOptimized(int[] nums) {
        //return  robRecur(nums, nums.length-1);

        int n = nums.length;
        if (n ==1) {
            return nums[0];
        }
        int num1[] = new int[n-1];
        int num2[] = new int[n-1];
        int j = 0;
        int k = 0;

        for (int i = 0; i < n; i++) {
            if (i != 0) {
                num1[j] = nums[i];
                j++;
            }

            if (i != n-1) {
                num2[k] = nums[i];
                k++;
            }
        }

        return Math.max(robWithBottomUpWithSpaceOptimized(num1), robWithBottomUpWithSpaceOptimized(num2));
    }

    //https://www.geeksforgeeks.org/problems/check-if-there-exists-a-subsequence-with-sum-k/0
    public static boolean checkSubsequenceSum(int N, int[] arr, int K) {
        // code here
        int dp[][] = new int[N][K+1];
        return checkSubsequenceSumRecur(arr, K, N-1, dp);
    }

    //1 -> true
    //2 -> false
    //0 -> not visited
    public static boolean checkSubsequenceSumRecur(int[] arr, int K, int index, int dp[][]) {
        // code here

        //base case
        if (K == 0) {
            dp[index][K] = 1;
            return true;
        }

        if (index == 0) {
            if (K == arr[index]) {
                dp[index][K] = 1;
                return true;
            }
            else {
                dp[index][K] = 2;
                return false;
            }
        }

        if (dp[index][K] != 0) {
            return dp[index][K] == 1;
        }

        //pick and no pick logic
        boolean pick = false;
        if (arr[index] <= K) {
            pick = checkSubsequenceSumRecur(arr, K-arr[index], index-1, dp);
            if (pick) {
                dp[index][K] = 1;
                return true;
            }
        }

        boolean noPick = checkSubsequenceSumRecur(arr, K, index-1, dp);
        dp[index][K] = noPick ? 1 : 0;
        return noPick;

    }

    public static boolean checkSubsequenceSumBottomUp(int N, int[] arr, int K) {
        // code here
        int dp[][] = new int[N][K+1];
        for (int i = 0; i < N; i++) {
            dp[i][0] = 1;
        }

        for (int t = 1; t <=K; t++) {
            if (t == arr[0]) {
                dp[0][t] = 1;
            }
            else {
                dp[0][t] = 2;
            }
        }

        for (int i = 1; i <N; i++) {
            for (int j = 1; j <=K; j++) {
                int pick = 2;
                if (arr[i] <= j) {
                    pick = dp[i-1][j-arr[i]]; //checkSubsequenceSumRecur(arr, K-arr[i], i-1, dp);
                    if (pick == 1) {
                        dp[i][j] = 1;
                        continue;
                    }
                }

                int noPick = dp[i-1][j];//checkSubsequenceSumRecur(arr, j, i-1, dp);
                dp[i][j] = noPick;
            }
        }
        return dp[N-1][K] == 1;
    }

}
