class Solution {
    private Map<Integer, Integer> inMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inMap = new HashMap<Integer, Integer>();
        for(int i = 0; i < inorder.length; i++) inMap.put(inorder[i], i);
        return buildTree(preorder, 0, inorder, 0, inorder.length);
    }

    private TreeNode buildTree(int[] preorder, int lo_pre, int[] inorder, int lo_in, int length) {
        if (length <= 0) return null;
        int rootVal = preorder[lo_pre];
        TreeNode root = new TreeNode(rootVal);
        int border = inMap.get(rootVal);
        int lengthLeft = border - lo_in;
        int lengthRight = lo_in + length - border - 1;
        root.left  = buildTree(preorder, lo_pre + 1, inorder, lo_in, lengthLeft);
        root.right = buildTree(preorder, lo_pre + 1 + lengthLeft, inorder, border + 1, lengthRight);
        return root;
    }
}