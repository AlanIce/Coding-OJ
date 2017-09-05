class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        pathSum(root, sum, new LinkedList<>(), result);
        return result;
    }

    public void pathSum(TreeNode root, int sum, List<Integer> temp, List<List<Integer>> result) {
        if (root == null) return;
        temp.add(root.val);
        if (sum == root.val && root.left == null && root.right == null) 
            result.add(new ArrayList<>(temp));
        else {
            pathSum(root.left, sum - root.val, temp, result);
            pathSum(root.right, sum - root.val, temp, result);
        }
        temp.remove(temp.size() - 1);
    }
}