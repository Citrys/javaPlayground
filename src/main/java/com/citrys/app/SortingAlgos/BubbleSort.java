package com.citrys.app.SortingAlgos;

public class BubbleSort {
    public void bubbleSort(int[] nums) {
        for (int lastUnsorted = nums.length - 1; lastUnsorted > 0; lastUnsorted--) {
            for (int i = 0; i < lastUnsorted; i++) {
                if (nums[i] > nums[i+1]) {
                    swap(nums, i, i + 1);
                }
            }
        }
    }

    public void swap(int[] array, int i, int j) {
        if (i == j) return;
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }
}