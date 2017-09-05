class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        return sortedListToBST(head, null);
    }

    public TreeNode sortedListToBST(ListNode head, ListNode tail) {
        if (head == tail) return null;
        ListNode slow = head,fast = head;
        while (fast != tail && fast.next != tail){
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode thead = new TreeNode(slow.val);
        thead.left = sortedListToBST(head, slow);
        thead.right = sortedListToBST(slow.next, tail);
        return thead;
    }
}