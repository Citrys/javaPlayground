package com.citrys.app.coding_iterview_book.arrays;

public class StringsPermutations {
    public boolean isPermutationOfEachOther(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        else return this.sortStrings(str1).equals(this.sortStrings(str2));
    }

    private String sortStrings(String a) {
       char[] items = a.toCharArray();
       java.util.Arrays.sort(items);
       return new String(items);
    }

    public boolean isPermutationArrays(String str1, String str2) {
        int[] charsCounter = new int[128];
        for (int i  = 0; i < str1.length(); i ++ ) {
            int index = str1.charAt(i);
            charsCounter[index] ++;
        }

        for (int j = 0; j < str2.length(); j ++ ) {
            int index = str2.charAt(j);
            charsCounter[index] --;
            if (charsCounter[index] < 0) {
                return false;
            }
        }
        return true;
    }
}
