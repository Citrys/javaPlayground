package com.citrys.app.SortingAlgos;

class SolutionBin {
    public int solution(int N) {
        StringBuilder result = new StringBuilder();
        for (int i = N; i >= 0; i--) {
            int mask = 1 << i;
            result.append((N & mask) != 0 ? "1" : "0");
        }

        int maxGap = 0;
        int j = 0;
        while (j <= result.length()) {
            if (result.charAt(j) == '0') {
                int i = j;
                int maxTempCount = 0;
                while (i <= result.length() && result.charAt(i) == '0') {
                    maxTempCount += 1;
                    i ++;
                }
                if (j == result.length()) {
                    maxTempCount = 0;
                }
                maxGap = Math.max(maxGap, maxTempCount);
                j = i;
            }
        }
        return maxGap;
    }
}

class SolutiontestBinary {
    public static void main(String[] args) {
        int ch = 42;
        SolutionBin n = new SolutionBin();
        n.solution(42);
    }
}