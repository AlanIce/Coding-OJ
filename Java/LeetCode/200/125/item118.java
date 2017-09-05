class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> row = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            row.add(1);
            for (int j = 1; j < i; j++)
                row.set(j, result.get(i - 1).get(j) + result.get(i - 1).get(j - 1));
            result.add(new ArrayList<>(row));
        }
        return result;
    }
}