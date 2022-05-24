package com.citrys.app.leetcode;

public class InvertTheMatrix {
    public static int[][] flipAndInvertImage(int[][] arr) {
        for (int i = 0; i < arr.length; i ++) {
            int j = 0;
            int k = arr[0].length - 1;
            while (j < k) {
                int temp = arr[i][j];
                arr[i][j] = arr[i][k];
                arr[i][k] = temp;
                j ++;
                k --;
            }
        }
        for (int i = 0; i < arr.length; i ++) {

        }
        return arr;
    }

    public static void print(int[][] arr) {
        for(int i=0; i < arr.length; i++) {
            for (int j=0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 0, 1}, {1, 1, 1}, {0, 1, 1}};
        print(flipAndInvertImage(arr));

        int[][]arr2 = {{1,1,0,0},{1,0,0,1},{0,1,1,1},{1,0,1,0}};
        print(flipAndInvertImage(arr2));
    }
}
