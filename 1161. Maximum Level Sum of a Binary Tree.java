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
 1161. Maximum Level Sum of a Binary Tree
Medium
2.6K
82
Companies

Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.

Return the smallest level x such that the sum of all the values of nodes at level x is maximal.

 

Example 1:

Input: root = [1,7,0,7,-8,null,null]
Output: 2
Explanation: 
Level 1 sum = 1.
Level 2 sum = 7 + 0 = 7.
Level 3 sum = 7 + -8 = -1.
So we return the level with the maximum sum which is level 2.

Example 2:

Input: root = [989,null,10250,98693,-89388,null,null,null,-32127]
Output: 2

 

Constraints:

    The number of nodes in the tree is in the range [1, 104].
    -105 <= Node.val <= 105


 */
class Solution {
    Map<Integer,Integer> map=new HashMap<>();
    int sum;
    
    public int maxLevelSum(TreeNode root) {
        dfs(root,1);
        //System.out.println(map.toString());
             int maxKey = map.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(0);
        return maxKey;
    }
    public void dfs(TreeNode root,int level){
        if(root==null) return;

        dfs(root.left,level+1);

        if(map.containsKey(level)) sum=map.get(level);
        else sum=0;

        sum+=root.val;
        map.put(level,sum);
        dfs(root.right,level+1);
    }
}
