package com.citrys.app.leetcode;

import com.citrys.app.utils.Printer;

public class MaxLenght {
    public  static int maxLength(String s, char target) {
        char [] arr = s.toCharArray();
        int max = 0;
        int start = 0;

        for (int i = 0; i < arr.length; i ++) {
            if (arr[i] == target) {
                start = i;
                break;
            }
        }

        for (int end = start; end < arr.length; end ++) {
            if (arr[end] == target) {
                max = Math.max(max, end - start - 1);
                start = end;
            }
        }
        return max;
    }
}

class TestMax {
    public static void main(String[] args) {
        String test = "aaaaabaaabaaaaaaabasdasdasdasdasdb";
        Printer.print(MaxLenght.maxLength(test, 'b'));
    }
}