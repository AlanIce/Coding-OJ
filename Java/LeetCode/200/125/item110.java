class Solution {
    public boolean isBalanced(TreeNode root) {
        return dfsHeight(root) != -1;
    }

    private int dfsHeight(TreeNode root) {
        if (root == null) return 0;
        int maxLeftHeight = dfsHeight(root.left);
        int maxRightHeight = dfsHeight(root.right);
        if (maxLeftHeight == -1 || maxRightHeight == -1 || Math.abs(maxLeftHeight - maxLeftHeight) > 1) return -1;
        return Math.max(maxLeftHeight, maxLeftHeight) + 1;
    }
}