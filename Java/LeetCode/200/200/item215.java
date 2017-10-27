class Solution {
    public int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums, 0, nums.length - 1, nums.length - k);
    }

    private int findKthLargest(int[] nums, int lo, int hi, int k) {
        int base = nums[lo];
        int i = lo, j = lo;
        while (++j <= hi)
            if (nums[j] <= base) {
                int t = nums[j];
                nums[j] = nums[++i];
                nums[i] = t;
            }
        nums[lo] = nums[i];
        nums[i] = base;
        if (i < k) return findKthLargest(nums, i + 1, hi, k);
        if (i > k) return findKthLargest(nums, lo, i - 1, k);
        return base;
    }
}