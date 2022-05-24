package com.citrys.app.arraysTest;

import com.citrys.app.coding_iterview_book.arrays.IsAllUnique;
import org.junit.Test;

import static org.junit.Assert.*;

public class isAllUniqueTest {
    @Test
    public void testAllUniqueTrue() {
        assertTrue(IsAllUnique.isAllUniqueLetters("abcd"));
    }

    @Test
    public void testAllUniqueFalse() {
        assertFalse(IsAllUnique.isAllUniqueLetters("abcda"));
    }

    @Test
    public void testAllUniqueVectorFalse() {
        assertFalse(IsAllUnique.isAllUniqueWithBitVector("abcda"));
    }
}
