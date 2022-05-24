package com.citrys.app.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

class ContiguousMaxSubarray {
    public static int findMaxSumSubArray(int k, int[] arr) {
        PriorityQueue<Integer> q = new PriorityQueue<>(1, Comparator.naturalOrder());
        int startPoint = 0;
        int kArraySum = 0;
        for (int endWindow = 0; endWindow < arr.length; endWindow ++) {
            kArraySum += arr[endWindow];
            if (endWindow >= k - 1) {
                q.add(kArraySum);
                kArraySum -= arr[startPoint];
                startPoint ++;
            }
        }

        return q.poll();
    }
}
