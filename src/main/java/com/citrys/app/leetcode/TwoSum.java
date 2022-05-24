package com.citrys.app.leetcode;

import java.net.Inet6Address;
import java.net.InetAddress;
import java.util.*;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> minusValues = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                minusValues.put(nums[i], i);
            }
            for (int i = 0; i < nums.length; i ++) {
                int test = target - nums[i];
                if (minusValues.containsKey(test) && minusValues.get(test) != i) {
                    return new int[]{i, minusValues.get(test)};
                }
            }
              throw new IllegalArgumentException("No two sum solution");
    }

    public static void plusMinus(List<Integer> arr) {
        if (arr.size() == 0) {
            System.out.println(0);
        }
        HashMap<Integer, Integer> res = new HashMap<>();
        for (int num: arr) {
            if (num < 0) {
                res.put(res.getOrDefault(-1, 0), +1);
            } else if (num > 0) {
                res.put(res.getOrDefault(1, 0), +1);
            } else {
                res.put(res.getOrDefault(0, 0), +1);
            }
        }

        for (Integer value : res.values()) {
            System.out.println(value/arr.size());
        }
    }

    public List<String> checkIps(List<String> ips) {
        List<String> result = new LinkedList<>();
        for (String ip : ips) {
            try {
                result.add((InetAddress.getByName(ip) instanceof Inet6Address) ? "IPv6": "IPv4");
            } catch(Exception ignored) {}
            result.add("Neither");
        }
        return result;
    }


    public int[] twoSumSimple(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length; j++) {
                if (i != j && nums[i] + nums[j] == target){
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
