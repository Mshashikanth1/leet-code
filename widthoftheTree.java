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
//  complete binary tree : some will nodes  be missed 
//  null also has the null child, 
//  width distance between , left most node and right most child
//  2^n in the nth node
//  level order traversal , if we consider the  depth of left most and right most 

//  BFS: Level Order Traversal
//  depth of first chile= 2*parent node  depth

//  DFS : store the indes -->dic{} 
//  */
// class Solution {
//     int maxWidth=0;
//     public class Data{
//         public TreeNode node;
//         public int indx;
//         private Data(TreeNode node,int indx){
//             this.node=node;
//             this.indx=indx;
//         }

//     }
//     public void BFS(TreeNode root){
//         if(root==null) return;
//         Queue<Data> queue=new LinkedList<Data>();
//         queue.add(new Data(root,0));
//         Data curr,first;
//         while(!queue.isEmpty()){
//             first=queue.peek();
//             curr=queue.poll();
//            if(curr.node.left!=null)
//             queue.offer(new Data(curr.node.left,2*curr.indx));
//             if(curr.node.right!=null)
//             queue.offer(new Data(curr.node.right,2*curr.indx+1));
//             maxWidth=Math.max(maxWidth,curr.indx-first.indx+1);
//         }

//     }
//     public int widthOfBinaryTree(TreeNode root) {
//         BFS(root);
//         return maxWidth;
//     }
// }

class Pair{
    int pos;
    TreeNode node;
    Pair(int x,TreeNode y){
        pos = x;
        node = y;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0,root));
        int max = Integer.MIN_VALUE;
        while(!q.isEmpty()){
            int size = q.size();
            int start = 0;
            int end = 0;
            for(int i = 0 ; i < size; i ++){
                Pair p = q.poll();
                int pos = p.pos;
                TreeNode node = p.node;
                
                if(i == 0){
                    start = pos;
                }
                if(i == size -1){
                    end = pos;
                }
                if(node.left != null){
                    q.offer(new Pair(2*pos+1,node.left));
                }
                if(node.right != null){
                    q.offer(new Pair(2*pos+2,node.right));
                }
            }
            max = Math.max(max,end+1-start);
        }
        return max;
    }
}
