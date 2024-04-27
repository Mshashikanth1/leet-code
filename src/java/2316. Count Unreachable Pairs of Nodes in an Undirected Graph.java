//2316. Count Unreachable Pairs of Nodes in an Undirected Graph.java
//problem : https://leetcode.com/problems/count-unreachable-pairs-of-nodes-in-an-undirected-graph/editorial/
/*
Depth first search --> graph and tree traversal algorithm or technique
a depth first seach traversal is used to determine the number of nodes in each component

in recursive function to expore nodes as far as possible along each branch unon reaching the end of branch , we back track to the previous node and continue exploring the next branhes

total unreachable pairs;
if i have total number of disconnected componets lets say k[a,b,c......]
whenre a,b,c .. are length's of the disconnected graphs then total number of unreachable pairs are
as follows up are ;
total number of nodes = n
for i in k:
    up+=i*(n-i)
    n-=i;
 */
class Solution {
    public int dfs(int node, Map<Integer,List<Integer>>adj,boolean[] visited){
        int count=1;
        visited[node]=true;
        if(!adj.containsKey(node)){
            return count;
        }
        for(int neighbor : adj.get(node)){
            if(!visited[neighbor]){
                count+=dfs(neighbor, adj, visited);
            }
        }
        return count;

    }

    public long countPairs(int n, int[][] edges) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for(int[] edge: edges){
            adj.computeIfAbsent(edge[0],k->new ArrayList<Integer>()).add(edge[1]);
            adj.computeIfAbsent(edge[1],k->new ArrayList<Integer>()).add(edge[0]);
        }
        long numberOfPairs=0;
        long sizeOfComponent=0;
        long remainingNodes=n;
        boolean[] visited= new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
                sizeOfComponent=dfs(i,adj,visited);
                // System.out.println("bye bye! component :".concat())
                numberOfPairs+=sizeOfComponent*(remainingNodes-sizeOfComponent);
                remainingNodes-=sizeOfComponent;
            }
        }
        return numberOfPairs;

        
    }
}
