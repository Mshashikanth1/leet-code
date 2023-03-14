129. Sum Root to Leaf Numbers.java
Problem : https://leetcode.com/problems/sum-root-to-leaf-numbers/
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
// class Solution {
//     public boolean isLeafNode(TreeNode root){return root.left==null && root.right==null;}
//     String str="";
//     public void preOrderTraversal(TreeNode root){
//         if(root!=null){
//         str+=root.val;
//         System.out.println(str);
//         preOrderTraversal(root.left);
//         str=str.substring(0,str.length()-1);
//         preOrderTraversal(root.right);
//         }
//     }
//     public int sumNumbers(TreeNode root) {
//         preOrderTraversal(root);
//         return 1;
//     }
// }

class Solution {
    public int sumNumbers(TreeNode root) {
      if(root==null) return 0;
        return helper(root,0);
    }
     private int helper(TreeNode root, int sumvalue){
      if(root==null) return 0;
      sumvalue=sumvalue*10+root.val;
      if(root.left==null && root.right==null) return sumvalue;
      return helper(root.left,sumvalue)+helper(root.right,sumvalue);
     }
}
