class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        serialize(root, sb);
        sb.deleteCharAt(sb.length() - 1);
        sb.append(']');
        return sb.toString();
    }

    private void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("null");
            sb.append(',');
        } else {
            sb.append(root.val);
            sb.append(',');
            serialize(root.left, sb);
            serialize(root.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        data = data.substring(1, data.length() - 1);
        if (data.isEmpty()) return null;
        String[] nums = data.split(",");
        return deserialize(nums, new IntegerHolder());
    }

    private TreeNode deserialize(String[] nums, IntegerHolder integerHolder) {
        if (nums.length <= integerHolder.index) return null;
        if (nums[integerHolder.index].equals("null")) {
            integerHolder.index++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(nums[integerHolder.index++]));
        root.left = deserialize(nums, integerHolder);
        root.right = deserialize(nums, integerHolder);
        return root;
    }

    private static class IntegerHolder {
        int index = 0;
    }
}