package com.citrys.app.facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length && nums[i] <= 0; i ++) {
            if (i == 0 || nums[i - 1] != nums[i]) {
                twoSumPointers(i, nums, res);
            }
        }
        return res;
    }

    void twoSumPointers(int i, int[] nums, List<List<Integer>> res) {
        int high = nums.length - 1;
        int low = i + 1;
        while (low < high) {
            int sum = nums[i] + nums[low] + nums[high];
            if (sum < 0) {
                low ++;
            } else if (sum > 0) {
                high --;
            } else {
                res.add(Arrays.asList(nums[i], nums[low ++], nums[high --]));
                while (low < high && nums[low] == nums[low -1]) {
                    ++ low;
                }
            }
        }
    }
}
