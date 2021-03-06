class Solution {
    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            int num = nums[mid];
            if ((num < nums[lo]) != (target < nums[lo])) 
                num = target < nums[0] ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            if (num < target) lo = mid + 1;
            else if (num > target) hi = mid - 1;
            else return mid;
        }
        return -1;
    }
}