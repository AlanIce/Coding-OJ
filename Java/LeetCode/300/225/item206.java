class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode h = new ListNode(0);
        while (head != null) {
            ListNode next = head.next;
            head.next = h.next;
            h.next = head;
            head = next;
        }
        return h.next;        
    }
}