class Solution {
    public int maxCoins(int[] iNums) {
        int[] nums = new int[iNums.length + 2];
        int n = 1;
        for (int x : iNums) if (x > 0) nums[n++] = x;
        nums[0] = nums[n++] = 1;
        int[][] mem = new int[n][n];
        return burst(mem, nums, 0, n - 1);
    }

    public int burst(int[][] mem, int[] nums, int left, int right) {
        if (left + 1 == right) return 0;
        if (mem[left][right] > 0) return mem[left][right];
        int ans = 0;
        for (int i = left + 1; i < right; ++i)
            ans = Math.max(ans, nums[left] * nums[i] * nums[right]
                    + burst(mem, nums, left, i) + burst(mem, nums, i, right));
        mem[left][right] = ans;
        return ans;
    }
}