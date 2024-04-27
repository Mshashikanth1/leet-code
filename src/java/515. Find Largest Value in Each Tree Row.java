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
515. Find Largest Value in Each Tree Row
Medium
3.3K
105
Companies
Given the root of a binary tree, return an array of the largest value in each row of the tree (0-indexed).

 

Example 1:


Input: root = [1,3,2,5,3,null,9]
Output: [1,3,9]
Example 2:

Input: root = [1,2,3]
Output: [1,3]
 

Constraints:

The number of nodes in the tree will be in the range [0, 104].
-231 <= Node.val <= 231 - 1

 */
class Solution {
    Map<Integer,List<Integer>> adjList;
    public List<Integer> largestValues(TreeNode root) {
        adjList=new HashMap<>();
        dfs(root,0);
        
        List<Integer> ans=new ArrayList<>();
        for(List<Integer> row : adjList.values()) ans.add(Collections.max(row));
        return ans;
    }
    void dfs(TreeNode node,int level){
        if(node==null) return;
        
        List<Integer> rowNode;
        if(adjList.containsKey(level)) rowNode=adjList.get(level);
        else rowNode=new ArrayList<>();

        rowNode.add(node.val);
        adjList.put(level,rowNode);

        dfs(node.left,level+1);
        dfs(node.right,level+1);
    }
}
