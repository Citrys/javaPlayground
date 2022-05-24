package com.citrys.app.arraysTest;

import com.citrys.app.leetcode.MergeTwoSortedArrays;
import org.junit.Test;

public class TestMergedArrays {
    @Test
    public void testMerged(){
        MergeTwoSortedArrays test = new MergeTwoSortedArrays();
        test.merge(new int[]{1,2,3,0,0,0}, 3, new int[]{2,5,6}, 3);
    }
}
