package com.citrys.app.coding_iterview_book.arrays;

public class StringCompression {
    public String stringCompress(String str) {
        StringBuilder output = new StringBuilder();
        int counter = 0;
        for (int i = 0; i <= str.length() - 1; i ++) {
            counter ++;
            if ( i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                output.append(str.charAt(i));
                output.append(counter);
                counter = 0;
            }
        }
        return output.length() < str.length() ? output.toString(): str;
    }
}
