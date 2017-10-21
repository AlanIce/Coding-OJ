class Solution {
    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) strs[i] = String.valueOf(nums[i]);
        Arrays.sort(strs, (a, b)-> (b + a).compareTo(a + b));
        String result = String.join("", strs);
        return result.charAt(0) == '0' ? "0" : result;
    }
}