package com.citrys.app.arraysTest;

import com.citrys.app.coding_iterview_book.arrays.StringPermutationPalindom;
import org.junit.Test;

import static org.junit.Assert.*;

public class stringPermutationPalindorme {
    @Test
    public void testPalindoemPermutation(){
        StringPermutationPalindom test = new StringPermutationPalindom();
        assertTrue(test.isStringPermutationPalindom("taco cat"));

    }
}
