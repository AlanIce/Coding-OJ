class Solution {
    private int min = Integer.MAX_VALUE;
    
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;
        Arrays.sort(coins);
        coinChange(coins, amount, coins.length - 1, 0);
        if (min == Integer.MAX_VALUE) return -1;
        return min;
    }

    public void coinChange(int[] coins, int amount, int index, int num){
        if (amount % coins[index] == 0){
            int newCount = num + amount/coins[index];
            if(newCount < min) min = newCount;
        }
        if (index == 0) return;
        int possible = amount / coins[index];
        for (int i = possible; i >= 0; i--){
            int newAmount = amount - coins[index] * i;
            int newNum = num + i;
            int nextCoin = coins[index - 1];
            if (newNum + (newAmount + nextCoin - 1) / nextCoin >= min) break;
            coinChange(coins, newAmount, index - 1, newNum);
        }
    }
}