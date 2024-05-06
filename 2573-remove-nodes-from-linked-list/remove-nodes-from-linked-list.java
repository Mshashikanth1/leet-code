/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }


 2487. Remove Nodes From Linked List
Solved
Medium
Topics
Companies
Hint
You are given the head of a linked list.

Remove every node which has a node with a greater value anywhere to the right side of it.

Return the head of the modified linked list.

 

Example 1:


Input: head = [5,2,13,3,8]
Output: [13,8]
Explanation: The nodes that should be removed are 5, 2 and 3.
- Node 13 is to the right of node 5.
- Node 13 is to the right of node 2.
- Node 8 is to the right of node 3.
Example 2:

Input: head = [1,1,1,1]
Output: [1,1,1,1]
Explanation: Every node has value 1, so no nodes are removed.
 

Constraints:

The number of the nodes in the given list is in the range [1, 105].
1 <= Node.val <= 105
Seen this question in a real interview before?
1/5
Yes
No
Accepted
63.2K
Submissions
96K
Acceptance Rate
65.8%
Topics
Companies
Hint 1
Hint 2
Similar Questions
Discussion (30)
Type comment here... (Markdown supported)

Choose a type
Preview
Comment
\U0001f4a1 Discussion Rules
1. Please don't post any solutions in this discussion.

2. The problem discussion is for asking questions about the problem or for sharing tips - anything except for solutions.

3. If you'd like to share your solution for feedback and ideas, please head to the solutions tab and post it there.


Sort by:Best

smit_02
Jun LeetCoding Challenge
May 21, 2023
This question need more example

13
Reply

rohit-1311
Dynamic Programming I
Nov 27, 2022
Easy steps using a DEQUE
Simply keep adding elements from back of the queue,
While doing so, remove all the nodes from back when the back is smaller then the new node value
Once added all element to deque, then pop from front and form the linked list again.
        temp=head
        deque<ListNode*> dq 
        while   temp!=NULL
            if  !dq.empty 
                while  !dq.empty  &&   dq.back ->val  <   temp->val  
                    dq.pop_back
            
            dq.push_back(temp)
            temp=temp->next
        
      Now, form the linked list from the nodes remained in the deque

Read more
Tip
6
Show 3 Replies
Reply

novice00051
100 Days Badge 2022
Jan 10, 2023
I don't understand the question even after reading it so many times, an someone please explain it to me?

5
Show 4 Replies
Reply

Daanishqan
50 Days Badge 2023
Oct 19, 2023
So, a monotonic stack to keep track of all the nodes and then re-creating the linked list again. Wonder if it could be done without using any stacks or queues.

4
Show 2 Replies
Reply

krex0r
SQL I
Aug 01, 2023
Remove every node which has a node with a strictly greater value anywhere to the right side of it.

1 -> 1 -> 1 -> 1 ([1,1,1,1]) returns [1,1,1,1], but shouldnt it return [1] because 1 is not strictly greater than 1 ???

3
Show 1 Replies
Reply

Ebad1001
100 Days Badge 2023
Jun 25, 2023
My code works in O(n^2) time but it is showing time limit exceeded. Are we supposed to do it in O(n) linear time then ?

2
Show 1 Replies
Reply

psionl0
Annual Badge 2023
8 hours ago
If you don't have garbage collection then the correct way is to free each node that is removed from the list. However, if you do that then you suffer a significant time and space penalty.
The leetCode engine doesn't care whether you free the nodes or not but this should not be the case. It should not accept solutions that have memory leakage.

1
Reply

ArchilGhosh
50 Days Badge 2024
10 hours ago
I don't know why most of comments are solutions . When I need the explaination of the question.

Feedback
1
Reply

Dixit08
100 Days Badge 2023
Dec 21, 2023
Similar to the leaders of the array problem

1
Reply

SadanandaBanerjee
Data Structure I
Feb 13, 2023
Easy steps Using Stack :

if stack is empty then add value
If stack have some value the pop the element if top of stack is greater or equal to the current value
Here is an example , try this in linked list

l=[5,2,13,3,8] stack=[] for i in l: if stack: while(len(stack)!=0 and stack[len(stack)-1]<i): stack.pop(len(stack)-1) stack.append(i) else: stack.append(i) print(stack)

Read more
1
Reply
Copyright ©️ 2024 LeetCode All rights reserved

1.4K


30




 */
class Solution {
    public ListNode removeNodes(ListNode head) {
       Stack<ListNode> stack=new Stack<>();
    
       ListNode curr=head;
       while(curr!=null){
        
        while(!stack.isEmpty()  && stack.peek().val < curr.val) stack.pop();

        stack.push(curr);
        curr=curr.next;
       }

       ListNode newHead=null;
       while(!stack.isEmpty()){
            stack.peek().next=newHead;
            newHead=stack.pop();
       }

       return newHead;
    }
}