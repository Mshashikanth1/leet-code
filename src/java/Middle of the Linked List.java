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
       use a list to store the nodes and check the size and get the middle
       Time : O(n) : 0ms 100.00%
       Space :O(n) : 41.17 mb, 34.31%
    */
    public ListNode middleNode(ListNode head) {
           List<ListNode> lis=new ArrayList<>();
           ListNode curr=head;
           while(curr!=null){
               lis.add(curr);
               curr=curr.next;
           }
           return lis.get(lis.size()/2);
    }
   /**
    we can optimize this by two pass , one pass for the  counting  of numbers
    and other pass to identify the middle element;
    Time : O(n). :  0ms beats 100% 
    Space : O(1)  : 40.72MB 85.43%
    */
   public ListNode middleNode1(ListNode head) {
            ListNode curr=head;
            int len=0;
            while(curr!=null) { len++; curr=curr.next;}
            int i=0,mid=len/2;

            curr=head;
            while(curr!=null){
                if(i==mid) return curr;
                curr=curr.next;
                i++;
            }
            return null;
        }
}

/**
876. Middle of the Linked List
Solved
Easy
Topics
Companies
Given the head of a singly linked list, return the middle node of the linked list.

If there are two middle nodes, return the second middle node.

 

Example 1:


Input: head = [1,2,3,4,5]
Output: [3,4,5]
Explanation: The middle node of the list is node 3.
Example 2:


Input: head = [1,2,3,4,5,6]
Output: [4,5,6]
Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.
 

Constraints:

The number of nodes in the list is in the range [1, 100].
1 <= Node.val <= 100

 */
