package com.citrys.app.classesstudy;

import java.util.AbstractMap;
import java.util.EnumMap;
import java.util.Set;

class Point {
    private final double x;
    private final double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    /**
     *
     *
     * @param sx
     * @param sy
     * @return
     */
    Point translate(double sx, double sy) {
        return new Point(this.x + sx, this.y + sy);
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    /**
     *
     * @param scale
     * @return
     */
    Point scale(double scale) {
        return new Point(this.x * scale, this.y * scale);
    }
}

enum MyVals {
    EVEV, MARI
}
class TestPoint {
    public static void main(String [] args) {
        Point newPoint = new Point(3,4).translate(1,3).scale(0.5);
        System.out.println(newPoint.getX() + " " + newPoint.getY());
    }
}