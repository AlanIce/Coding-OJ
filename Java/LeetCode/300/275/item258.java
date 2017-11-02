class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root != null)
            binaryTreePaths(root, "" + root.val, result);
        return result;
    }

    private void binaryTreePaths(TreeNode root, String curr, List<String> result) {
        if (root.left == null && root.right == null) {
            result.add(curr);
            return;
        }
        if (root.left  != null) binaryTreePaths(root.left,  curr + "->" + root.left.val,  result);
        if (root.right != null) binaryTreePaths(root.right, curr + "->" + root.right.val, result);
    }
}