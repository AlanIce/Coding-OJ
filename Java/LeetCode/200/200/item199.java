class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        rightView(root, 0, result);
        return result;
    }

    private void rightView(TreeNode curr, int currDepth, List<Integer> result){
        if (curr == null) return;
        if (currDepth == result.size()) result.add(curr.val);
        rightView(curr.right, currDepth + 1, result);
        rightView(curr.left,  currDepth + 1, result);

    }
}