public class Solution {
    public void connect(TreeLinkNode root) {
        while (root != null) {
            TreeLinkNode tmp = new TreeLinkNode(0), cur = tmp;
            while (root != null) {
                if (root.left != null) { cur.next = root.left; cur = root.left; }
                if (root.right != null) { cur.next = root.right; cur = root.right; }
                root = root.next;
            }
            root = tmp.next;
        }
    }
}