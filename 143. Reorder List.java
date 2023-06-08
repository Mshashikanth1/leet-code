/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }

 143. Reorder List
Medium
8.9K
296
Companies

You are given the head of a singly linked-list. The list can be represented as:

L0 → L1 → … → Ln - 1 → Ln

Reorder the list to be on the following form:

L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …

You may not modify the values in the list's nodes. Only nodes themselves may be changed.

 

Example 1:

Input: head = [1,2,3,4]
Output: [1,4,2,3]

Example 2:

Input: head = [1,2,3,4,5]
Output: [1,5,2,4,3]

 

Constraints:

    The number of nodes in the list is in the range [1, 5 * 104].
    1 <= Node.val <= 1000


 */
class Solution {
    public void reorderList(ListNode head) {
        List<Integer> lis=new ArrayList<>();
        ListNode curr=head;

        while(curr!=null){
            lis.add(curr.val);
            curr=curr.next;
        }

        System.out.println(lis.toString());
        int i=0,n=lis.size()-1;
        curr=head;
        Boolean flag=true;
        while(curr!=null){
            if(flag){ curr.val=lis.get(i); i++; flag=!flag;}
            else{ curr.val=lis.get(n); n--; flag=!flag;}
            curr=curr.next;
            }
        
    }
}
