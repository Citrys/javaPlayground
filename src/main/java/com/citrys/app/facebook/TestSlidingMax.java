package com.citrys.app.facebook;

import java.util.*;

class TestSlidingMax{
    public static ArrayDeque<Integer> findMaxSlidingWindow(int[] arr, int windowSize) {
        ArrayDeque<Integer> result = new ArrayDeque<>();
        for (int i = 0; i < arr.length - windowSize + 1; ++ i) {
            LinkedList<Integer> internal = new LinkedList<>();
            for (int j = i; j <= i + windowSize - 1; j ++) {
                internal.add(arr[j]);
            }
            result.add(getMax(internal));
            internal.clear();
        }
        return result;
    }

    private static int getMax(LinkedList<Integer> internal) {
        int max = 0;
        for (int num: internal) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    static int binarySearchRotated(int[] arr,int key) {
        int rotationIndex = 0;
        for (int i = 0; i < arr.length - 1; i ++) {
            if (arr[i] > arr[i + 1]) {
                rotationIndex = i; break;
            }
        }

        int s1 = search(arr, key, 0, rotationIndex);
        int s2 = search(arr, key, rotationIndex, arr.length - 1);

        if (s1 > -1) return s1;
        else if (s2 > -1) return s2;
        else return -2;
    }

    private static int search(int[] arr, int key, int low, int high) {
        if (low > high) {
            return -1;
        }
        int mid = low + (high - low) / 2;
        if ((arr[mid]) == key) {
            return mid;
        }
        if (mid < key) {
            return search(arr, key, low, mid - 1);
        } else {
            return search(arr, key, mid + 1, high);
        }
    }

    public static void main(String[] args) {
        int[] test = {1, 2, 3, 4, 3, 2, 1, 2, 5};
        ArrayDeque<Integer> ans = findMaxSlidingWindow(test, 3);

        int[] rot = {4, 5, 6, 1, 2, 3};
        System.out.println(binarySearchRotated(rot, 3));
        ans.forEach(System.out::println);
    }
}

class Pair{
    public int first;
    public int second;

    public Pair(int x, int y){
        this.first = x;
        this.second = y;
    }
}

class ComparePairs implements Comparator<Pair> {
    @Override
    public int compare(Pair o1, Pair o2) {
        return Integer.compare(o1.first, o2.first);
    }
}

class MergeIntervals2{
    static ArrayList<Pair> mergeIntervals(ArrayList<Pair> v) {
        LinkedList<Pair> result = new LinkedList<>();
        v.sort(new ComparePairs());
        for (Pair p: v) {
            if (result.isEmpty() || p.first > result.getLast().second) {
                result.add(p);
            } else {
                result.getLast().second = Math.max(p.second, result.getLast().second);
            }
        }
        return new ArrayList<>(result);
    }
}
