class Solution {
    public int removeElement(int[] nums, int val) {
        int lo = 0, hi = nums.length;
        while (lo < hi) {
            while (lo < hi && nums[lo] != val) lo++;
            nums[lo] = nums[--hi];
        }
        return hi;
    }
}