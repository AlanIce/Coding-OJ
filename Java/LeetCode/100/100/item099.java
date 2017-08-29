class Solution {
    TreeNode firstElement = null, secondElement = null;
    TreeNode prevElement = new TreeNode(Integer.MIN_VALUE);

    public void recoverTree(TreeNode root) {
        traverse(root);
        int t = firstElement.val;
        firstElement.val = secondElement.val;
        secondElement.val = t;
    }

    private void traverse(TreeNode root) {
        if (root == null) return;
        traverse(root.left);
        if (root.val < prevElement.val) {
            if (firstElement == null) firstElement = prevElement;
            if (firstElement != null) secondElement = root;
        }
        prevElement = root;
        traverse(root.right);
    }
}