package com.citrys.app.coding_iterview_book.arrays;

import java.util.BitSet;

public class IsAllUnique {
    public static boolean isAllUniqueLetters(String input) {
        if (input.length() > 128) {
            return false;
        }
        boolean[] charsArr = new boolean[128];
        for (int i = 0; i < input.length(); i ++ ){
            int charIndex = input.charAt(i);
            if (charsArr[charIndex]) {
                return false;
            }
            charsArr[charIndex] = true;
        }
        return true;
    }

    public static boolean isAllUniqueWithBitVector(String srt) {
        BitSet checker = new BitSet();
        for (int i  = 0; i < srt.length(); i++){
            int chatIndex = srt.charAt(i);
            if (checker.get(chatIndex)){
                return false;
            }
            checker.set(chatIndex);
        }
        System.out.println(checker);
        return true;
    }
}
