/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 382. Linked List Random Node
Medium
2.9K
676
Companies

Given a singly linked list, return a random node's value from the linked list. Each node must have the same probability of being chosen.

Implement the Solution class:

    Solution(ListNode head) Initializes the object with the head of the singly-linked list head.
    int getRandom() Chooses a node randomly from the list and returns its value. All the nodes of the list should be equally likely to be chosen.

 

Example 1:

Input
["Solution", "getRandom", "getRandom", "getRandom", "getRandom", "getRandom"]
[[[1, 2, 3]], [], [], [], [], []]
Output
[null, 1, 3, 2, 2, 3]

Explanation
Solution solution = new Solution([1, 2, 3]);
solution.getRandom(); // return 1
solution.getRandom(); // return 3
solution.getRandom(); // return 2
solution.getRandom(); // return 2
solution.getRandom(); // return 3
// getRandom() should return either 1, 2, or 3 randomly. Each element should have equal probability of returning.

 

Constraints:

    The number of nodes in the linked list will be in the range [1, 104].
    -104 <= Node.val <= 104
    At most 104 calls will be made to getRandom.

 */
class Solution {
    public List<Integer> lis;
    ListNode root ;
    public Solution(ListNode head) {
            root=head;
            lis=new ArrayList<>();
            ListNode curr=head;
            while(curr!=null){
                lis.add(curr.val);
                curr=curr.next;
            }
    }
    
    public int getRandom() {
        Random random = new Random();
        int size = lis.size();
        int randomIndex = random.nextInt(size);
        return lis.get(randomIndex);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
