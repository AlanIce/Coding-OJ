public class Solution {
    public boolean canJump(int[] nums) {
        int count = 0, end = 0, fathest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (fathest < nums[i] + i) fathest = nums[i] + i;
            if (i == fathest && nums[i] == 0) return false;
        }
        return true;
    }
}