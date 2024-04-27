/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 148. Sort List
Medium
9.9K
292
Companies

Given the head of a linked list, return the list after sorting it in ascending order.

 

Example 1:

Input: head = [4,2,1,3]
Output: [1,2,3,4]

Example 2:

Input: head = [-1,5,3,4,0]
Output: [-1,0,3,4,5]

Example 3:

Input: head = []
Output: []

 */
class Solution {
    public ListNode sortList(ListNode head) {
        List<Integer> lis=new ArrayList<>();
        ListNode curr=head;
        while(curr!=null){ lis.add(curr.val); curr=curr.next;}
        Collections.sort(lis);
       
        curr=head;
        int i=0;
        while(curr!=null){ curr.val=lis.get(i); curr=curr.next; i++;}
        return head;
    }
}
