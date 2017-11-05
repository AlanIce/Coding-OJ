class Solution {
    public void moveZeroes(int[] nums) {
        int i = -1, j = -1, l = nums.length;
        while (++i < l) if (nums[i] != 0) nums[++j] = nums[i];
        while (++j < l) nums[j] = 0;
    }
}