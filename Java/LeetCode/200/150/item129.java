class Solution {
    private int sum = 0;

    public int sumNumbers(TreeNode root) {
        if (root != null) sumNumbers(root, 0);
        return sum;
    }
    
    private void sumNumbers(TreeNode root, int temp) {
        temp = temp * 10 + root.val;
        if (root.left == null && root.right == null) sum += temp;
        if (root.left != null) sumNumbers(root.left, temp);
        if (root.right != null) sumNumbers(root.right, temp);
    }
}