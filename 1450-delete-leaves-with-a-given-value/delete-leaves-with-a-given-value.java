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
    public TreeNode removeLeafNodes(TreeNode root, int target) {
          
       
         if(target == root.val && root.left!=null &&root.left.val==1 ) root=null;
          while(true){
          int removedCount=0, res=dfs(root, target,removedCount);
          System.out.println(res);
           if(removedCount==res && res==0) return root;
          }

    }
    public int dfs(TreeNode root, int target, int removedCount){
        if(root==null) return removedCount;

        if(root.left !=null  && root.left.val==target && root.left.left==null && root.left.right==null ){
            root.left=null;
            removedCount++;
        }

        if(root.right !=null && root.right.val==target && root.right.left==null && root.right.right==null){
            root.right=null;
            removedCount++;
        }
        return Math.max(dfs(root.left,target,removedCount) , dfs(root.right,target,removedCount));
    }
}