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
    public ListNode doubleIt(ListNode head) {
        int carry=0;

        Stack<ListNode> stack= new Stack<>();
        ListNode curr=head;
        while(curr!=null){
            stack.push(curr);
            curr=curr.next;
        }

        while(!stack.isEmpty()){
            ListNode dig=stack.pop();
            int num= ((dig.val*2 +carry))%10;
            carry=((dig.val*2+carry))/10;
            dig.val=num;
        }

        if(carry!=0){
            ListNode carryNode=new ListNode(carry);
            carryNode.next=head;
            head=carryNode;
        }
        return head;
    }
}