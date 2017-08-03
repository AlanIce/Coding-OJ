public class Solution {
    public void nextPermutation(int[] nums) {
        int k = nums.length - 1;
        while (--k >= 0 && nums[k] >= nums[k + 1]) ;
        if (k == -1) {
            for (int i = 0; i < nums.length / 2; i++) {
                int t = nums[i];
                nums[i] = nums[nums.length - 1 - i];
                nums[nums.length - 1 - i] = t;
            }
            return;
        }
        for (int i = nums.length - 1; i > k; i--)
            if (nums[i] > nums[k]) {
                int t = nums[i];
                nums[i] = nums[k];
                nums[k] = t;
                break;
            }
        Arrays.sort(nums, k + 1, nums.length);
    }
}