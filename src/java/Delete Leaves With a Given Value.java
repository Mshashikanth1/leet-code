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
class Solution {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
          
       
         if(target == root.val && root.left!=null &&root.left.val==1 ) root=null;
          while(true){
          int removedCount=0, res=dfs(root, target,removedCount);
          System.out.println(res);
           if(removedCount==res && res==0) return root;
          }

    }
    public int dfs(TreeNode root, int target, int removedCount){
        if(root==null) return removedCount;

        if(root.left !=null  && root.left.val==target && root.left.left==null && root.left.right==null ){
            root.left=null;
            removedCount++;
        }

        if(root.right !=null && root.right.val==target && root.right.left==null && root.right.right==null){
            root.right=null;
            removedCount++;
        }
        return Math.max(dfs(root.left,target,removedCount) , dfs(root.right,target,removedCount));
    }
}

/**

1325. Delete Leaves With a Given Value
Solved
Medium
Topics
Companies
Hint
Given a binary tree root and an integer target, delete all the leaf nodes with value target.

Note that once you delete a leaf node with value target, if its parent node becomes a leaf node and has the value target, it should also be deleted (you need to continue doing that until you cannot).

 

Example 1:



Input: root = [1,2,3,2,null,2,4], target = 2
Output: [1,null,3,null,4]
Explanation: Leaf nodes in green with value (target = 2) are removed (Picture in left). 
After removing, new nodes become leaf nodes with value (target = 2) (Picture in center).
Example 2:



Input: root = [1,3,3,3,2], target = 3
Output: [1,3,null,null,2]
Example 3:



Input: root = [1,2,null,2,null,2], target = 2
Output: [1]
Explanation: Leaf nodes in green with value (target = 2) are removed at each step.
 

Constraints:

The number of nodes in the tree is in the range [1, 3000].
1 <= Node.val, target <= 1000
Seen this question in a real interview before?
1/5
Yes
No
Accepted
167.5K
Submissions
218.8K
Acceptance Rate
76.6%
Topics
Companies
Hint 1
Use the DFS to reconstruct the tree such that no leaf node is equal to the target. If the leaf node is equal to the target, return an empty object instead.
Discussion (97)

Choose a type




















 */
