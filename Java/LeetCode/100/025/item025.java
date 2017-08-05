public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k < 2) return  head;
        ListNode node = head;
        for (int i = 0; i < k; i++)
            if (node == null) return head;
            else node = node.next;
        node = reverseKGroup(node, k);
        for (int i = 0; i < k; i++) {
            ListNode tmp = head.next;
            head.next = node;
            node = head;
            head = tmp;
        }
        return node;
    }
}