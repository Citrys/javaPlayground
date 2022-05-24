package com.citrys.app.leetcode;

public class TrappingRainWater {
    public int trap(int[] height) {

       if (height.length == 0) {
           return 0;
       }
       int ans = 0;
       int size = height.length;
       int[] left_max = new int[height.length];
       int[] right_max = new int[height.length];

       left_max[0] = height[0];
       for (int i = 1; i < height.length; i ++) {
           left_max[i] = Math.max(left_max[i - 1], height[i]);
       }

       right_max[size - 1] = height[size - 1];

       for (int i = size - 2; i >= 0; i --) {
           right_max[i] = Math.max(right_max[i + 1], height[i]);
       }

       for (int i = 0; i < height.length; i ++ ) {
           ans = Math.min(left_max[i], right_max[i]) - height[i];
       }
       return ans;
    }
}
