class BSTIterator {

    private Stack<TreeNode> st;

    public BSTIterator(TreeNode root) {
        st = new Stack<>();
        keepIterator(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !st.empty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = st.pop();
        keepIterator(node.right);
        return node.val;
    }

    private void keepIterator(TreeNode root) {
        while (root != null) {
            st.push(root);
            root = root.left;
        }
    }
}