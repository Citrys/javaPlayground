package com.citrys.app.SortingAlgos;

public class InsertionSort {
    public void insertionSort(int[] nums) throws Exception {
        if (nums.length <= 0) {
            throw new Exception("Fuck off bitch");
        } else {
            for (int firstUnsorted = 1; firstUnsorted < nums.length; firstUnsorted++) {
                int newElement = nums[firstUnsorted];
                int i;
                for (i = firstUnsorted; i > 0 && nums[i - 1] > newElement; i--) {
                    nums[i] = nums[i - 1];
                }
                nums[i] = newElement;
            }
        }
    }
}
