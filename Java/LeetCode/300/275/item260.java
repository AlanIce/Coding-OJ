class Solution {
    public int[] singleNumber(int[] nums) {
        int mid = 0;
        for (int num : nums) mid ^= num;
        int base = 1;
        while ((base & mid) == 0) base <<= 1;
        int a = 0, b = 0;
        for (int num : nums)
            if ((base & num) == 0) a ^= num;
            else b ^= num;
        return new int[]{a, b};
    }
}