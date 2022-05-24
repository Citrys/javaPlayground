package com.citrys.app.coding_iterview_book.arrays;

public class RotateMatrix90 {
    public void rotateTheMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix.length != matrix[0].length) {
            return;
        }
        int n = matrix.length;
        for (int layer = 0; layer < n; layer ++) {
            int end = n - 1 - layer;
            for (int i = layer; i < end; i++) {
                int offset = i - layer;

                int top = matrix[layer][i];

                matrix[layer][i] = matrix[end - offset][layer];
                matrix[end - offset][layer] = matrix[end][end - offset];
                matrix[end][end - offset] = matrix[i][end];
                matrix[i][end] = top;
            }
        }
    }
}
