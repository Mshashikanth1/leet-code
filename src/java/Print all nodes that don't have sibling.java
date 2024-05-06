



//User function Template for Java

/*  A Binary Tree nodea
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}

Print all nodes that don't have sibling
EasyAccuracy: 18.01%Submissions: 147K+Points: 2
 Done with winning Geekbits? Now win GfG Bag, GfG T-shirt & much more just by writing your experiences. Start Writing, Start Winning.
banner
Given a Binary Tree of n nodes, find all the nodes that don't have any siblings. You need to return a list of integers containing all the nodes that don't have a sibling in sorted order (Increasing).

Two nodes are said to be siblings if they are present at the same level, and their parents are the same.

Note: The root node can not have a sibling so it cannot be included in our answer.

Example 1:

Input :
       37
      /   
    20
    /     
  113 

Output: 
20 113
Explanation: 
Nodes 20 and 113 dont have any siblings.

Example 2:

Input :
       1
      / \
     2   3 

Output: 
-1
Explanation: 
Every node has a sibling.
Your Task:  
You don't need to read input or print anything. Complete the function noSibling() which takes the root of the tree as input parameter and returns a list of integers containing all the nodes that don't have a sibling in sorted order. If all nodes have a sibling, then the returning list should contain only one element -1.

Expected Time Complexity: O(nlogn)
Expected Auxiliary Space: O(Height of the tree)

Constraints:
1 ≤ n ≤ 104


*/
class Tree
{
    ArrayList<Integer> noSibling(Node node)
    {
        // code here
        
        ArrayList<Integer> arr=new ArrayList<>();

        dfs(node, arr);
        
        Collections.sort(arr);

        if(arr.isEmpty()) arr.add(-1);
        return arr;

    }
   void dfs(Node node, ArrayList<Integer> arr) {
        if (node == null) {
            return;
        }

        // Check if the node has only one child (no sibling)
        if (node.left == null && node.right != null) {
            arr.add(node.right.data);
        } else if (node.left != null && node.right == null) {
            arr.add(node.left.data);
        }

        // Traverse left and right subtrees recursively
        dfs(node.left, arr);
        dfs(node.right, arr);
    }
    
    
