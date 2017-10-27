class Solution {
    public int countNodes(TreeNode root) {
        int num = 0;
        int leftHeight = height(root) - 1;
        while (root != null) {
            int rightHeight = height(root.right);
            root = leftHeight == rightHeight ? root.right : root.left;
            num += (1 << rightHeight);
            leftHeight--;
        }
        return num;
    }

    private int height(TreeNode root) {
        if (root == null) return 0;
        int height = 1;
        while (root.left != null) {
            height++;
            root = root.left;
        }
        return height;
    }
}