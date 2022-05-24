package com.citrys.app.leetcode;

import java.util.HashMap;
import java.util.Map;

public class DecodeWayString {
    public int decodeNumberOfString(String inputString) {
        return recursiveHelper(0, inputString);
    }

    private Map<Integer, Integer> memo = new HashMap<>();
    private int recursiveHelper(int index, String inputString) {
        if (memo.containsKey(index)) {
            return memo.get(index);
        }
        if (index == inputString.length()){
            return 1;
        }
        if (inputString.charAt(index) == '0'){
            return 0;
        }
        if (index == inputString.length() - 1){
            return 1;
        }
        int ans = recursiveHelper(index+1, inputString);
        if (Integer.parseInt(inputString.substring(index, index + 2)) <= 26){
            ans += recursiveHelper(index + 2, inputString);
        }
        return ans;
    }
}
