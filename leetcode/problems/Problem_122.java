package problems;

/**
 *  (Best Time to Buy and Sell Stock II)[https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/]
 *
 *  Say you have an array prices for which the ith element is the price of a given stock on day i.
 *
 *  Design an algorithm to find the maximum profit. You may complete as many transactions as you like
 *  (i.e., buy one and sell one share of the stock multiple times).
 *
 */
public class Problem_122 {
    public static void main(String[] args) {
        int[] arr1 = new int[]{7,1,5,3,6,4}; // 7
        int[] arr2 = new int[]{1,2,3,4,5}; // 4
        int[] arr3 = new int[]{7,6,4,3,1}; // 0
        int[] arr4 = new int[]{6,1,1,2,7}; // 6

        System.out.println(maxProfit(arr1));
        System.out.println(maxProfit(arr2));
        System.out.println(maxProfit(arr3));
        System.out.println(maxProfit(arr4));
    }

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;

        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            profit += Math.max(0, prices[i] - prices[i - 1]);
        }

        return profit;
    }
}
