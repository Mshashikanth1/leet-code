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

 time:O(n^2) n is the number of nodes;
 space:O(n) n is the number of nodes;

 */
class Solution {
    int ans=0;
    public int averageOfSubtree(TreeNode root) {
        itrEachNode(root);
        return ans;
    }
    void itrEachNode(TreeNode subTree){
        if(subTree==null ) return;
        itrEachNode(subTree.right);
        ans+=isTreeAvgEqualToRoot(subTree);
        itrEachNode(subTree.left);
    }

    int isTreeAvgEqualToRoot(TreeNode tree){
        List<Integer> arr=new ArrayList<>();
        avgTree(tree,arr);
        if(tree.val==arr.stream().reduce(Integer::sum).orElse(0)/arr.size()) return 1 ;
        return 0;
    }
    void avgTree(TreeNode tree,List<Integer> arr){
        if(tree==null ) return;
        avgTree(tree.left,arr);
        arr.add(tree.val);
        avgTree(tree.right,arr);
    }

}

/**
2265. Count Nodes Equal to Average of Subtree
Medium
1.5K
24
Companies
Given the root of a binary tree, return the number of nodes where the value of the node is equal to the average of the values in its subtree.

Note:

The average of n elements is the sum of the n elements divided by n and rounded down to the nearest integer.
A subtree of root is a tree consisting of root and all of its descendants.
 

Example 1:


Input: root = [4,8,5,0,1,null,6]
Output: 5
Explanation: 
For the node with value 4: The average of its subtree is (4 + 8 + 5 + 0 + 1 + 6) / 6 = 24 / 6 = 4.
For the node with value 5: The average of its subtree is (5 + 6) / 2 = 11 / 2 = 5.
For the node with value 0: The average of its subtree is 0 / 1 = 0.
For the node with value 1: The average of its subtree is 1 / 1 = 1.
For the node with value 6: The average of its subtree is 6 / 1 = 6.
Example 2:


Input: root = [1]
Output: 1
Explanation: For the node with value 1: The average of its subtree is 1 / 1 = 1.
 

Constraints:

The number of nodes in the tree is in the range [1, 1000].
0 <= Node.val <= 1000
Accepted
67.5K
Submissions
78.5K

 */
