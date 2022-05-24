package com.citrys.app;
import com.citrys.app.leetcode.TwoSum;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


public class TwoSumTest {
    @Test
    public void shouldBeSomeResult01() {
        int[] nums = new int[]{2,7,11,15};
        int target = 9;
        TwoSum checker = new TwoSum();
        assertArrayEquals(checker.twoSum(nums, target), new int[]{0,1});
    }

    @Test
    public void shouldBeSomeResult21() {
        int[] nums = new int[]{3,2,4};
        int target = 6;
        TwoSum checker = new TwoSum();
        assertArrayEquals(checker.twoSum(nums, target), new int[]{1,2});
    }

    @Test
    public void simpleVsBetter() {
        int[] nums = new int[]{3,2,4};
        int target = 6;
        TwoSum checker = new TwoSum();
        assertArrayEquals(checker.twoSum(nums, target), checker.twoSumSimple(nums, target));
    }

}
