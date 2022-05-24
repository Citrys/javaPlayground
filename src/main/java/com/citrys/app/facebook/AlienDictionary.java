package com.citrys.app.facebook;

import java.util.*;

public class AlienDictionary {
    class Solution {
        public String alienOrder(String[] words) {
            StringBuilder output = new StringBuilder();
            Set<Character> unique = new HashSet<>();
            int minLenght = Integer.MAX_VALUE;
            for (int i = 0; i < words.length; i ++) {
                minLenght = Math.min(words[i].length(), minLenght);
            }

            List<Character> letters = new LinkedList<>();
            letters.add(0, 'a');
            HashMap<Character, Integer> map = new HashMap<>();
            for (int num: map.values()) {

            }

            for (String word: words) {
                for (int j = 0; j < minLenght; j ++) {
                    if (unique.contains(word.charAt(j)))
                    unique.add(word.charAt(j));
                }
            }
            unique.forEach(output::append);
            return output.toString();
        }
    }
}
