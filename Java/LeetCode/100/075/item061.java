class Solution {
    public ListNode rotateRight(ListNode head, int n) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy, slow = dummy;

        int len;
        for (len = 0; fast.next != null; len++) fast = fast.next;

        for (int j = len - n % len; j > 0; j--) slow = slow.next;

        fast.next=dummy.next;
        dummy.next=slow.next;
        slow.next=null;

        return dummy.next;
    }
}