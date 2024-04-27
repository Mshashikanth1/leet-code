/**
* 226. Invert Binary Tree.java
*Problem : https://leetcode.com/problems/invert-binary-tree/
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
    public TreeNode invertTree1(TreeNode root) {
        if(root!=null){
            TreeNode leftSubTree=invertTree(root.left);
            TreeNode rigthSubTree=invertTree(root.right);
            root.right=leftSubTree;
            root.left=rigthSubTree;
        }
        return root;
    }
    //breadth-first search implemntation
    public TreeNode invertTree(TreeNode root){
        if (root==null )return null;
        Queue<TreeNode> queue= new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode currentNode=queue.poll();
            TreeNode temp=currentNode.left;
            currentNode.left=currentNode.right;
            currentNode.right=temp;
            System.out.print(currentNode.val+",:"+"both left and right are swapped");
            if(currentNode.left!=null)
                queue.add(currentNode.left);
            if(currentNode.right!=null)
                queue.add(currentNode.right);
            }
                    return root;

        }
    }

