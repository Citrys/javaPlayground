package com.citrys.app.coding_iterview_book.arrays;

public class StringPermutationPalindom {
    public boolean isStringPermutationPalindom(String str) {
        int[] t = buildTable(str);
        return testCharsMap(t);
    }

    private int mapCharToNumber(Character c) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue(c);
        if (a <= val && val <= z) {
            return val - a;
        }
        return -1;
    }

    private boolean testCharsMap(int[] table) {
        boolean foundOdd = false;
        for (int c: table) {
            if (c % 2 == 1) {
                if (foundOdd) {
                    return false;
                }
                foundOdd = true;
            }
        }
        return true;
    }

    private int[] buildTable(String str) {
        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
        for (char c: str.toCharArray()) {
            int val = mapCharToNumber(c);
            if (val != -1) {
                table[val] ++;
            }
        }
        return table;
    }
}
