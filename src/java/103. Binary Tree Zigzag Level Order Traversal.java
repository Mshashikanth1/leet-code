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
    Map<Integer,List<Integer>> adjList=new HashMap<>();
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> ans=new ArrayList<>();
            dfs(root,0);
            for(int i: adjList.keySet()){
                if(i%2==1){
                    Collections.reverse(adjList.get(i));
                    ans.add(adjList.get(i));
                }
                else{
                    ans.add(adjList.get(i));
                }
            }
            return ans;
    }
    void dfs(TreeNode root, int depth){
        if(root==null) return;
        List<Integer> lis;
        if(adjList.containsKey(depth)) lis=adjList.get(depth);
        else lis=new ArrayList<>();
        lis.add(root.val);
        adjList.put(depth,lis);
        dfs(root.left,depth+1);
        dfs(root.right,depth+1);
    }
}

/*
103. Binary Tree Zigzag Level Order Traversal
Medium
9.7K
250
Companies

Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).

 

Example 1:

Input: root = [3,9,20,null,null,15,7]
Output: [[3],[20,9],[15,7]]

Example 2:

Input: root = [1]
Output: [[1]]

Example 3:

Input: root = []
Output: []

 

Constraints:

    The number of nodes in the tree is in the range [0, 2000].
    -100 <= Node.val <= 100


 */
