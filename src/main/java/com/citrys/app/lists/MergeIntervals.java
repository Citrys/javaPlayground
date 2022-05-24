package com.citrys.app.lists;

import java.lang.reflect.Array;
import java.util.*;

class Interval {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
};

class IntervalsIntersection {

    public static boolean canAttendAllAppointments(Interval[] intervals) {
        LinkedList<Interval> merged = new LinkedList<>();
        Arrays.sort(intervals, Comparator.comparingInt(a -> a.start));
        for (Interval interval: intervals) {
            if (merged.isEmpty() || merged.getLast().end < interval.start) {
                merged.add(interval);
            } else {
                merged.getLast().end = Math.max(merged.getLast().end, interval.end);
            }
        }
        return merged.size() == intervals.length;
    }
}
