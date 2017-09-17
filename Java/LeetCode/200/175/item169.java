class Solution {
    public int majorityElement(int[] nums) {
        return majorityElement(nums, 0);
    }

    private int majorityElement(int[] nums, int index) {
        int count = 1;
        for (int i = index + 1; i < nums.length; i++) {
            count += nums[i] == nums[index] ? 1 : -1;
            if (count <= 0) return majorityElement(nums, i + 1);
        }
        return nums[index];
    }
}