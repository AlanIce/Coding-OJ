class Solution {
    private List<List<Integer>> result = new LinkedList<>();

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            threeSum(nums, target - nums[i], i + 1, nums[i]);
        }
        return result;
    }

    private void threeSum(int[] nums, int target, int lo, int num1) {
        for (int i = lo; i < nums.length - 2; i++) {
            if (i > lo && nums[i] == nums[i - 1]) continue;
            twoSum(nums, target - nums[i], i + 1, num1, nums[i]);
        }
    }

    private void twoSum(int[] nums, int target, int lo, int num1, int num2) {
        int hi = nums.length - 1;
        while (lo < hi) {
            int cmp = nums[lo] + nums[hi] - target;
            if (cmp > 0) hi--;
            else if (cmp < 0) lo++;
            else {
                result.add(Arrays.asList(num1, num2, nums[lo], nums[hi]));
                while (lo < hi && nums[lo + 1] == nums[lo]) lo++;
                while (lo < hi && nums[hi - 1] == nums[hi]) hi--;
                lo++; hi--;
            }
        }
    }
}