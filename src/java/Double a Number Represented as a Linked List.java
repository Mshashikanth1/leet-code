/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 *
 
 2816. Double a Number Represented as a Linked List
Solved
Medium
Topics
Companies
Hint
You are given the head of a non-empty linked list representing a non-negative integer without leading zeroes.

Return the head of the linked list after doubling it.

 

Example 1:


Input: head = [1,8,9]
Output: [3,7,8]
Explanation: The figure above corresponds to the given linked list which represents the number 189. Hence, the returned linked list represents the number 189 * 2 = 378.
Example 2:


Input: head = [9,9,9]
Output: [1,9,9,8]
Explanation: The figure above corresponds to the given linked list which represents the number 999. Hence, the returned linked list reprersents the number 999 * 2 = 1998. 
 

Constraints:

The number of nodes in the list is in the range [1, 104]
0 <= Node.val <= 9
The input is generated such that the list represents a number that does not have leading zeros, except the number 0 itself.
 /
class Solution {

    /**Time : O(n) Space: O(n) */
    public ListNode doubleIt1(ListNode head) {
        int carry=0;

        Stack<ListNode> stack= new Stack<>();
        ListNode curr=head;
        while(curr!=null){
            stack.push(curr);
            curr=curr.next;
        }

        while(!stack.isEmpty()){
            ListNode dig=stack.pop();
            int  mul=(dig.val*2 +carry), num= mul%10;
            carry=mul/10;
            dig.val=num;
        }

        if(carry!=0){
            ListNode carryNode=new ListNode(carry);
            carryNode.next=head;
            head=carryNode;
        }
        return head;
    }
    
    public ListNode doubleIt(ListNode head) {
            return dfs(head,0);
    }
        public ListNode doubleIt(ListNode head, int carry){
            if(head.next!=null){
                return doubleIt(head.next,carry);
            }


        }
}
