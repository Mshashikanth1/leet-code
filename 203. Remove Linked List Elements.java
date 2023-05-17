/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }

 203. Remove Linked List Elements
Easy
7.2K
210
Companies

Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val, and return the new head.

 

Example 1:

Input: head = [1,2,6,3,4,5,6], val = 6
Output: [1,2,3,4,5]

Example 2:

Input: head = [], val = 1
Output: []

Example 3:

Input: head = [7,7,7,7], val = 7
Output: []

 

Constraints:

    The number of nodes in the list is in the range [0, 104].
    1 <= Node.val <= 50
    0 <= val <= 50


 */
class Solution1 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode c=head;
        ListNode p=null;
        int valCount=0,totalCount=0;
        
         try{

        while(head.val==val && head!=null){head=head.next;}
        while(c!=null){
            if(c.val==val){valCount++; }
            totalCount++;
            c=c.next;}
    
        c=head ;
        while(c!=null){
            while(c.val==val){
                if(p!=null) p.next=c.next ;
                else p=c.next;  
                }
             p=c;
             c=c.next;
             System.out.println(p.val+","+c.val);
  
       }
        } catch(Exception e){System.out.println(e);}
    
        if(valCount==totalCount && valCount!=0 ) return null;
        return head;
    }
}


/*
    (p,c,n)

    1  ,2  ,6  ,3  ,4  ,5  ,6   
    p    c   

 */


class Solution {
    public ListNode removeElements(ListNode head, int val) {
       
       //remove the elements from start of the list
        while(head!=null && head.val==val){
            System.out.println(head.val);
            head=head.next;}

        //remove from the middle of the list
        ListNode p=head,c=head;
        while(c!=null){
            if(c.val==val){
                while(c!=null && c.val==val){
                    c=c.next;
                }
                p.next=c;
                p=c;
            }else{
                p=c;
                c=c.next;
            }

        }

        //remove from the end of the list


        return head;
    }
}




