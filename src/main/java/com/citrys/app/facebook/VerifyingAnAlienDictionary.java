import java.util.HashMap;

class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        HashMap <Character, Integer> wordsmap = new HashMap<>();
        for (int i = 0; i < order.length(); i ++) {
            wordsmap.put(order.charAt(i), i);
        }

        for (int i  = 0; i < words.length - 1; i ++) {
            char[] word1 = words[i].toCharArray();
            char[] word2 = words[i + 1].toCharArray();
            for (int k = 0; k < Math.min(word1.length, word2.length); k ++) {
                char letter1 = word1[k];
                char letter2 = word2[k];
                if (word1[k] != word2[k]) {
                    if (wordsmap.get(letter1) >  wordsmap.get(letter2)) {
                        return false;
                    }
                }
            }
            if (word1.length > word2.length) {
                return false;
            }
        }
        return false;
    }
}