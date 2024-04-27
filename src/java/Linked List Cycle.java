/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /**
     use a hashset to identify the dublicate node, if we are visiting again and again return true 
     there is a cycle
     Time : O(n)
     Space : O(n)
     */
    Set<ListNode> hSet =new HashSet<>();
    public boolean hasCycle1(ListNode head) {
        ListNode curr=head;
        while(curr!=null && !hSet.contains(curr)) {
            hSet.add(curr);
            curr=curr.next; 
        }
        return hSet.contains(curr);
    }
    /**
    recursive solution als has the time complexity of 
    Time : O(n)
    Space : O(n)
    and it is the cpu intensive task
     */
     public boolean hasCycle2(ListNode head) {
        if(head==null) return false; 
        if(hSet.contains(head)) return true;  //stopping or base conditon
        hSet.add(head);
        return hasCycle(head.next);      //small amount of work
    }
    /**
    use the fast pointer and second pointer  will be the optimized solutions
    Time : O(n)
    Space : O(1)
     */
    public boolean hasCycle3(ListNode head) {
           if (head ==null || head.next==null) return false;
           ListNode sp=head, fp=head.next;
           while (fp!=null && fp.next!=null){
               sp=sp.next;
               fp=fp.next.next;
               if(sp==fp) return true;
           }
          return false;
    }

    /**
    recursive fast pointer and slow pointer; not cpu intensive operations
    Time  : O(n)
    Space : O(1)
         */
      public boolean hasCycle(ListNode head) {
          if(head==null) return false;
           return hasCycleRec(head, head.next);
    }
    public boolean hasCycleRec(ListNode sp, ListNode fp){
        if(fp==null || fp.next==null ) return false;  //stopping /base  condition
        if(sp==fp) return true;
        return hasCycleRec(sp.next,fp.next.next); //small amount of work
    }

}

/**

141. Linked List Cycle
Solved
Easy
Topics
Companies
Given head, the head of a linked list, determine if the linked list has a cycle in it.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.

Return true if there is a cycle in the linked list. Otherwise, return false.

 

Example 1:


Input: head = [3,2,0,-4], pos = 1
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
Example 2:


Input: head = [1,2], pos = 0
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.
Example 3:


Input: head = [1], pos = -1
Output: false
Explanation: There is no cycle in the linked list.
 

Constraints:

The number of the nodes in the list is in the range [0, 104].
-105 <= Node.val <= 105
pos is -1 or a valid index in the linked-list.
 

Follow up: Can you solve it using O(1) (i.e. constant) memory?
 */
