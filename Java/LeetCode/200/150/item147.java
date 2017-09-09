class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pHead = new ListNode(0);
        pHead.next = head;
        ListNode now = head.next;
        head.next = null;
        while (now != null) {
            ListNode next = now.next;
            ListNode pre = pHead, cur = pre.next;
            while (cur != null && cur.val < now.val) {
                pre = pre.next;
                cur = cur.next;
            }
            now.next = cur;
            pre.next = now;
            now = next;
        }
        return pHead.next;
    }
}