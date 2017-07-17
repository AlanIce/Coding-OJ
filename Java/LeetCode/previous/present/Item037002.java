package priv.alanice.coding.leetcode.present;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Item037002 {
    public class Solution {
        public TreeNode addOneRow(TreeNode root, int v, int d) {
            if (d < 1) return null;
            if (d == 1) {
                TreeNode node = new TreeNode(v);
                node.left = root;
                return node;
            }
            if (d == 2) {
                if (root.left != null) {
                    TreeNode node = new TreeNode(v);
                    node.left = root.left;
                    root.left = node;
                }

                if (root.right != null) {
                    TreeNode node = new TreeNode(v);
                    node.right = root.right;
                    root.right = node;
                }
                return root;
            }
            root.left  = addOneRow(root.left,  v, d - 1);
            root.right = addOneRow(root.right, v, d - 1);
            return root;
        }
    }
}
