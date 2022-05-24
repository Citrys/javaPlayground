package com.citrys.app;

import com.citrys.app.leetcode.DecodeWayString;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestDecodeString {
    @Test
    public void testDecodeWays() {
        DecodeWayString test = new DecodeWayString();
        int res = test.decodeNumberOfString("111111111111111111111111111111111111111111111");
        assertEquals(res, 1836311903);
    }
}
