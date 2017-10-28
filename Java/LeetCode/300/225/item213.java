class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        return Math.max(rob(nums, 0, nums.length - 1), rob(nums, 1, nums.length));
    }

    private int rob(int[] nums, int lo, int hi) {
        int a = 0, b = 0, t;
        for (int i = lo; i < hi; i++) {
            t = Math.max(nums[i] + b, a);
            b = a;
            a = t;
        }
        return a;
    }
}