class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int max = 1, min = 1, result = nums[0];
        for (int num : nums) {
            int temp = max;
            max = Math.max(Math.max(temp * num, min * num), num);
            min = Math.min(Math.min(temp * num, min * num), num);
            result = Math.max(result, max);
        }
        return result;
    }
}