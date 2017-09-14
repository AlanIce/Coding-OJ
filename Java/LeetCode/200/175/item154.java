class Solution {
    public int findMin(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            if (nums[lo] < nums[hi]) return nums[lo];
            int mid = (lo + hi) / 2;
            if (nums[mid] > nums[lo]) lo = mid + 1;
            else if (nums[mid] > nums[lo]) hi = mid;
            else lo++;
        }
        return nums[lo];
    }
}