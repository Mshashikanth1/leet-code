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
206. Reverse Linked List.java
 problem : https://leetcode.com/problems/reverse-linked-list/
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null){return head;}
        ListNode current=head;
        ListNode prev=null;
        ListNode nextNode=null;
        while(current!=null){
                nextNode=current.next;
                current.next=prev;
                prev=current;
                current=nextNode;
                try{
                            System.out.println(prev.val+","+current.val+","+nextNode.val);
                            }
                            catch(Exception e){System.out.println(e);}


        }
        return prev;
        
    }
}
