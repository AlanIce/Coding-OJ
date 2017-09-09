class Solution {
    public int singleNumber(int[] nums) {
        int x = 0, y = 0;
        for (int num : nums) {
            x = (x ^ num) & ~y;
            y = (y ^ num) & ~x;
        }
        return x;
    }
}