class Solution {
    public int rob(int[] nums) {
        int a = 0, b = 0, t;
        for (int n : nums) {
            t = Math.max(n + b, a);
            b = a;
            a = t;
        }
        return a;
    }
}