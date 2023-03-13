problem https://leetcode.com/problems/symmetric-tree/solutions/
// /**
//  * Definition for a binary tree node.
//  * public class TreeNode {
//  *     int val;
//  *     TreeNode left;
//  *     TreeNode right;
//  *     TreeNode() {}
//  *     TreeNode(int val) { this.val = val; }
//  *     TreeNode(int val, TreeNode left, TreeNode right) {
//  *         this.val = val;
//  *         this.left = left;
//  *         this.right = right;
//  *     }
//  * }
//     inorder : LNR --<> 3,2,4,1,4,2,3


//     preOrder: NLR  ---<> 1,2,3,4,2,4,3
//     PostOrder: LRN ----<> 3,4,2,4,3,2,1
//  */
// class Solution {

//     public boolean isMirror(TreeNode rootLeft,TreeNode rootRight){
//         if((rootLeft==null && rootRight==null) && rootLeft==rootRight){return true;}
//         if(rootLeft!=null || rootRight!=null){return false;}
//         if ( rootLeft!=null && rootRight!=null && isMirror(rootLeft.left,rootRight.right) && isMirror(rootLeft.right,rootRight.left))      {return true;}
//         return false;
//     }
//     public boolean isSymmetric(TreeNode root) {
//         if(root==null){return true;}
//         if(isMirror(root.left,root.right)){return true;}
//         return false;
//     }
// }
class Solution {
    static boolean mir( TreeNode t1 , TreeNode t2 )
    {
        if( t1==null && t2== null ) return true;
        else if( t1==null || t2==null ) return false;

        return ( t1.val==t2.val ) && mir( t1.right , t2.left ) && mir( t1.left , t2.right );
    }
    public boolean isSymmetric(TreeNode root) 
    {
        return mir( root , root );
    
    }
}
