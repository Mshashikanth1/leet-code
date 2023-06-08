/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 1019. Next Greater Node In Linked List
Medium
2.9K
106
Companies

You are given the head of a linked list with n nodes.

For each node in the list, find the value of the next greater node. That is, for each node, find the value of the first node that is next to it and has a strictly larger value than it.

Return an integer array answer where answer[i] is the value of the next greater node of the ith node (1-indexed). If the ith node does not have a next greater node, set answer[i] = 0.

 

Example 1:

Input: head = [2,1,5]
Output: [5,5,0]

Example 2:

Input: head = [2,7,4,3,5]
Output: [7,0,5,5,0]

 

Constraints:

    The number of nodes in the list is n.
    1 <= n <= 104
    1 <= Node.val <= 109


 */
class Solution {
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> ans=new ArrayList<>();
        ListNode curr=head;
        while(curr!=null){
            int nextMaxForCurr=0;
            ListNode temp=curr;
            while(temp!=null){if(temp.val>curr.val) { nextMaxForCurr=temp.val; break;}temp=temp.next;}
            ans.add(nextMaxForCurr);
            curr=curr.next;
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
        
    }
}
