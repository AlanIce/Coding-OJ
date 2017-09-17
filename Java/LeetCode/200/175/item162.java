class Solution {
    public int findPeakElement(int[] nums) {
        int N = nums.length;
        int lo = 0, hi = N - 1;
        while (hi - lo > 1) {
            int mid = (hi + lo) / 2;
            if (nums[mid] < nums[mid + 1]) 
                lo = mid + 1;
            else 
                hi = mid;
        }
        return (lo == N - 1 || nums[lo] > nums[hi]) ? lo : hi;
    }
}