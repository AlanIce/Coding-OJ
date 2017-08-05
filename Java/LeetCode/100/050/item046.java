public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        permuteCore(nums, result, 0);
        return result;
    }

    private void permuteCore(int nums[], List<List<Integer>> result, int index) {
        if (index == nums.length) {
            List<Integer> list = new ArrayList<>(nums.length);
            for (int n : nums) list.add(n);
            result.add(list);
            return;
        }
        for (int i = index; i < nums.length; i++) {
            swap(nums, index, i);
            permuteCore(nums, result, index + 1);
            swap(nums, index, i);
        }
    }

    private void swap(int nums[], int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}