class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<>();
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int lo, int hi) {
        List<TreeNode> result = new ArrayList<>();
        if (lo > hi) {
            result.add(null);
            return result;
        }
        for (int i = lo; i <= hi; i++) {
            List<TreeNode> leftList = generateTrees(lo, i - 1);
            List<TreeNode> rightList = generateTrees(i + 1, hi);
            for (TreeNode leftNode : leftList)
                for (TreeNode rightNode : rightList) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftNode;
                    root.right = rightNode;
                    result.add(root);
                }
        }
        return result;
    }
}