/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 2181. Merge Nodes in Between Zeros
Medium
1.3K
24
Companies

You are given the head of a linked list, which contains a series of integers separated by 0's. The beginning and end of the linked list will have Node.val == 0.

For every two consecutive 0's, merge all the nodes lying in between them into a single node whose value is the sum of all the merged nodes. The modified list should not contain any 0's.

Return the head of the modified linked list.

 

Example 1:

Input: head = [0,3,1,0,4,5,2,0]
Output: [4,11]
Explanation: 
The above figure represents the given linked list. The modified list contains
- The sum of the nodes marked in green: 3 + 1 = 4.
- The sum of the nodes marked in red: 4 + 5 + 2 = 11.

Example 2:

Input: head = [0,1,0,3,0,2,2,0]
Output: [1,3,4]
Explanation: 
The above figure represents the given linked list. The modified list contains
- The sum of the nodes marked in green: 1 = 1.
- The sum of the nodes marked in red: 3 = 3.
- The sum of the nodes marked in yellow: 2 + 2 = 4.

 

Constraints:

    The number of nodes in the list is in the range [3, 2 * 105].
    0 <= Node.val <= 1000
    There are no two consecutive nodes with Node.val == 0.
    The beginning and end of the linked list have Node.val == 0.


 */
class Solution1 {
    public ListNode mergeNodes(ListNode head) {
        ListNode curr=head;
        while(curr!=null){
            if(curr.val==0){
            int sum=0;
            ListNode nextNode=curr.next;
            while(nextNode!=null && nextNode.val!=0){
                sum+=nextNode.val;
                nextNode=nextNode.next;
                             System.out.println(nextNode.val);

                }

            ListNode newSummedListNode=new ListNode(sum,nextNode);
            curr.next=newSummedListNode;
            }
             curr=curr.next;
             System.out.println(curr.val);
        }

        //while(head.val==0){head=head.next;}
        return head;
    }
}


class Solution {
    public ListNode mergeNodes(ListNode head) {


        /* create a stack and push every node value untill the you find a zero,replace all the elements from the stack  with sum of ele last zero */
        ListNode curr=head;
        Stack<Integer> stack=new Stack<>();
        while(curr!=null){

            if(curr.val==0){
                int sum=0;
                while(!stack.isEmpty() && stack.peek()!=0){
                sum+=stack.pop();}

                stack.push(sum);
            }
            
            stack.push(curr.val);
            curr=curr.next;
        }

        /* create a new linked list and return that linked list*/
        ListNode newhead=null;
        curr=newhead;
        System.out.println(stack.toString());
        for(int i: stack){
            if(i!=0){
                System.out.println(i);
                if(curr==null) {curr=new ListNode(i); newhead=curr;}
                else {
                    curr.next=new ListNode(i);
                    curr=curr.next;
                }
                                System.out.println("curr-->"+curr.val);
               
            }
            }
            return newhead;
        }
        
    }
