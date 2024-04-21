class Solution {

    static int[] parent;
    public boolean validPath(int n, int[][] edges, int source, int destination) {

        /* 
        //modify the edges graph to adj. list
        Map<Integer,List<Integer>> adjList=new HashMap<>();
        for(int[] edge:edges){
            List<Integer> lis1=adjList.getOrDefault(edge[1],new ArrayList<>());
            List<Integer> lis0=adjList.getOrDefault(edge[0],new ArrayList<>());

            lis1.add(edge[0]);
            lis0.add(edge[1]);

            adjList.put(edge[1],lis1);
            adjList.put(edge[0],lis0);
        }

        Set<Integer> visited=new HashSet<>();

    
        // perform dfs recursive
         return recDfs( visited, adjList, source,destination);
            //  perform dfs iterative
         return rec( visited, adjList, source,destination);
            //  perform bfs
         return recDfs( visited, adjList, source,destination);

         */

        
        // initialize the parents array for disjointset/union find data strucure
        parent=new int[n];
        for(int i=0;i<n;i++) parent[i]=i;

        //union all the relations
        for(int[] edge: edges) union(edge[0],edge[1]);

        //check if the source and destination are int same set
        return checkWeatherInSameSet(source,destination);

    }

    public void union(int i, int j){
         int iRep=find(i), jRep=find(j);
         parent[iRep]=jRep;
    }

    public boolean checkWeatherInSameSet(int i, int j){
        return find(i)==find(j);
    }
    //Time : O(n) Space O(n)
    public int find(int i){
        if(parent[i]==i) return i;
        parent[i]=find(parent[i]);
        return  parent[i];
    }
   
   
    //time : O(n) space : O(n) + O(n) explicit stack sapce
    public boolean dfs(Set<Integer> visited, Map<Integer,List<Integer>> adjList, int source, int destination){
        
        if(source==destination) return true;
        //create a stack add source it and visited 
        Stack<Integer> stack=new Stack<>();
        stack.add(source);
        visited.add(source);

        while(!stack.isEmpty()){

            int pop= stack.pop();

            //push all the neighbours to the stack & mark visited
            for(int neighbour: adjList.get(pop)){
                if(!visited.contains(neighbour)){
                    stack.add(neighbour);
                    visited.add(neighbour);
                }
                //if you encounter destination then imediately return true
                if(neighbour==destination) return true;
            }
        }

        // if the dfs is cmpleted the function is still not exited then we don't find the path'
        return false;
    }

 
    //time : O(n) space : O(n) + implicit stack sapce
    public  static boolean recDfs(Set<Integer> visited, Map<Integer,List<Integer>> adjList, int source, int destination){
        if(source==destination) return true;

        visited.add(source);
        boolean ans=false;
        for(int neighbour : adjList.get(source)){
            if(!visited.contains(neighbour)){
                ans|= recDfs(visited,adjList,neighbour,destination);
            }
        };
        return ans;
    }

    //time : O(n) space :O(n) : queue 
 public static boolean bfs(Set<Integer> visited, Map<Integer,List<Integer>> adjList, int source, int destination){
        if(source==destination) return true;
        
        //create a queue for bfs & start form visiting source node first
        Queue<Integer> queue=new LinkedList<>();
        queue.offer(source);
        visited.add(source);

        while (!queue.isEmpty()){
            int poll=queue.poll();
            for(int neighbour: adjList.get(poll)){
                if(!visited.contains(neighbour)) {
                    queue.offer(neighbour);
                    visited.add(neighbour);
                }

                if(destination==neighbour ) return true;
            }

        }
        return false;

    }


}

/**
1971. Find if Path Exists in Graph
Solved
Easy
Topics
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
