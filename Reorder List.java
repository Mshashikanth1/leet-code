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
    public void reorderList(ListNode head) {
        ListNode f=head.next,s=head, sh=null,c=null,p=null,next=null,fn=null,sn=null;

        /**divide the list into two halfs */
        while(f!=null && f.next!=null){
            s=s.next;
            f=f.next.next;
        }
        sh=s.next;
        s.next=null;


        /**reverse the second half*/
        c=sh;
        p=null;
        while(c!=null){
              next=c.next;
              c.next=p;
              p=c;
              if(next==null) sh=c;
              c=next;
        }


        /**now construct the final linked list by choosing elements from both alternatively  */
        f=head;
        s=sh;
        while(f!=null && s!=null){
            fn=f.next;
            f.next=s;
            f=fn;

            sn=s.next;
            s.next=f;
            s=sn;
        }

    }

  
}

/**
  4,3,2,1

  1,2
  
  4,3
 
  1 ---> 2   
         4 ---->3

   1-->4 --->2      

  
    public void print(ListNode h){
        ListNode c=h;
        while(c!=null) {
            System.out.print(c.val +" , ");
            c=c.next; 
        }
        System.out.println( " \n ------- \n ");
    }
  1 ,5 ,2 

  143. Reorder List
Solved
Medium
Topics
Companies
You are given the head of a singly linked-list. The list can be represented as:

L0 → L1 → … → Ln - 1 → Ln
Reorder the list to be on the following form:

L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
You may not modify the values in the list's nodes. Only nodes themselves may be changed.

 

Example 1:


Input: head = [1,2,3,4]
Output: [1,4,2,3]
Example 2:


Input: head = [1,2,3,4,5]
Output: [1,5,2,4,3]
 

Constraints:

The number of nodes in the list is in the range [1, 5 * 104].
1 <= Node.val <= 1000
Seen this question in a real interview before?
1/4
Yes
No
Accepted
892K
Submissions
1.6M
Acceptance Rate
57.1%
Topics
Linked List
Two Pointers
Stack
Recursion
Companies
Similar Questions
Discussion (98)

 */

