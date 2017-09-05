class Solution {
    public List<Integer> getRow(int rowIndex) {
        int[] nums = new int[rowIndex + 1];
        nums[0] = 1;
        for (int i = 0; i <= rowIndex; i++)
            for (int j = i; j > 0; j--)
                nums[j] += nums[j - 1];
        List<Integer> result = new ArrayList<Integer>();
        for (int i : nums) result.add(i);
        return result;
    }
}