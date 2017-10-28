class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;
        int length = nums.length;
        int index = -1, lo, hi;
        while (++index < length) {
            lo = nums[index];
            while (index < length - 1 && nums[index] + 1 == nums[index + 1])
                index++;
            hi = nums[index];
            if (lo == hi) result.add(String.valueOf(lo));
            else result.add(lo + "->" + hi);
        }
        return result;
    }
}