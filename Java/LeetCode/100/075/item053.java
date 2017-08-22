class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE, temp = Integer.MIN_VALUE;
        for (int num : nums) {
            if (temp > 0) temp += num;
            else temp = num;
            if (temp > max) max = temp;
        }
        return max;
    }
}
