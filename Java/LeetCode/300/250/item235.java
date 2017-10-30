class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val < q.val) return lowestCommonAncestorCore(root, p.val, q.val);
        return lowestCommonAncestorCore(root, q.val, p.val);
    }

    private TreeNode lowestCommonAncestorCore(TreeNode root, int p, int q) {
        if (root.val < p) return lowestCommonAncestorCore(root.right, p, q);
        if (root.val > q) return lowestCommonAncestorCore(root.left, p, q);
        return root;
    }
}