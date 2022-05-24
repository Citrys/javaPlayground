package com.citrys.app.facebook;

import java.util.ArrayList;
import java.util.Arrays;

interface BinaryMatrix {
    public int get(int row, int col);
 };
class BinaryMatrixIml implements BinaryMatrix {

    @Override
    public int get(int row, int col) {

        return 0;
    }

    ArrayList<Integer> dimensions = new ArrayList<>(Arrays.asList(1,2));

}


class Solution44 {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        int cols = binaryMatrix.get(0,0);
        int rows = binaryMatrix.get(1,2);
        int ans = cols;
        for (int i = 0; i < rows; i ++) {
            int low = 0;
            int high = cols - 1;
            while (low < high) {
                int mid = (low + high) / 2;
                if (binaryMatrix.get(i, mid) == 0) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            if (binaryMatrix.get(i, low) == 1) {
                ans = Math.min(ans, low);
            }
        }
        return ans == cols ? -1 : ans;
    }
}
