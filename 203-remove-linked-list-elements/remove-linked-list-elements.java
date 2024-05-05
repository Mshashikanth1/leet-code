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
    public ListNode removeElements1(ListNode head, int val) {

       ListNode curr=head;
       List<Integer> lis=new ArrayList<>();

       while(curr!=null){
        if(curr.val!=val) lis.add(curr.val);
        curr=curr.next;
       }

       head=new ListNode(-1);
       curr=head;
       for(int i: lis) {
        curr.next= new ListNode(i);
        curr=curr.next;
       }

       head=head.next;
       return head;
       
    }

    public ListNode removeElements(ListNode head, int val) {

       ListNode curr=head, newHead=new ListNode(-1), newCurr=newHead;
       
       while(curr!=null){
        if(curr.val!=val) {newCurr.next=curr; newCurr=newCurr.next;}
        curr=curr.next;
       }
        newCurr.next=null;

       
       newHead=newHead.next;
       return newHead;
       
    }
}