public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int N = nums.length, result = Integer.MAX_VALUE;
        for (int i = 0; i < N - 2; i++) {
            int lo = i + 1, hi = N - 1, temp;
            while (lo < hi) {
                temp = nums[i] + nums[lo] + nums[hi] - target;
                if (temp > 0) hi--;
                else if (temp < 0) lo++;
                else return target;
                if (Math.abs(result) > Math.abs(temp)) result = temp;
            }
        }
        return result + target;
    }
}