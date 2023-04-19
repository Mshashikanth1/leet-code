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
 1372. Longest ZigZag Path in a Binary Tree.java
 Problem : https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree/editorial/
 You are given the root of a binary tree.

A ZigZag path for a binary tree is defined as follow:

    Choose any node in the binary tree and a direction (right or left).
    If the current direction is right, move to the right child of the current node; otherwise, move to the left child.
    Change the direction from right to left or from left to right.
    Repeat the second and third steps until you can't move in the tree.

Zigzag length is defined as the number of nodes visited - 1. (A single node has a length of 0).

Return the longest ZigZag path contained in that tree.

 Input: root = [1,null,1,1,1,null,null,1,1,null,1,null,null,null,1,null,1]
Output: 3
Explanation: Longest ZigZag path in blue nodes (right -> left -> right).

Input: root = [1,1,1,null,1,null,null,1,1,null,1]
Output: 4
Explanation: Longest ZigZag path in blue nodes (left -> right -> left -> right).

 */
class Solution {
    int pathLength=0;
    private void dfs(TreeNode node, boolean goLeft, int steps){
        if(node==null){
            return;
        }
        pathLength=Math.max(pathLength,steps);
        if(goLeft){
            dfs(node.left,false,steps+1);
            dfs(node.right,true,1);
        }
        else{
            dfs(node.left, false, 1);
            dfs(node.right,true,steps+1);
        }
    }
    public int longestZigZag(TreeNode root) {
        dfs(root,false,0);
        dfs(root,true,0);
        return pathLength;
         
    }
}
