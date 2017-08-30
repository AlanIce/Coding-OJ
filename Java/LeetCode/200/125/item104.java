class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int leftLength = maxDepth(root.left);
        int rightLength = maxDepth(root.right);
        return Math.max(leftLength, rightLength) + 1;
    }
}