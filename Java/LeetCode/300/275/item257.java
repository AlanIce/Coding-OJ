class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root != null) {
            if (root.left == null && root.right == null) 
                result.add("" + root.val);
            else {
                binaryTreePaths(root.left,  "" + root.val, result);
                binaryTreePaths(root.right, "" + root.val, result);
            }
        }
        return result;
    }

    private void binaryTreePaths(TreeNode root, String curr, List<String> result) {
        if (root == null) return;
        curr += "->" + root.val;
        if (root.left == null && root.right == null) {
            result.add(curr);
            return;
        }
        binaryTreePaths(root.left,  curr, result);
        binaryTreePaths(root.right, curr, result);
    }
}