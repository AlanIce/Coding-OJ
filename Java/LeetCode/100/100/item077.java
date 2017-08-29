class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new LinkedList<>();
        combine(n, k, 1, 1, new ArrayList<>(), result);
        return result;
    }

    private void combine(int n, int k, int index, int depth, List<Integer> temp, List<List<Integer>> result) {
        for (int i = index; i <= n - k + depth; i++) {
            List<Integer> t = new ArrayList<>(temp);
            t.add(i);
            if (depth == k) result.add(t);
            else combine(n, k, i + 1, depth + 1, t, result);
        }
    }
}