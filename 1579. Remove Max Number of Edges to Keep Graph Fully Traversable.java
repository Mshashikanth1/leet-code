/*

1579. Remove Max Number of Edges to Keep Graph Fully Traversable
Hard
1.4K
19
Companies

Alice and Bob have an undirected graph of n nodes and three types of edges:

    Type 1: Can be traversed by Alice only.
    Type 2: Can be traversed by Bob only.
    Type 3: Can be traversed by both Alice and Bob.

Given an array edges where edges[i] = [typei, ui, vi] represents a bidirectional edge of type typei between nodes ui and vi, find the maximum number of edges you can remove so that after removing the edges, the graph can still be fully traversed by both Alice and Bob. The graph is fully traversed by Alice and Bob if starting from any node, they can reach all other nodes.

Return the maximum number of edges you can remove, or return -1 if Alice and Bob cannot fully traverse the graph.

 

Example 1:

Input: n = 4, edges = [[3,1,2],[3,2,3],[1,1,3],[1,2,4],[1,1,2],[2,3,4]]
Output: 2
Explanation: If we remove the 2 edges [1,1,2] and [1,1,3]. The graph will still be fully traversable by Alice and Bob. Removing any additional edge will not make it so. So the maximum number of edges we can remove is 2.

Example 2:

Input: n = 4, edges = [[3,1,2],[3,2,3],[1,1,4],[2,1,4]]
Output: 0
Explanation: Notice that removing any edge will not make the graph fully traversable by Alice and Bob.

Example 3:

Input: n = 4, edges = [[3,2,3],[1,1,2],[2,3,4]]
Output: -1
Explanation: In the current graph, Alice cannot reach node 4 from the other nodes. Likewise, Bob cannot reach 1. Therefore it's impossible to make the graph fully traversable.

 

 

Constraints:

    1 <= n <= 105
    1 <= edges.length <= min(105, 3 * n * (n - 1) / 2)
    edges[i].length == 3
    1 <= typei <= 3
    1 <= ui < vi <= n
    All tuples (typei, ui, vi) are distinct.


DSU DISJOINT SET UNIONS ALGORITHM / DATA STRUCTURE

1. create  a class UnionFInd , this will have the relevent data members and member functions to perfrom DSU operations
            a.Data Member representative stores the immediate parent of nodes in the union find structure , initially each node will be it's own representattive'
            b.Data member componentSize stores the number of nodes in thte components with the nodes as the root node, inititally the size of components for each node is 1;
            c.Data member components stores the number of components in the graph, initially it will be equal to N as each node is considedred as seperate component
            d.method findRepresentative() return the root node in the representative hierarchy
            e.method performUnion() , return 1 after performing the union between the components og the two nodes that we not connected, berfore , other wise 0;
            f.method isConnected return true if the graph is connected i.e components=1

2.create a UnionFind obj. for both ALice and Bob with N nodes

3. intialize edgesRequired to 0

4. perform usinion of all edges of type 3, for both alice and bob , and fore each edgesin crement ht evalud of edgesRequired if for any of them performUnion() return 1

5. perfrom union of all edges of type 1 & 2 for alice or bob resepectively and increment the redges required if for any of them perfomr Union return 1

6. if isConnected() return true for both alice and bob , then return TotalEdges-edgesRequired, othe rwise return -1;


 */
// class Solution {
//     public int maxNumEdgesToRemove(int n, int[][] edges) {
//         //different obj. for alic and bob
//         UnionFind Alice=new UnionFind(n);
//         UnionFind Bob=new UnionFind(n);

//         int edgesRequired=0;

//         //perform union for edgs of type =3 for Alice and BOB
//         for(int[] edge: edges){
//                 if(edge[0]==3){
//                     edgesRequired+=(Alice.performUnion(edge[1],edge[2]) | 
//                     Bob.performUnion(edge[1],edge[2]));
//                 }
//             }


//         //perfrom union for Alice if type ==1 and for bob if type =2
//         for(int[] edge : edges){
//             if(edge[0]==1){
//                 edgesRequired+=Alice.performUnion(edge[1],edge[2]);
//             }
//             else if(edge[0]==2){
//                 edgesRequired+=Bob.performUnion(edge[1],edge[2]);
//             }
//         }

//         if(Alice.isConnected() && Bob.isConnected()){
//             return edges.length-edgesRequired;
//         }
//         return -1;

//     }

// class UnionFind{
//       int[] representative;
//       int[] componentSize;
//       int components;

//       private UnionFind(int n){
//           representative=new int[n+1];
//           componentSize=new int[n+1];
//           components=n;

//           for(int i=0;i<=n;i++){
//               representative[i]=i;
//               componentSize[i]=1;
//           }
//       }

//       public int findRepresentative(int x){
//           if(representative[x]==x) 
//           return x;

//             //path compression
//           return representative[x]=findRepresentative(representative[x]);

//       }


//       public int performUnion(int x, int y){
//           int rx=findRepresentative(x),ry=findRepresentative(y);
//           if(rx==ry) return 0;
//           if(componentSize[x]>componentSize[y]){

//               componentSize[x]+=componentSize[y];
//               representative[y]=x;
//           }
//           else{
//               componentSize[y]+=componentSize[x];
//               representative[x]=y;
//           }
//           components--;
//           return 1;


//       }
      
//       //retrun true if all nodes get merged to one
//       public boolean isConnected(){return this.components==1;}



// }
// }
class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        // Different objects for Alice and Bob.
        UnionFind Alice = new UnionFind(n);
        UnionFind Bob = new UnionFind(n);

        int edgesRequired = 0;
        // Perform union for edges of type = 3, for both Alice and Bob.
        for (int[] edge : edges) {
            if (edge[0] == 3) {
                edgesRequired += (Alice.performUnion(edge[1], edge[2]) | Bob.performUnion(edge[1], edge[2]));
            }
        }

        // Perform union for Alice if type = 1 and for Bob if type = 2.
        for (int[] edge : edges) {
            if (edge[0] == 1) {
                edgesRequired += Alice.performUnion(edge[1], edge[2]);
            } else if (edge[0] == 2) {
                edgesRequired += Bob.performUnion(edge[1], edge[2]);
            }
        }

        // Check if the Graphs for Alice and Bob have n - 1 edges or is a single component.
        if (Alice.isConnected() && Bob.isConnected()) {
            return edges.length - edgesRequired;
        }
        
        return -1;
    }

    private class UnionFind {
        int[] representative;
        int[] componentSize;
        // Number of distinct components in the graph.
        int components;

        // Initialize the list representative and componentSize
        // Each node is representative of itself with size 1.
        public UnionFind(int n) {
            components = n;
            representative = new int[n + 1];
            componentSize = new int[n + 1];

            for (int i = 0; i <= n; i++) {
                representative[i] = i;
                componentSize[i] = 1;
            }
        }

        // Get the root of a node.
        int findRepresentative(int x) {
            if (representative[x] == x) {
                return x;
            }

            // Path compression.
            return representative[x] = findRepresentative(representative[x]);
        }
        
        // Perform the union of two components that belongs to node x and node y.
        int performUnion(int x, int y) {       
            x = findRepresentative(x); y = findRepresentative(y);

            if (x == y) {
                return 0;
            }

            if (componentSize[x] > componentSize[y]) {
                componentSize[x] += componentSize[y];
                representative[y] = x;
            } else {
                componentSize[y] += componentSize[x];
                representative[x] = y;
            }

            components--;
            return 1;
        }

        // Returns true if all nodes get merged to one.
        boolean isConnected() {
            return components == 1;
        }
    }
}
