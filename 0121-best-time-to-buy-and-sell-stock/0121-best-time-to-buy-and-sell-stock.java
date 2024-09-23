class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        if (prices == null || n == 0){
            return 0;
        }

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;


        for (int i = 0; i < n; i++) {
           
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }

            int profit = prices[i] - minPrice;


            if (profit > maxProfit) {
                maxProfit = profit;
            }
        }
        return maxProfit;
    }
}
