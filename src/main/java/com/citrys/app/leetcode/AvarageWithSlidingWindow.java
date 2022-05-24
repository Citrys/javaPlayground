package com.citrys.app.leetcode;

public class AvarageWithSlidingWindow {
    public double[] averageSliding(int[] arrs, int counter) {
        double[] avSums = new double[arrs.length - counter + 1];
        int windowStart = 0;
        double avWindowSum = 0;
        int k = 0;
        for (int endWin = 0; endWin < arrs.length; endWin ++) {
            avWindowSum += arrs[endWin];
            if (endWin >= counter - 1) {
                avSums[k++] = avWindowSum / counter;
                avWindowSum -= arrs[windowStart ++];
            }
        }
        return avSums;
    }
}
