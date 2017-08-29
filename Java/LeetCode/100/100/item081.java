class Solution {
    public boolean search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            int num = nums[mid];
            if (num == target) return true;
            // If nums[mid] and target are "on the same side" of nums[0], we just take nums[mid].
            if (num == nums[lo]) { lo++; continue; }
            if ((num < nums[lo]) != (target < nums[lo]))
                num = target < nums[0] ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            if (num < target) lo = mid + 1;
            else if (num > target) hi = mid - 1;
        }
        return false;
    }
}