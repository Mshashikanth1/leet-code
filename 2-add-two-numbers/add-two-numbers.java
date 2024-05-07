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
        int carry=0;
        ListNode fir=l1, sec=l2, res=new ListNode(-1), curr=res;

        while(fir!=null && sec!=null){
            int sum= (fir.val+sec.val+carry);
            carry= sum/10;
            curr.next=new ListNode(sum%10);
            curr=curr.next;
            fir=fir.next;
            sec=sec.next;
        }

        while(fir!=null){
            int sum= (fir.val+carry);
            carry= sum/10;
            curr.next=new ListNode(sum%10);
            curr=curr.next;
            fir=fir.next;
        }


        while(sec!=null){
            int sum= (sec.val+carry);
            carry= sum/10;
            curr.next=new ListNode(sum%10);
            curr=curr.next;
            sec=sec.next;
        }

        if(carry!=0){
            curr.next=new ListNode(carry);
        }

        res=res.next;
        return res;
    }
}