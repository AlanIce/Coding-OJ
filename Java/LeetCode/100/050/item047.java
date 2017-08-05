public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();
        permuteCore(nums.clone(), result, 0);
        return result;
    }

    private void permuteCore(int nums[], List<List<Integer>> result, int index) {
        if (index == nums.length - 1) {
            List<Integer> list = new ArrayList<>(nums.length);
            for (int n : nums) list.add(n);
            result.add(list);
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if (i != index && nums[i] == nums[index]) continue;
            swap(nums, index, i);
            permuteCore(nums.clone(), result, index + 1);
        }
    }

    private void swap(int nums[], int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}