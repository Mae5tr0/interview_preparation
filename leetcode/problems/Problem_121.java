package problems;

/**
 * (Best Time to Buy and Sell Stock)[https://leetcode.com/problems/best-time-to-buy-and-sell-stock/]
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock),
 * design an algorithm to find the maximum profit.
 *
 * Note that you cannot sell a stock before you buy one.
 *
 */
public class Problem_121 {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4})); // 5
        System.out.println(maxProfit(new int[]{7,6,4,3,1})); // 0
        System.out.println(maxProfit(new int[]{7,2,6,5,1,3,2})); // 4
        System.out.println(maxProfit(new int[]{})); // 0
    }

//    static public int maxProfit(int[] prices) {
//        if (prices == null || prices.length < 2) return 0;
//
//        return maxProfit(prices, 0, prices.length - 1);
//    }
//
//    static public int maxProfit(int[] prices, int min, int max) {
//        if (min == max) return 0;
//
//        int mid = (max + min)/2;
//
//        return Math.max(Math.max(
//            maxProfit(prices, min, mid),
//            maxProfit(prices, mid + 1, max)
//        ),
//            maxCrossingProfit(prices, min, max, mid)
//        );
//    }
//
//    static public int maxCrossingProfit(int[] prices, int min, int max, int mid) {
//        int minPrice = Integer.MAX_VALUE;
//        for (int i = min; i <= mid; i++) {
//            if (prices[i] < minPrice) minPrice = prices[i];
//        }
//
//        int maxPrice = Integer.MIN_VALUE;
//        for (int i = mid + 1; i <= max; i++) {
//            if (prices[i] > maxPrice) maxPrice = prices[i];
//        }
//
//        return Math.max(maxPrice - minPrice, 0);
//    }

    static public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int minPrice = prices[0];
        int maxProfit = 0;

        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }

        return maxProfit;
    }
}
