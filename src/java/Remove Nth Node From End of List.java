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
    /**
    1.traverse the list and take the length of the list:
       if the element from last is k, then from the fist it will be 
       n-k shoud be pointed to next pointer of the next
       if we are dealing with head if we want to remove the head then the difference is 0 ()p)

       Time : O(n)
       Space : O(1)
    
     */
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode t=head;
        int l=0; 

        while(t!=null) {l++; t=t.next;} 
       
        int p=l-n; 

        t=head;
        for(int i=1;i<p;i++) t=t.next;
        
        if(t.next!=null && p!=0)  t.next=t.next.next;
        
        if(p==0) head= (head.next!=null) ? head.next : null;
        return head;
    }
    /**
    Two pointer method
    Time :O(n)
    Space :O(1)
     */
     public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummy=new ListNode();
            dummy.next=head;
            ListNode f=dummy,s=dummy;

            for(int i=0;i<=n;i++) f=f.next;
            while(f!=null) {
                f=f.next;
                s=s.next;
            }
            s.next=s.next.next;
            return dummy.next;

     }
 }


/**

19. Remove Nth Node From End of List
Solved
Medium
Topics
Companies
Hint
Given the head of a linked list, remove the nth node from the end of the list and return its head.

 

Example 1:


Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]
Example 2:

Input: head = [1], n = 1
Output: []
Example 3:

Input: head = [1,2], n = 1
Output: [1]
 

Constraints:

The number of nodes in the list is sz.
1 <= sz <= 30
0 <= Node.val <= 100
1 <= n <= sz
 

Follow up: Could you do this in one pass?
 */
