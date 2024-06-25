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
   
    /** T : O(V)  S: O(V) */
    public TreeNode _bstToGst(TreeNode root) {
        List<Integer> nodes= new ArrayList<>();

        _DFS(nodes, root, "READ");
        int sum=0;
        for( int i: nodes){
            sum+=i;
        }

        int currSum=0;
        for( int i=0;i<nodes.size(); i++){
            int prev= nodes.get(i);
            nodes.set(i, sum-currSum);
            currSum+=prev;
        }


        _DFS(nodes, root, "WRITE" );
        return root;
        
        
    }



    public void _DFS(List<Integer> nodes, TreeNode root, String action){
            if( root==null) return;

            _DFS(nodes, root.left, action);

            if( action.equals("READ")) nodes.add(root.val);
            else   root.val=nodes.remove(0);

            _DFS(nodes, root.right, action);
    }


    /** T : O(V)  S : O(1)*/
    int sum=0,currSum=0;
    public TreeNode bstToGst(TreeNode root) {
            DFS( root, "READ");
            DFS(root, "WRITE");

            return root;
    }

      public void DFS( TreeNode root, String action){
            if( root==null) return;

            DFS(root.left, action);

            if( action.equals("READ")) sum+=root.val;
            else   {
                int prev= root.val;
                root.val= sum-currSum;
                currSum+=prev;
            }

            DFS( root.right, action);
    }

}

/**

1038. Binary Search Tree to Greater Sum Tree
Solved
Medium
Topics
Companies
Hint
Given the root of a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus the sum of all keys greater than the original key in BST.

As a reminder, a binary search tree is a tree that satisfies these constraints:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
 

Example 1:


Input: root = [4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
Output: [30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
Example 2:

Input: root = [0,null,1]
Output: [1,null,1]
 

Constraints:

The number of nodes in the tree is in the range [1, 100].
0 <= Node.val <= 100
All the values in the tree are unique.
 

Note: This question is the same as 538: https://leetcode.com/problems/convert-bst-to-greater-tree/
 */
