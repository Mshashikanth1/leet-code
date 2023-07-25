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
class Solution_dfs {
    Map<Integer,List<Integer>> adjList;
    public List<List<Integer>> levelOrder(TreeNode root) {
        adjList=new HashMap<>();
        List<List<Integer>> ans=new ArrayList<>();
        dfs(root,0);
        for(int i: adjList.keySet()){
            ans.add(adjList.get(i));
        }
        return ans;
    }

    void dfs(TreeNode root,int depth){
        if(root==null) return;
        List<Integer> lis;
        if(adjList.containsKey(depth)){
            lis=adjList.get(depth);
            lis.add(root.val);
        }else{
            lis=new ArrayList<>();
            lis.add(root.val);
        }

        adjList.put(depth,lis);

        dfs(root.left,depth+1);
        dfs(root.right,depth+1);
    }
}

class Solution {
    Map<Integer,List<Integer>> adjList;
    public List<List<Integer>> levelOrder(TreeNode root) {
           List<List<Integer>> ans=new ArrayList<>();
            Queue<Node> queue=new Queue<>();
           while(queue.isEmpty()){
                
           }
     
    }
}

/*
102. Binary Tree Level Order Traversal
Medium
13.8K
273
Companies

Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

 

Example 1:

Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]

Example 2:

Input: root = [1]
Output: [[1]]

Example 3:

Input: root = []
Output: []

 

Constraints:

    The number of nodes in the tree is in the range [0, 2000].
    -1000 <= Node.val <= 1000


 */
