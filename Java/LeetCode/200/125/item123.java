class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit1 = 0, maxProfit2 = 0, lowPrice1 = Integer.MAX_VALUE, lowPrice2 = Integer.MAX_VALUE;
        for (int price : prices) {
            maxProfit2 = Math.max(maxProfit2, price - lowPrice2);
            lowPrice2  = Math.min(lowPrice2, price - maxProfit1);
            maxProfit1 = Math.max(maxProfit1, price - lowPrice1);
            lowPrice1  = Math.min(lowPrice1, price);
        }
        return maxProfit2;
    }
}