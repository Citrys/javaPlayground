package com.citrys.app.facebook;



public class KClosestPointsToTheOrigin {
    public int[][] kClosest(int[][] points, int k) {
        int pointsLength = points.length;
        int[] distance = new int[pointsLength];
        return new int[][]{{1,0}};
    }

    private int getDistance(int[] point) {
        return point[0] * point[0] + point[1]*point[1];
    }
}
