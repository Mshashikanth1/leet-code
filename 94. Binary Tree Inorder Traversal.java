94. Binary Tree Inorder Traversal.java

problem:https://leetcode.com/problems/binary-tree-inorder-traversal/description/

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
    public  List<Integer> inorderTraversalList=new ArrayList<Integer>();
    public List<Integer> inorderTraversal(TreeNode root) {
        //LNR :inorder tranversal
        if(root!=null){
                inorderTraversal(root.left);
                inorderTraversalList.add(root.val);
                inorderTraversal(root.right);
        }
        return inorderTraversalList;
        
    }
}
