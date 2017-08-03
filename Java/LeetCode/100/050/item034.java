public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] >= target) hi = mid;
            else lo = mid + 1;
        }
        if (nums.length == 0 || nums[lo] != target) return new int[] {-1, -1};
        int a = lo;
        lo = 0; hi = nums.length - 1;
        while (lo < hi - 1) {
            int mid = (lo + hi) / 2;
            if (nums[mid] > target) hi = mid - 1;
            else lo = mid;
        }
        int b = nums[hi] == target ? hi : lo;
        return new int[] {a, b};
    }
}