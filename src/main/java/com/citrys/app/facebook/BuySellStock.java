package com.citrys.app.facebook;

public class BuySellStock {

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minProfit = Integer.MAX_VALUE;
        for (int price : prices) {
            if (price < minProfit) {
                minProfit = price;
            }

            if (price - minProfit > maxProfit) {
                maxProfit = price - minProfit;
            }
        }
        return maxProfit;
    }
}
