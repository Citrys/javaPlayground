package com.citrys.app.lists;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

class HappyNumber {

    public static boolean find(int num) {
        int slow = num, fast = num;
        do {
            slow = findSquareSum(slow); // move one step
            fast = findSquareSum(findSquareSum(fast)); // move two steps
        } while (slow != fast); // found the cycle

        return slow == 1; // see if the cycle is stuck on the number '1'
    }

    private static int findSquareSum(int num) {
        int sum = 0, digit;
        while (num > 0) {
            digit = num % 10;
            sum += digit * digit;
            num /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(HappyNumber.find(23));
        System.out.println(HappyNumber.find(12));

        List<String> numbers = Arrays.asList("1", "2", "3", "4", "5", "6");

        List<Integer> ints = numbers.stream().map(Integer::valueOf).filter(s -> s > 2).collect(Collectors.toList());

        System.out.println(ints);

    }
}