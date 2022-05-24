package com.citrys.app.facebook;

public class AddTwoNumbers {
    public String addStrings(String num1, String num2) {
        StringBuilder ans = new StringBuilder();
        int carry = 0;
        int p1 = num1.length() - 1;
        int p2 = num2.length() - 1;
        while (p1 >= 0 || p2 >= 0) {
            int x1 = p1 >= 0 ? num1.charAt(p1) - '0': 0;
            int x2 = p2 >= 0 ? num2.charAt(p2) - '0': 0;
            int sum = (x1 + x1 + carry) % 10;
            carry = (x1 + x1 + carry) / 10;
            ans.append(sum);
            p1 --;
            p2 --;
        }
        ans.append(carry);
        ans.reverse();
        return ans.toString();
    }
}
