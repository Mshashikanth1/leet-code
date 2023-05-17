/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 234. Palindrome Linked List
Easy
13.9K
762
Companies

Given the head of a singly linked list, return true if it is a
palindrome
or false otherwise.

 

Example 1:

Input: head = [1,2,2,1]
Output: true

Example 2:

Input: head = [1,2]
Output: false


 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode curr=head;
        Stack<Integer> stack=new Stack<>();
        while(curr!=null){
            stack.push(curr.val);
            curr=curr.next;
        }
        curr=head;
        while(curr!=null){
            if(stack.pop()!=curr.val) return false;
            curr=curr.next;
        }
        System.out.println(stack.toString());

        return true;
        
    }
}/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 234. Palindrome Linked List
Easy
13.9K
762
Companies

Given the head of a singly linked list, return true if it is a
palindrome
or false otherwise.

 

Example 1:

Input: head = [1,2,2,1]
Output: true

Example 2:

Input: head = [1,2]
Output: false


 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode curr=head;
        Stack<Integer> stack=new Stack<>();
        while(curr!=null){
            stack.push(curr.val);
            curr=curr.next;
        }
        curr=head;
        while(curr!=null){
            if(stack.pop()!=curr.val) return false;
            curr=curr.next;
        }
        System.out.println(stack.toString());

        return true;
        
    }
}
