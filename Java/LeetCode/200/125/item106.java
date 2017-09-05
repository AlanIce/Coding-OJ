class Solution {
    private Map<Integer, Integer> inMap;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        inMap = new HashMap<Integer, Integer>();
        for(int i = 0; i < inorder.length; i++) inMap.put(inorder[i], i);
        return buildTree(inorder, 0, postorder, 0, inorder.length);
    }

    private TreeNode buildTree(int[] inorder, int lo_in, int[] postorder, int lo_post, int length) {
        if (length <= 0) return null;
        int rootVal = postorder[lo_post + length - 1];
        TreeNode root = new TreeNode(rootVal);
        int border = inMap.get(rootVal);
        int lengthLeft = border - lo_in;
        int lengthRight = lo_in + length - border - 1;
        root.left  = buildTree(inorder, lo_in, postorder, lo_post, lengthLeft);
        root.right = buildTree(inorder, border + 1, postorder, lo_post + lengthLeft, lengthRight);
        return root;
    }
}