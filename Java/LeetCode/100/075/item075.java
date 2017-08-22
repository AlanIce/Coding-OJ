class Solution {
    public void sortColors(int[] nums) {
        int i = 0, lt = 0, gt = nums.length - 1;
        while (i <= gt) {
            if (nums[i] == 0) swap(nums, i++, lt++);
            else if (nums[i] == 1) i++;
            else if (nums[i] == 2) swap(nums, i, gt--);
        }
    }

    private void swap(int[] nums, int a, int b) {
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }
}