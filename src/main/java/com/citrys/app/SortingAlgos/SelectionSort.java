package com.citrys.app.SortingAlgos;

public class SelectionSort {
    public void selectionSort(int[] nums) throws Exception {
        if (nums.length <= 0) {
            throw new Exception("Fuck off");
        } else {
            for (int lastUnsorted = nums.length - 1; lastUnsorted > 0; lastUnsorted--) {
                int max = 0;
                for (int i = 0; i <= lastUnsorted; i++) {
                    if (nums[i] > nums[max]) {
                        max = i;
                    }
                }
                new BubbleSort().swap(nums, max, lastUnsorted);
            }
        }
    }
}
