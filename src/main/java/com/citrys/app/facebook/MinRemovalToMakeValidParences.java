package com.citrys.app.facebook;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class MinRemovalToMakeValidParences {

    class Solution {
        public String minRemoveToMakeValid(String s) {
            Set<Integer> faultyIndicies = new HashSet<>();
            Stack<Integer> trackStack = new Stack<>();
            StringBuilder ans = new StringBuilder();

            for (int i = 0; i < s.length(); i ++) {
                if (s.charAt(i) == '(') {
                    trackStack.push(i);
                }
                if (s.charAt(i) == ')') {
                    if (trackStack.isEmpty()) {
                        faultyIndicies.add(i);
                    } else {
                        trackStack.pop();
                    }
                }
            }
            while (!trackStack.isEmpty()) faultyIndicies.add(trackStack.pop());
            for (int i = 0; i < s.length(); i ++) {
                if (!faultyIndicies.contains(i)) {
                    ans.append(s.charAt(i));
                }
            }
            return ans.toString();

        }
    }
}

