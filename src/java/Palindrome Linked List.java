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
    Time : O(n)
    Space : O(1)
     */
    public boolean isPalindrome1(ListNode head) {
        Stack<ListNode> stack=new Stack<>();
        ListNode curr=head;
        while(curr!=null) {
            stack.push(curr);
            curr=curr.next;
        }

        curr=head;
        while(curr!=null){
            if(curr.val!=stack.pop().val) return false;
            curr=curr.next;
        }
        return true;
    }

    /**
    Time :O(n)
    Space : O(1)
     */
    public boolean isPalindrome(ListNode head) {
        ListNode f=head.next,s=head,prev=null,next=null,curr=null,shead,sh,fh;
        
        /*divide the list into two halfs */
        while(f!=null && f.next!=null){
               f=f.next.next;
               s=s.next;
          }
          shead=s.next;
          s.next=null;

        /**Reverse the second half of list */
        curr=shead;
          while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            if(next==null) shead=curr;
            curr=next;
          }


        /** check weather both are same */
        sh=shead;
        fh=head;
        while(sh!=null && fh!=null){
             if(sh.val!=fh.val) return false;
             sh=sh.next;
             fh=fh.next;
          }
        return true;
        }
}

/**
234. Palindrome Linked List
Solved
Easy
Topics
Companies
Given the head of a singly linked list, return true if it is a 
palindrome
 or false otherwise.

 

Example 1:


Input: head = [1,2,2,1]
Output: true
Example 2:


Input: head = [1,2]
Output: false
 

Constraints:

The number of nodes in the list is in the range [1, 105].
0 <= Node.val <= 9
 

Follow up: Could you do it in O(n) time and O(1) space?
 */
