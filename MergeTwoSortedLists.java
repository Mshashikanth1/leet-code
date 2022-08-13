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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode temp=new ListNode();
        ListNode m=list1;
        ListNode n=list2;
        ListNode mll=temp;
       
      //compare the two elements and update them in mll list accordingly
        while(m!=null && n!=null){
             if(m.val<n.val){
                 mll.next=m;
                 m=m.next;
                 mll=mll.next;
             }
            else if(m.val==n.val){
                mll.next=m;
                 m=m.next;
                 mll=mll.next;
                
                mll.next=n;
                n=n.next;
                mll=mll.next;
                
            }
            else{
                mll.next=n;
                n=n.next;
                mll=mll.next;
            }
            
        }
        //if m is still not null
         while(m!=null){
                 mll.next=m;
                 m=m.next;
                 mll=mll.next;}
        //if n is stll not null
         while(n!=null){
                mll.next=n;
                n=n.next;
                mll=mll.next; }    
        
        
        //make the second element as the head;
        temp=temp.next;
        return temp;
        
    }
}
