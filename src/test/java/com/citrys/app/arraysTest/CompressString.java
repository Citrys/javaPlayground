package com.citrys.app.arraysTest;

import com.citrys.app.coding_iterview_book.arrays.StringCompression;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CompressString {
    @Test
    public void compressTest(){
        StringCompression test = new StringCompression();
        assertEquals(test.stringCompress("aaabbbcc"), "a3b3c2");

    }
}
