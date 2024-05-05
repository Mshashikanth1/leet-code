/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteMiddle(ListNode head) {
        ListNode fast=head, slow=head,slowPrev=head;

        while(fast!=null && fast.next!=null){
            fast=fast.next.next;

            slowPrev=slow;
            slow=slow.next;
        }

        if(slow==head) return null; 
        slowPrev.next=slow.next;

        return head;
    }
}