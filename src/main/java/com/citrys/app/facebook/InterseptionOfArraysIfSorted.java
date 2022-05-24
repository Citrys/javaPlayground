package com.citrys.app.facebook;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class InterseptionOfArraysIfSorted {

    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums2.length == 0)
            return new int[0];

        int len1 = nums1.length;
        int len2 = nums2.length;

        // If not sorted
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        Set<Integer> result = new HashSet<>();

        for (int idx1 = 0, idx2 = 0; idx1 < len1 && idx2 < len2; ) {
            if (nums1[idx1] == nums2[idx2]) {
                result.add(nums1[idx1]);
                idx1++;
                idx2++;
            } else if (nums1[idx1] < nums2[idx2]) idx1++;
            else
                idx2++;
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}
