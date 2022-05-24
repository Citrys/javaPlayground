package com.citrys.app.facebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntegerToEnglishLetters {
    public String one(Integer num) {
        switch (num) {
            case 1:
                return "One";
            case 2:
                return "Two";
            case 3:
                return "Three";
        }
        return "";
    }

    public String two(Integer num) {
        switch (num) {
            case 10:
                return "Ten";
            case 11:
                return "Eleven";
            case 12:
                return "Twelve";
        }
        return "";
    }

    public String tens(Integer num) {
        switch (num) {
            case 2:
                return "Twenty";
            case 3:
                return "Thirty";
            case 4:
                return "Forty";
        }
        return "";
    }

    public String twoConvert(Integer num) {
        if (num == 0) {
            return "";
        }
        if (num < 10) {
            return one(num);
        }
        if (num > 10 && num < 20) {
            return two(num);
        } else {
            int tens = num / 10;
            int rest = num % 10;
            if (rest != 0) {
                return tens(tens) + " " + one(rest);
            }
            return tens(tens);
        }
    }

    public String convertThirty(Integer num) {
        int hundreds = num / 100;
        int rest = num % 100;
        if (rest != 0) {
            return one(hundreds) + " Hundred" + twoConvert(rest);
        } else if (hundreds == 0) {
            return twoConvert(rest);
        } else {
            return one(hundreds) + " Hundred";
        }
    }

    public String numberToWords(int num) {
        if (num == 0)
            return "Zero";
        List<Integer> internal = new ArrayList<>();
        internal.clear();

        int billion = num / 1000000000;
        int million = (num - billion * 1000000000) / 1000000;
        int thousand = (num - billion * 1000000000 - million * 1000000) / 1000;
        int rest = num - billion * 1000000000 - million * 1000000 - thousand * 1000;

        String result = "";
        if (billion != 0)
            result = convertThirty(billion) + " Billion";
        if (million != 0) {
            if (! result.isEmpty())
                result += " ";
            result += convertThirty(million) + " Million";
        }
        if (thousand != 0) {
            if (! result.isEmpty())
                result += " ";
            result += convertThirty(thousand) + " Thousand";
        }
        if (rest != 0) {
            if (! result.isEmpty())
                result += " ";
            result += convertThirty(rest);
        }
        return result;
    }

}


class Solution22 {
    private final String[] belowTen = new String[] {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    private final String[] belowTwenty = new String[] {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] belowHundred = new String[] {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        return helper(num);
    }

    private String helper(int num) {
        String result;
        if (num < 10) result = belowTen[num];
        else if (num < 20) result = belowTwenty[num -10];
        else if (num < 100) result = belowHundred[num/10] + " " + helper(num % 10);
        else if (num < 1000) result = helper(num/100) + " Hundred " +  helper(num % 100);
        else if (num < 1000000) result = helper(num/1000) + " Thousand " +  helper(num % 1000);
        else if (num < 1000000000) result = helper(num/1000000) + " Million " +  helper(num % 1000000);
        else result = helper(num/1000000000) + " Billion " + helper(num % 1000000000);
        return result.trim();
    }
}
