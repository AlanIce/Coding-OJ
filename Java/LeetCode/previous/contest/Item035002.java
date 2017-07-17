package priv.alanice.coding.leetcode.contest;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Item035002 {
    public String tree2str(TreeNode t) {
        if (t == null) return "";
        if (t.left == null && t.right == null)
            return Integer.toString(t.val);
        if (t.right == null)
            return Integer.toString(t.val) + "(" + tree2str(t.left) + ")";
        return Integer.toString(t.val) + "(" + tree2str(t.left) + ")(" + tree2str(t.right) + ")";
    }
}
