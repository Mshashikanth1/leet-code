/*

971. Find if Path Exists in Graph.java
Easy
2.9K
146
Companies

There is a bi-directional graph with n vertices, where each vertex is labeled from 0 to n - 1 (inclusive). The edges in the graph are represented as a 2D integer array edges, where each edges[i] = [ui, vi] denotes a bi-directional edge between vertex ui and vertex vi. Every vertex pair is connected by at most one edge, and no vertex has an edge to itself.

You want to determine if there is a valid path that exists from vertex source to vertex destination.

Given edges and the integers n, source, and destination, return true if there is a valid path from source to destination, or false otherwise.

 

Example 1:

Input: n = 3, edges = [[0,1],[1,2],[2,0]], source = 0, destination = 2
Output: true
Explanation: There are two paths from vertex 0 to vertex 2:
- 0 → 1 → 2
- 0 → 2

Example 2:

Input: n = 6, edges = [[0,1],[0,2],[3,5],[5,4],[4,3]], source = 0, destination = 5
Output: false
Explanation: There is no path from vertex 0 to vertex 5.

 

Constraints:

    1 <= n <= 2 * 105
    0 <= edges.length <= 2 * 105
    edges[i].length == 2
    0 <= ui, vi <= n - 1
    ui != vi
    0 <= source, destination <= n - 1
    There are no duplicate edges.
    There are no self edges.


 */
class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
         UnionFind uf=new UnionFind(n);
           
           for(int[] edge : edges){
               uf.union(edge[0],edge[1]);
           }
        //    for(int i : uf.root)
        //    System.out.print(i+",");

        //     System.out.println("");

        //    for(int j: uf.rank)
        //    System.out.print(j+",");

          return uf.isConnected(source,destination)
            &&
           this.BFS(n,edges,source,destination)
            &&
           this.DFS_ITR(n,edges,source,destination)
           &&
           DFS(n,edges,source,destination);
           
        
    }
//Appraoch 1
/**
BFS 
1.initialize an empty queue to store the nodes to ve visited
2.use one boolean array seen to mark all visited nodes and has map to stored all edges
3.add the starting node 0 to queue and mark it as visited
4. if queue has nodes , ge the fisr node curr_node from queue . return true if curr_node is destination, other vise got to setep 5.
5. Add all unvisited neighbor nodes of current_node to queue and mark them as visited, then repeat step 4.
6. if we emptied queue without finding destination, return false.

 complexity complexity Analysis:
let n be the number of nodes and m be the number of edges
.Time complexity:O(n+m):

in a typical bfs search , the time complexity is O(V+E) where v is the nuber of vertices and E is the number of edges . there are n nodes and m edges in this problems 
 we build adjacent list of all m edgs in graph which takes O(m)

 each node is added to the queue and popped from queue once it takes on(n) to handel all nodes
 time complexity : O(n+m)

 space complexity O(n+m)
 .. we used a hashmap neightbors to store all edges, which requiere O(m) space for m edges.
 ... we use seen, either a hash set or an array to record the visited nodes, which takes O(n space)
 there for the space complexity is O(n+m);

 */

    public boolean BFS(int n, int[][] edges, int source, int destination){
        
            Queue<Integer> queue=new PriorityQueue<>();
            Boolean[] seen =new Boolean[n];
            Arrays.fill(seen,false);
            Map<Integer,List<Integer>> graph= new HashMap<>();

            for(int[] edge : edges){
                int a=edge[0],b=edge[1];
                graph.computeIfAbsent(a,val->new ArrayList<Integer>()).add(b);
                graph.computeIfAbsent(b,val->new ArrayList<Integer>()).add(a);
            }

            queue.offer(source);
            seen[source]=true;

            while(!queue.isEmpty()){
                int currNode=queue.poll();
                if(currNode==destination){
                    return true;
                }

                for(int nextNode: graph.get(currNode)){
                    if(!seen[nextNode]){
                        seen[nextNode]=true;
                        queue.offer(nextNode);
                    }
                }
            }


            return false;

    }


//Approach 2 DFS 
/*
Algorithm :
1.use boolean array seen to mark all the visited nodes set seen[source]=true;
2. use a hashmap graph to store all edges.
3. start the search for node source. if the current node are we visiteng (curr_node ) equla s destination, return true. otherwise find all its neghbor nodes that haven;t been visited before
if there exixts such a neightbor , mark it as visited, move on to this node and repeat step 3.
if this neighbor node can reach destination, then return true, other wise , try nexit neighbor, 
return false if we finished the search without finding desination.

 */

private boolean DFS(int n, int[][] edges , int source, int destination){
        boolean[] seen=new boolean[n];
        Arrays.fill(seen,false);

        Map<Integer,List<Integer>> graph=new HashMap<>();
        for(int[] edge: edges){
            int a=edge[0],b=edge[1];
            graph.computeIfAbsent(a,val->new ArrayList<Integer>()).add(b);
            graph.computeIfAbsent(b,val->new ArrayList<Integer>()).add(a);
        }

        return DFS_REC(graph,source,destination,seen);

}

private boolean DFS_REC(Map<Integer,List<Integer>> graph, int source, int destination, boolean[] seen){
        if(source==destination) return true;
        
        if(!seen[source]){
            seen[source]=true;
        for(int neighbor : graph.get(source)){
             if(DFS_REC(graph,neighbor,destination,seen)) return true;
            }
        }
        return false;
 }



//Approach 3 DFS Iterative

private boolean DFS_ITR(int n, int[][] edges, int source, int destination){
        Stack<Integer> stack =new Stack<>();
        boolean[] seen=new boolean[n];
        Arrays.fill(seen,false);
        Map<Integer,List<Integer>> graph=new HashMap<>();

        for(int[] edge : edges){
            int a=edge[0],b=edge[1];
            graph.computeIfAbsent(a,val->new ArrayList<Integer>()).add(b);
            graph.computeIfAbsent(b,val->new ArrayList<Integer>()).add(a);
        }

        stack.push(source);
        seen[source]=true;

        while(!stack.isEmpty()){
            int curr_node=stack.pop();
            if(curr_node==destination){return true;}

            for(int neighbor : graph.get(curr_node)){
                if(!seen[neighbor]){
                stack.push(neighbor);
                seen[neighbor]=true;
                }
            }
        }

        return false;

}

//Approach 4 Union Find
class UnionFind{
      int[] root;
      int[] rank;
      private UnionFind(int n){
         this.root= new int[n];
         this.rank=new int[n];
        for(int i=0;i<n;i++){
               this.root[i]=i;
              this.rank[i]=1;
           }

      }

    public int find(int x){
        if(x!=this.root[x]){
           this.root[x]=find(this.root[x]);
        }
        return this.root[x];
    }
    public void union(int x, int y){
        int rootX=find(x);
        int rootY=find(y);
        if(rootX!=rootY){
            if(this.rank[rootX]>this.rank[rootY]){
                int temp=rootX;
                rootX=rootY;
                rootY=temp;
            }
            this.root[rootX]=rootY;
           this.rank[rootY]+=this.rank[rootX];
        }
    }

    public boolean isConnected(int x, int y){
        return find(x)==find(y);
    }
}
}
