/**
83. Remove Duplicates from Sorted List.java
problem : https://leetcode.com/problems/remove-duplicates-from-sorted-list/
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
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null) return head;
        ListNode p=head;
        ListNode n=head.next;
        while(n!=null){
           if(p.val==n.val){
              n=n.next;
           }
           else{
               p.next=n;
               p=n;
               n=n.next;
           }
          
                   }
        p.next=n;
        p=n;
        return head;
    }
}
