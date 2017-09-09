class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            if (node == null) node = stack.poll().left;
            else {
                stack.addFirst(node);
                result.add(node.val);
                node = node.right;
            }
        }
        Collections.reverse(result);
        return result;
    }
}