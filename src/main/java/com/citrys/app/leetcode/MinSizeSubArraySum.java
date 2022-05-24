package com.citrys.app.leetcode;

public class MinSizeSubArraySum {
    public static int findMinSubArray(int S, int[] arr) {
        int ans = Integer.MAX_VALUE;
        int start = 0;
        int tempSum = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            tempSum += arr[windowEnd];
            while (tempSum >= S) {
                ans = Math.min(ans, windowEnd - start + 1);
                tempSum -= arr[start];
                start++;
            }
        }
        return ans;
    }


    public static int findMinSubArray2(int S, int[] arr) {
        int ans = Integer.MAX_VALUE;
        int tempSum = 0;
        int start = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            tempSum += arr[windowEnd]; // add the next element
            // shrink the window as small as possible until the 'windowSum' is smaller than 'S'
            while (tempSum >= S) {
                ans = Math.min(ans, windowEnd - start + 1);
                tempSum -= arr[start]; // subtract the element going out
                start++; // slide the window ahead
            }
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
