package com.citrys.app;

import com.google.common.base.CharMatcher;
import org.jetbrains.annotations.NotNull;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class AnagramReader {
    public HashMap<String, List<String>> anagramDetector(String[] arr) {
        // Space will be used only for a consecutive set of identical length words
        HashMap<String, List<String>> results = new HashMap<>();
        if (arr.length == 0) {
            return results;
        }

        //O(N) for processing all words
        for (String current : arr) {
            String offSet = getOffSet(current);
            if (results.containsKey(offSet)) {
                List<String> items = results.get(offSet);
                items.add(current);
                results.put(offSet, items);
            } else {
                results.put(offSet, new ArrayList<String>() {{
                    add(current);
                }});
            }
        }
        return results;
    }

    // O(m) - m the max number of letters in the word
    public String getOffSet(@NotNull String str) {
        int[] frequencyArr = new int[128];
        for (int i = 0; i < str.length(); i++) {
            frequencyArr[str.charAt(i) - 'a']++;
        }
        return Arrays.toString(frequencyArr);
    }

    void printMapValues(@NotNull Map mp) {
        Iterator it = mp.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            System.out.println(pair.getValue());
            it.remove(); // avoids a ConcurrentModificationException
        }
    }

    void getAnagramValues(List<String> buffer) {
        HashMap<String, List<String>> res = this.anagramDetector(buffer.toArray(new String[0]));
        this.printMapValues(res);
        buffer.clear();
    }

    public int searchInsert(int[] nums, int target) {
        if (target > nums[nums.length - 1]) {
            return nums.length;
        }

        if (target < nums[0] || nums.length == 1) {
            return 0;
        }
        int temTarget = target;
        int nextGreaterPosition = -1;
        while (nextGreaterPosition < 0 && temTarget <= nums[nums.length - 1]) {
            nextGreaterPosition = binarySearch(nums, temTarget++);
        }
        if (nextGreaterPosition == 1) {
            return 1;
        } else if (nextGreaterPosition == nums.length) {
            return nextGreaterPosition - 1;
        } else if (nums[nextGreaterPosition] == target) {
            return nextGreaterPosition;
        } else {
            return nextGreaterPosition - 1;
        }

    }


    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }

    private int binarySearch(@NotNull int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + ((end - start) / 2);
            if (nums[mid] < target) {
                start = mid + 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else if (nums[mid] == target) {
                return mid;
            }
        }
        return -1;
    }

    public int romanToInt(String s) {
        int ans = 0;
        HashMap<Character, Integer> letters = new HashMap<Character, Integer>() {{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }};

        int n = s.length() - 1;
        while (n >= 0) {
            char latin = s.charAt(n);
            if (latin == 'V' && s.charAt(n - 1) == 'I') {
                ans += 5;
                n -= 2;
            } else if (latin == 'X' && s.charAt(n - 1) == 'I') {
                ans += 9;
                n -= 2;
            } else if (latin == 'L' && s.charAt(n - 1) == 'X') {
                ans += 40;
                n -= 2;
            } else if (latin == 'C' && s.charAt(n - 1) == 'X') {
                ans += 90;
                n -= 2;
            } else if (latin == 'D' && s.charAt(n - 1) == 'C') {
                ans += 400;
                n -= 2;
            } else if (latin == 'M' && s.charAt(n - 1) == 'C') {
                ans += 400;
                n -= 2;
            } else {
                ans += letters.get(latin);
                n--;
            }
        }
        return ans;

    }
}


class TestApp {
    public static void main(String[] args) throws IOException {

        try (FileInputStream inputStream = new FileInputStream("/Users/dmitrybondarenko/Documents/interview_tasks/javaPlayground/src/main/java/com/citrys/app/items.txt"); Scanner sc = new Scanner(inputStream, "UTF-8")) {
            List<String> buffer = new ArrayList<>();
            AnagramReader reader = new AnagramReader();
            while (sc.hasNextLine()) {
                String newline = sc.nextLine();
                if (CharMatcher.ascii().matchesAllOf(newline)) {
                    if (buffer.size() != 0 && newline.length() != buffer.get(buffer.size() - 1).length()) {
                        reader.getAnagramValues(buffer);
                    }
                    buffer.add(newline);
                }
            }
            reader.getAnagramValues(buffer);
            if (sc.ioException() != null) {
                throw sc.ioException();
            }
        }
    }
}