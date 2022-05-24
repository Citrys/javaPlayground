package com.citrys.app.facebook;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Query {
    int type;
    int index;
    Query(int t, int i) {
        this.type = t;
        this.index = i;
    }
}

class Solution {
    public LinkedList<Integer> answerQueries(ArrayList<Query> queries, int N) {
        boolean[] arr = new boolean[N];

        LinkedList<Integer> ans = new LinkedList<>();
        for (Query q: queries) {
            if (q.type == 1) {
                arr[q.index] = true;
            } else if (q.type == 2) {
                if (ans.isEmpty()) {
                    ans.add(-1);
                } else {
                    ans.add(simpleSearch(arr, q.index));
                }
            }
        }
        return ans;
    }

    private int simpleSearch(boolean[] arr, int index) {
        for (int i = index; i < arr.length; i ++) {
            if (arr[i]) {
                return i;
            }
        }
        return -1;
    }
}