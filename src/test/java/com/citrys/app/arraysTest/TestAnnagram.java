package com.citrys.app.arraysTest;

import com.citrys.app.AnagramReader;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Unit test for simple App.
 */
public class TestAnnagram {
    @Test
    public void shouldBeEqual() {
        String[] arr = new String[]{"", "", ""};
        AnagramReader ana = new AnagramReader();
        ana.getOffSet("abc");
        assertNotEquals(ana.getOffSet("accoutered"),  ana.getOffSet("acidulates"));
        assertEquals(ana.getOffSet("bac"),  ana.getOffSet("cba"));
        assertNotEquals(ana.getOffSet("bac"),  ana.getOffSet("cbaa"));
    }

    @Test
    public void testAnagramOutput() {
        String[] arr = new String[]{"abc", "fun", "bac", "cba", "unf", "hello", "goodbuy"};

        AnagramReader ana = new AnagramReader();
        ana.anagramDetector(arr);
    }

    @Test
    public void testRoman() {
        String test = "IV";
        AnagramReader ana = new AnagramReader();
        ana.romanToInt(test);
    }

    @Test
    public void searchInsertRoman() {
        AnagramReader ana = new AnagramReader();
        ana.searchInsert(new int[]{1,3,4,5,7,8}, 2);
    }

    @Test
    public void searchPrefix() {
        AnagramReader ana = new AnagramReader();
        ana.longestCommonPrefix(new String[]{"flower","flow","flight"});
    }
}
