class Solution {
    public int kthSmallest(TreeNode root, int k) {
        int count = getNodeCounts(root.left);
        if (count + 1 < k) return kthSmallest(root.right, k - count - 1);
        if (count + 1 > k) return kthSmallest(root.left, k);
        return root.val;
    }
    
    private int getNodeCounts(TreeNode root) {
        if (root == null) return 0;
        return getNodeCounts(root.left) + getNodeCounts(root.right) + 1;
    }
}