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
    public List<TreeNode> allPossibleBST(int start,int end,Map<Pair<Integer,Integer>,List<TreeNode>> memo){

        List<TreeNode> res = new ArrayList<>();
        if(start>end){
            res.add(null);
            return res;
        }

        if(memo.containsKey(new Pair<>(start, end))){
            return memo.get(new Pair<>(start, end));
        }

        for(int i=start; i<=end; ++i){
            List<TreeNode> leftSubTrees = allPossibleBST(start,i-1,memo);
            List<TreeNode> rightSubTrees= allPossibleBST(i+1,end,memo);

            for( TreeNode left: leftSubTrees){
                for( TreeNode right: rightSubTrees){
                    TreeNode root= new TreeNode(i,left,right);
                    res.add(root);
                }
            }
        }
        memo.put(new Pair<>(start,end),res);
        return res;

    }
    public List<TreeNode> generateTrees(int n) {
        Map<Pair<Integer,Integer>, List<TreeNode>> memo= new HashMap<>();
        return allPossibleBST(1,n,memo);
        
    }
}

/*
95. Unique Binary Search Trees II
Medium
6.9K
445
Companies

Given an integer n, return all the structurally unique BST's (binary search trees), which has exactly n nodes of unique values from 1 to n. Return the answer in any order.

 

Example 1:

Input: n = 3
Output: [[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]

Example 2:

Input: n = 1
Output: [[1]]

 

Constraints:

    1 <= n <= 8

Accepted
394.1K
Submissions
716.1K
Acceptance Rate
55.0%
Seen this question in a real interview before?
1/4
Yes
No
Discussion (39)
Similar Questions
Unique Binary Search Trees
Medium
Different Ways to Add Parentheses
Medium
Related Topics

Solution
Overview

Given an integer n, our task is to return all unique BSTs (binary search trees) that have exactly n nodes of unique values from 1 to n.
Approach 1: Recursive Dynamic Programming
Intuition

In each node of a binary search tree (BST), all values in the left subtree are smaller and all values in the right subtree are greater.

To find all the possible permutations of BSTs with n nodes, we can lock one node as the root node and split n - 1 nodes between the left and right subtrees in all the possible ways. Let's say we place a node with value i as the root node and place i - 1 nodes having values from 1 to i - 1 in the left subtree. (If i == 1, the left child is null). Similarly, we place the remaining n - i nodes having values from i + 1 to n in the right subtree. (If i == n, the right child is null).

Now, we create a list of nodes called leftSubTrees for all the possible BSTs that could be the left subtree. Similarly, we create a list of nodes called rightSubTrees for all the BSTs that could be the right subtree.

    In a BST, every subtree is also a BST.

We iterate over both the lists and for each node pair l in leftSubTrees and r in rightSubTrees, we create a new root node with value i and set the left and right child of root to l and r respectively to form all the BSTs with the root node as i.

We can iterate over the root's value from i = 1 to n and repeat the process for each root value to get all the BSTs.

You may notice that the subproblem of finding the arrays leftSubTrees and rightSubTrees are similar to the original problem. We can implement this approach using recursion as we are breaking down a problem with n nodes to smaller, repetitive subproblems with i - 1 and n - i nodes (for i = 1 till n) to compute the answer for n nodes. We only need the range of node values as the parameters to create the BSTs with nodes having values in that range.

We implement a recursive function allPossibleBST(start, end) where start and end correspond to the range of node values that should be present in the BSTs created by this call. For a root node with value i, we will find all the left subtrees using leftSubTrees = allPossibleBST(start, i - 1) and also compute all the right subtrees using rightSubTrees = allPossibleBST(i + 1, right). Finally, we iterate over all pairs between leftSubTrees and rightSubTrees and create a new root with value i for each pair.

The base case of this function is when start > end. We have no values in our range and thus we will return null (an empty tree).

Here is a visual representation of the recursion tree with 3 nodes:

img

Several subproblems, such as allPossibleBST(1, 1), allPossibleBST(3, 3), etc., are solved multiple times in the small partial recursion tree shown above. If we draw the entire recursion tree, we can see that there are many subproblems that are solved repeatedly.

To avoid this issue, we store the solution of the subproblem in a hashmap that stores the mapping from a range of nodes values to the list of root nodes of all possible BSTs that can be formed with the same number of nodes. When we encounter the same subproblem again, we simply refer to this map to get the required list of TreeNode. This is called memoization.
Algorithm

    Create a hash map memo where memo[(start, end)] contains the list of root nodes of all possible BSTs with the range of node values from start to end.
    We implement a recursive function allPossibleBST which takes the starting range of node values start, ending range end, and memo as parameters. It returns a list of TreeNode corresponding to all the BSTs that can be formed with this range of node values. We call allPossibleBST(1, n, memo) and perform the following:
        We declare a list of TreeNode called res to store the list of root nodes of all possible BSTs.
        If start > end, we push null to res and return it.
        If we already have solved this subproblem, i.e., memo contains the pair (start, end), we return memo[(start, end)].
        Select the root node value from i = start to end incrementing i by 1 after each iteration. We recursively call leftSubtrees = llPossibleBST(start, i - 1, memo) and rightSubTrees = allPossibleBST(i + 1, end, memo). We iterate over all pairs between leftSubtrees and rightSubTrees and create a new root with value i for each pair. We push root of the new formed BST into res.
        Set memo[(start, end)] = res and return res.

Implementation
Complexity Analysis

Note, the time and space complexity of this problem is difficult to derive. In an interview, you should do your best to find an upper bound. The level of analysis here would not be expected in an interview.

The number of unique BSTs that can be formed with n nodes is G(n)G(n)G(n) where G(n)G(n)G(n) is the nthn^{th}nth Catalan number. G(n)=O(4nn1.5)G(n) = O(\dfrac{4^{n}}{n^{1.5}})G(n)=O(n1.54n​).

    Time complexity: O(4nn)O(\dfrac{4^n}{\sqrt{n}})O(n

​4n​).

    There are G(n)=4nn1.5G(n) = \dfrac{4^n}{n^{1.5}}G(n)=n1.54n​ BSTs in our answer. Each of these BSTs has nnn nodes, so it cost us O(n)O(n)O(n) to build each one. This gives us a time complexity of O(n⋅G(n))=O(4nn)O(n \cdot G(n)) = O(\dfrac{4^n}{\sqrt{n}})O(n⋅G(n))=O(n

    ​4n​).

Space complexity: O(∑k=1n[(n−k+1)⋅4kk])O(\sum_{k=1}^{n}{[(n - k + 1) \cdot \dfrac{4^k}{\sqrt{k}}]})O(∑k=1n​[(n−k+1)⋅k

​4k​]).

We use some space for the recursion call stack, but the majority of the space used by the algorithm is storing the lists of BSTs in memo. Let's analyze how many nodes are stored in memo.

The number of nodes in a range start, end is end - start + 1. Let k=end−start+1k = \text{end} - \text{start} + 1k=end−start+1 represent this formula.

There are nnn states start, end with one node, that is k=1k = 1k=1.

There are n−1n - 1n−1 states start, end with two nodes, that is k=2k = 2k=2.

There are n−2n - 2n−2 states start, end with three nodes, that is k=3k = 3k=3.

This continues until there is only one state with nnn nodes (the original input). In general, a value of kkk has n−k+1n - k + 1n−k+1 states.

For a given state with value kkk, there are G(k)=4kk1.5G(k) = \dfrac{4^k}{k^{1.5}}G(k)=k1.54k​ BSTs. Each of these BSTs has kkk nodes, and thus takes up k⋅G(k)=4kkk \cdot G(k) = \dfrac{4^k}{\sqrt{k}}k⋅G(k)=k

​4k​ space in memo.

A given value kkk has n−k+1n - k + 1n−k+1 states and thus takes up (n−k+1)⋅4kk(n - k + 1) \cdot \dfrac{4^k}{\sqrt{k}}(n−k+1)⋅k

​4k​ space. In our algorithm, kkk ranges from 111 to nnn.

The space complexity is the summation for all values of kkk:

∑k=1n[(n−k+1)⋅4kk]\Large{\sum_{k=1}^{n}{[(n - k + 1) \cdot \dfrac{4^k}{\sqrt{k}}]}}∑k=1n​[(n−k+1)⋅k

    ​4k​]

    This is a difficult sum to compute and involves higher-level mathematics. Using a program like WolframAlpha, we find that the sum is equal to:

    41+n⋅Φ(4,−0.5,1+n)−41+n⋅(1+n)⋅Φ(4,0.5,1+n)−Li−0.5(4)+Li0.5(4)+n⋅Li0.5(4)4^{1 + n} \cdot \Phi(4, -0.5, 1 + n) - 4^{1 + n} \cdot (1 + n) \cdot \Phi(4, 0.5, 1 + n) - \text{Li}_{-0.5}(4) + \text{Li}_{0.5}(4) + n \cdot \text{Li}_{0.5}(4)41+n⋅Φ(4,−0.5,1+n)−41+n⋅(1+n)⋅Φ(4,0.5,1+n)−Li−0.5​(4)+Li0.5​(4)+n⋅Li0.5​(4)

    Where Φ\PhiΦ is the Lerch transcendent and Lin(x)\text{Li}_n(x)Lin​(x) is the polylogarithm function. Needless to say, computing this sum by hand is not necessary in an interview. Even reaching the summation expression would likely impress any interviewer.

Approach 2: Iterative Dynamic Programming
Intuition

We used memoization in the preceding approach to store the answers to subproblems in order to solve a larger problem. We can also use a bottom-up approach to solve such problems without using recursion. We build answers to subproblems iteratively first, then use them to build answers to larger problems.

We create a 3D list dp[n + 1][n + 1] where dp[i][j] will store a list of all BSTs that have node values ranging from i to j. Note that dp[i][j] = allPossibleBST(i, j) from the previous approach.

When i = j, the range contains only one node with value i. We push a single node with value i in the list dp[i][i] for all the values of i from 1 to n. This acts as the base case of our solution while we move in bottom to top manner.

We form the answer with a smaller number of nodes having consecutive node values and move on to form answers for a bigger number of nodes. We run an outer loop from numberOfNodes = 2 to numberOfNodes = n incrementing numberOfNodes by 1 after each iteration. This loop controls the total number of nodes under consideration.

We further need to choose a node value we start with. Let's call it start. As we have numberOfNodes nodes under consideration with consecutive values, the maximum node value in such a BST would be end = start + numberOfNodes - 1. We will move start from 1 to n - numberOfNodes + 1.

Now we have the start value and the end value, we can implement the same logic that we did in the allPossibleBST function from the previous approach. Lock a value i, find all left and right subtrees, and then iterate over each left, right pair and create a new root with value i for each pair.

As we move from bottom to top, we will have a list of all the root nodes for all BSTs for every range of node values with lesser nodes.

Locking a value i as the root node, we can find all left subtrees in dp[start][i - 1] and all right subtrees in dp[i + 1][end]. If i == start, the left subtree would be empty. Similarly, if i == end, the right subtree would be empty. We can handle these cases separately.

We run an outer loop from numberOfNodes = 2 to n. We run an inner loop that selects the starting node value. It runs from start = 1 to n - numberOfNodes + 1. We define end = start + numberOfNodes - 1. We run a third nested loop that selects the root of the BSTs under consideration. It runs from i = start to end.

We then iterate over the both the lists of left and right subtrees. For each root node l of the left subtree and r of the right subtree, we create a new root node with value i and set the left and right child to l and r respectively to form all the BSTs with root node as i. We also push each BST into dp[start][end] to be used later to build answer for other dp states with larger number of nodes.
Algorithm

    Create a 3D list dp[n + 1][n + 1] where dp[i][j] will store a list of root nodes for all possible BSTs using j - i + 1 nodes with values from i to j nodes.
    We initialize each list dp[i][i] to a TreeNode having value i for i = 0 to n.
    Iterate from numberOfNodes = 2 till numberOfNodes = n incrementing numberOfNodes by 1 after each iteration. We start an inner loop from start = 1 to n - numberOfNodes + 1 incrementing start by 1. We create an integer variable end = start + numberOfNodes - 1 which stores the highest node value of the BSTs that will be formed. We run another loop from i = start to end to use all the permutations as the root node value. We perform the following in this loop:
        We create a list of TreeNode called leftSubtrees which will store all the BSTs that can be formed with node values from start to i - 1. If i == start, we just add null to leftSubtrees, else leftSubtrees == dp[start][i - 1].
        Similarly, we create a list of TreeNode called rightSubtrees which will store all the BSTs that can be formed with node values from i + 1 to end. If i == end, we just add null to rightSubtrees, else rightSubtrees == dp[i + 1][end].
        We form a new BST by creating a new node which acts as a root node with value i. For each element left in leftSubtrees and right in rightSubtrees, we set root.left = left and root.right = right. Finally, we add root to dp[start][end].
    Return dp[1][n].

Implementation
Complexity Analysis

    Time complexity: O(4nn)O(\dfrac{4^n}{\sqrt{n}})O(n

​4n​).

    The time complexity of this approach will be similar to the time complexity of the first approach because we are iterating over the same dp states in bottom-up manner as compared to the previous approach where we used top-down approach with memoization.

Space complexity: O(∑k=1n[(n−k+1)⋅4kk])O(\sum_{k=1}^{n}{[(n - k + 1) \cdot \dfrac{4^k}{\sqrt{k}}]})O(∑k=1n​[(n−k+1)⋅k

    ​4k​]).
        The space complexity would also be the number of BSTs stored in the dp list which is equal to the number of BSTs stored in memo in the worst-case. Hence, we have the same space complexity as the first approach.

Approach 3: Dynamic Programming with Space Optimization
Intuition

We used a 3D list where we used dp[start][end] to store all the BSTs having end - start + 1 nodes with range from start to end. Let's think if we can reduce the 3D dp list to a 2D list.

If we compare all the BSTs that can be created from a set of consecutive values from start to end to those that can be created with the same number of nodes from a set of values starting at 1 and ending at end - start + 1, we will find that the structure of all the BSTs created with the above two ranges would be identical. The only difference is an offset of start - 1 in the node values.

Here's a visual representation of BSTs with 3 nodes from range [1, 3] and all BSTs with range [4, 6]:

img

We can see the structure of all the BSTs created with the above two ranges are identical.

So, we can just store the BSTs for all the ranges starting from 1 and add the offset to convert them to required ranges.

We create a 2D list dp[n + 1] where dp[i] will store a list of all BSTs with i nodes having values from 1 to i. dp[n] would be the answer to the problem. Similar to the above approach, we will move in bottom to top manner.

We push a null node (empty tree) to dp[0] which acts as the base case.

To get the list of root nodes for all possible BSTs with numberOfNodes nodes, we would split the numberOfNodes nodes with i - 1 nodes with values 1 to i - 1 in the left subtree, a root node with value i and the remaining numberOfNodes - i nodes with values i + 1 to numberOfNodes in the right subtree where 1 <= i <= numberOfNodes. Note that we do not need the starting of the range here, unlike the previous approach. It is always 1.

As we are executing in bottom-up manner and figuring out the answer for numberOfNodes nodes, we will already have the list of root nodes for all BSTs with i - 1 and numberOfNodes - i nodes (for all values of i = 1 to numberOfNodes).

However, you may realize that dp[i - 1] will give all the BSTs having values from 1 to i - 1 which is exactly what we want but dp[numberOfNodes - i] will give all the BSTs having values from 1 to numberOfNodes - i which isn't what we want. We want the right subtree to have numberOfNodes - i nodes but the range of nodes should be from i + 1 to numberOfNodes. If we add the offset (i + 1) - 1 = i to all the nodes, it would solve this as we would now have trees with numberOfNodes - i nodes from values i + 1 to numberOfNodes. Let us form the BSTs now.

Similar to the previous approach, we create a new instance of TreeNode called root with the value i. We set the left child of root to an element in dp[i - 1].

Now, let's set the right child of root. We know every element in dp[numberOfNodes - i] is a root node that stores a BST with numberOfNodes - 1 nodes having values from 1 to numberOfodes - i. To set the right child of root, we create a new tree exactly similar to the tree stored by an element of dp[numberOfNodes - i] but increment all the node values of the new tree by i. We then set the right child of root to this newer tree.

The required tree with i offset can be created by using a recursive function clone in which we pass a TreeNode node which corresponds to an element in dp[numberOfNodes - i] and an integer offset. We create a new TreeNode clonedNode with value node.val + offset. We then recursively set the left and the right child of clonedNode by performing clonedNode.left = clone(node.left, offset) and clonedNode.right = clone(node.right, offset). Finally, return clonedNode.

It is important to note that we are creating new trees to set the right child of root to preserve the original trees as it might be used directly (as dp[i - 1]) in some other iteration of i and numberOfNodes.
Algorithm

    Create a list dp[n + 1] where dp[i] will store a list of root nodes for all possible BSTs using i nodes. We initialize each list dp[i] to an empty list for i = 0 to n.
    We push a null node (empty tree) into dp[0] because with n = 0 we can't have any BST. This forms the base case.
    Iterate from numberOfNodes = 1 till numberOfNodes = n incrementing numberOfNodes by 1 after each iteration. We start an inner loop from i = 1 to numberOfNodes incrementing i by 1. We perform the following in this loop:
        Create a variable j = numberOfNodes - i - 1. It presents the number of nodes in the right subtree under consideration.
        We can form a new BST by creating a new node which acts as a root node with value i. We assign its left child to any element in dp[i] and right child to a new tree where tree is similar to an element in dp[j] but all node values are incremented by i. As a result, we need two loops to iterate through the lists dp[i] and dp[j]. We create a new root node with value i. For each element left in dp[i] and right in dp[j], we set root.left = left and root.right = clone(right, i). Finally, we add root to dp[numberOfNodes].
    Return dp[n].

Implementation
Complexity Analysis

    Time complexity: O(4nn)O(\dfrac{4^n}{\sqrt{n}})O(n

​4n​).

    In this approach we are not storing all the BSTs with all the ranges. We are just storing BSTs starting from range 1. However, we are creating all the BSTs for all the ranges from [start, end] (for 1 <= start, end <= 1) using the clone method by iterating over the BSTs starting with range 1.
    As a result, the time complexity should be similar to the previous approach as we are generating the same number of BSTs.

Space complexity: O(∑k=1n4kk)O(\sum_{k=1}^{n}\dfrac{4^k}{{\sqrt{k}}})O(∑k=1n​k

​4k​).

    For any state dp[k], we are storing all the BSTs that can be formed with kkk nodes. We know there are G(k)G(k)G(k) BSTs that can be formed with kkk nodes. As we have 111 to nnn states, the total space consumed would be O(∑k=1nk⋅G(k))O(\sum_{k=1}^{n} k \cdot G(k))O(∑k=1n​k⋅G(k)) = O(∑k=1n4kk)O(\sum_{k=1}^{n}\dfrac{4^k}{{\sqrt{k}}})O(∑k=1n​k

        ​4k​).

Comments (32)
 */
