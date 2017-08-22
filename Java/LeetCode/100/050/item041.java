class Solution {
    public int firstMissingPositive(int[] nums) {
        if (nums.length == 0) return 1;
        for (int i = 0; i < nums.length; ) {
            if (nums[i] == i + 1 || nums[i] <= 0 || nums[i] > nums.length || nums[i] == nums[nums[i] - 1]) i++;
            else swap(nums, i, nums[i] - 1);
        }
        int i = 0;
        while (i < nums.length && nums[i] == i + 1) i++;
        return i + 1;
    }

    private final void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}