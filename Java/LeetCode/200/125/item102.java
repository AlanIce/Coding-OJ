class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        int size = 1;
        while (!q.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < size; ++i) {
                TreeNode n = q.poll();
                tmp.add(n.val);
                if(n.left != null) q.add(n.left);
                if(n.right != null) q.add(n.right);
            }
            res.add(tmp);
            size = q.size();
        }
        return res;
    }
}