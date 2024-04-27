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

    
    public String smallestFromLeaf1(TreeNode root) {
        
        List<String> ans= dfs1(root,new Stack<>(), new ArrayList<>());
        Collections.sort(ans);
        return ans.get(0);
    }
    public List<String> dfs1(TreeNode root, Stack<TreeNode> stack, List<String> ans){
        if(root==null) return ans;
        stack.push(root);
        if(root.left==null && root.right==null) {
            StringBuilder sb=new StringBuilder();
            for(TreeNode n:stack){
                sb.append((char) (97+n.val));
            }
            ans.add(sb.reverse().toString());
        }
        
        dfs1(root.left, stack,ans);
        while(stack.peek().right!=root.right) stack.pop();
        dfs1(root.right, stack,ans);
        return ans;
    }
}

/**
988. Smallest String Starting From Leaf
Solved
Medium
Topics
Companies
You are given the root of a binary tree where each node has a value in the range [0, 25] representing the letters 'a' to 'z'.

Return the lexicographically smallest string that starts at a leaf of this tree and ends at the root.

As a reminder, any shorter prefix of a string is lexicographically smaller.

For example, "ab" is lexicographically smaller than "aba".
A leaf of a node is a node that has no children.

 

Example 1:


Input: root = [0,1,2,3,4,3,4]
Output: "dba"
Example 2:


Input: root = [25,1,3,1,3,0,2]
Output: "adz"
Example 3:


Input: root = [2,2,1,null,1,0,null,0]
Output: "abc"
 

Constraints:

The number of nodes in the tree is in the range [1, 8500].
0 <= Node.val <= 25
 */
