class Solution {
    public int maxProfit(int[] prices) {
        int low = prices[0], profit = 0;

        for (int price : prices) {
            low = Math.min(low, price);
            profit = Math.max(profit, price - low);
        }

        return profit;
    }
}
