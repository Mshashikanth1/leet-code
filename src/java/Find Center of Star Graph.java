class Solution {
    public int findCenter(int[][] edges) {
        Map<Integer, Integer> fmap= new HashMap<>();
        int maxCount= Integer.MIN_VALUE, center=-1;
        for( int[] edge : edges){

            Integer count1 = fmap.getOrDefault(edge[0],0)+1,
                    count2= fmap.getOrDefault(edge[1],0)+1;
            if( count1 > maxCount) {
                maxCount=count1;
                center=edge[0];
            }else if( count2 > maxCount ) {
                maxCount=count2;
                center= edge[1];
            }

            fmap.put(edge[0] ,count1);
            fmap.put(edge[1] ,count2);

        }
        return center;

    }
}

/**
1791. Find Center of Star Graph
Solved
Easy
Topics
Companies
Hint
There is an undirected star graph consisting of n nodes labeled from 1 to n. A star graph is a graph where there is one center node and exactly n - 1 edges that connect the center node with every other node.

You are given a 2D integer array edges where each edges[i] = [ui, vi] indicates that there is an edge between the nodes ui and vi. Return the center of the given star graph.

 

Example 1:


Input: edges = [[1,2],[2,3],[4,2]]
Output: 2
Explanation: As shown in the figure above, node 2 is connected to every other node, so 2 is the center.
Example 2:

Input: edges = [[1,2],[5,1],[1,3],[1,4]]
Output: 1
 

Constraints:

3 <= n <= 105
edges.length == n - 1
edges[i].length == 2
1 <= ui, vi <= n
ui != vi
The given edges represent a valid star graph.

 */
