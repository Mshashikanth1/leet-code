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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       ListNode n=new ListNode(0),h=n;
       int c=0,r=0;
        while(l1!=null && l2!=null){
         
            int sum=l1.val+l2.val+c;
            r= sum%10;
            c=sum/10;
            h.next= new ListNode(r);
            h=h.next;
            System.out.println(l1.val+","+l2.val+","+r+","+c);
            
            l1=l1.next;
            l2=l2.next;
            
        }
         while(l1!=null){
         
            int sum=l1.val+c;
            r= sum%10;
            c=sum/10;
            h.next= new ListNode(r);
            h=h.next;
            
            
            l1=l1.next;
         
            
        }
         while(l2!=null){
         
            int sum=l2.val+c;
            r= sum%10;
            c=sum/10;
            h.next= new ListNode(r);
            h=h.next; 
            l2=l2.next;
            
        }
        if(c!=0){
      h.next=new ListNode(c);}
        n=n.next;
        return n;
        
    }
}
