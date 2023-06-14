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
 530. Minimum Absolute Difference in BST
Easy
3.4K
166
Companies

Given the root of a Binary Search Tree (BST), return the minimum absolute difference between the values of any two different nodes in the tree.

 

Example 1:

Input: root = [4,2,6,1,3]
Output: 1

Example 2:

Input: root = [1,0,48,null,null,12,49]
Output: 1

 

Constraints:

    The number of nodes in the tree is in the range [2, 104].
    0 <= Node.val <= 105

 

Note: This question is the same as 783: https://leetcode.com/problems/minimum-distance-between-bst-nodes/

 */
class Solution {
     int min=Integer.MAX_VALUE;
     List<Integer> lis =new ArrayList<>();

    public int getMinimumDifference(TreeNode root) {
         dfs(root);  

         for(int i=0;i<lis.size();i++){
             for(int j=0;j<lis.size();j++){
                 if(i!=j){
                     min=Math.min(min,Math.abs(lis.get(i)-lis.get(j)));
                 }
             }
         }
         return this.min;
    }
    public void dfs(TreeNode root){
        if(root==null) return;
        dfs(root.left);
        lis.add(root.val);
        dfs(root.right);
    }
}
