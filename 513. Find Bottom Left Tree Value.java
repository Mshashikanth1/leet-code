/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
 /**
 space :O(n) , time :O(n)
  */
class Solution {
    Map<Integer,List<Integer>> leverOrderMap;
    public int findBottomLeftValue(TreeNode root) {
        leverOrderMap=new LinkedHashMap<>();
        this.dfs(root,0);
        int size=leverOrderMap.size();
        return leverOrderMap.get(size-1).get(0);
    }
    void dfs(TreeNode root,int order){
        if(root==null) return;
        List<Integer> lis=leverOrderMap.containsKey(order) ?
                          leverOrderMap.get(order)
                          :new ArrayList<>();
        lis.add(root.val);
        leverOrderMap.put(order,lis);

        this.dfs(root.left,order+1);
        this.dfs(root.right,order+1);
    }
}

/**
513. Find Bottom Left Tree Value
Solved
Medium
Topics
Companies
Given the root of a binary tree, return the leftmost value in the last row of the tree.

 

Example 1:


Input: root = [2,1,3]
Output: 1
Example 2:


Input: root = [1,2,3,4,null,5,6,null,null,7]
Output: 7
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
-231 <= Node.val <= 231 - 1
Seen this question in a real interview before?
1/4
Yes
No
Accepted
305.4K
Submissions
436.5K
Acceptance Rate
70.0%
Topics
Companies
Discussion (97)

 */
