package com.citrys.app.arraysTest;

import com.citrys.app.coding_iterview_book.arrays.StringsPermutations;
import org.junit.Test;
import static org.junit.Assert.*;

public class checkIfStringsPermutation {
    @Test
    public void isMadeofSameStrings(){
        StringsPermutations test = new StringsPermutations();
        assertTrue(test.isPermutationOfEachOther("dog", "god"));
    }

    @Test
    public void isMadeofSameStrings2(){
        StringsPermutations test = new StringsPermutations();
        assertTrue(test.isPermutationArrays("dog", "god"));
    }

    @Test
    public void isMadeofSameStrings2Not(){
        StringsPermutations test = new StringsPermutations();
        assertFalse(test.isPermutationArrays("dog", "godf"));
    }
}
