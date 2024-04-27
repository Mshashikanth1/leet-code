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

    //using global variable Time : O(n) Space : O(1)
    int ans;
    public int sumOfLeftLeaves1(TreeNode root) {
        ans=0;
        dfs1(root,false);
        return  ans;
    }

    public void dfs1(TreeNode root, boolean isLeft){
        if(root==null) return ;
        if(isLeft && root.right==null && root.left==null) ans+=root.val;
        dfs(root.left,true);
        dfs(root.right,false);
    }


    //without using global varaible Time :O(n) Space :O(1)
    public int sumOfLeftLeaves(TreeNode root) {
       return dfs(root,false);
    }

    public int dfs(TreeNode root, boolean isLeft){
        if(root==null) return 0;
        if(isLeft && root.right==null && root.left==null) return root.val;
        int lRes=dfs(root.left,true);
        int rRes=dfs(root.right,false);

        return lRes+rRes;
    }


}

/**

404. Sum of Left Leaves
Solved
Easy
Topics
Companies
Given the root of a binary tree, return the sum of all left leaves.

A leaf is a node with no children. A left leaf is a leaf that is the left child of another node.

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: 24
Explanation: There are two left leaves in the binary tree, with values 9 and 15 respectively.
Example 2:

Input: root = [1]
Output: 0
 

Constraints:

The number of nodes in the tree is in the range [1, 1000].
-1000 <= Node.val <= 1000
 */
