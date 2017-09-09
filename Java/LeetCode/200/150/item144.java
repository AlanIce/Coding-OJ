class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        if (root != null) stack.addFirst(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.poll();
            result.add(node.val);
            if (node.right != null) stack.addFirst(node.right);
            if (node.left != null) stack.addFirst(node.left);
        }

        return result;
    }
}