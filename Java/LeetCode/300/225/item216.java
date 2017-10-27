class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        combinationSum3(k, n, 1, new boolean[10], new ArrayList<>(), result);
        return result;
    }

    private void combinationSum3(int k, int n, int index, boolean[] nums, List<Integer> temp, List<List<Integer>> result) {
        if (k == 1) {
            if (n > 0 && n < 10 && nums[n] == false) {
                temp.add(n);
                result.add(new ArrayList<>(temp));
                temp.remove(temp.size() - 1);
            }
        } else {
            for (int i = index; i < 10; i++) {
                if (nums[i] == false && n > k * i) {
                    temp.add(i);
                    nums[i] = true;
                    combinationSum3(k - 1, n - i, i + 1, nums, temp, result);
                    nums[i] = false;
                    temp.remove(temp.size() - 1);
                }
            }
        }
    }
}