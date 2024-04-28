// class Solution {
//     public int[] sumOfDistancesInTree1(int n, int[][] edges) {
//             Map<Integer,List<Integer>> adjList=new HashMap<>();
//             for(int[] edge: edges){

//                 List<Integer> lis1= adjList.getOrDefault(edge[0],new ArrayList<>());
//                 lis1.add(edge[1]);
//                 List<Integer> lis2= adjList.getOrDefault(edge[1],new ArrayList<>());
//                 lis1.add(edge[0]);

//                 adjList.put(edge[0],lis1);
//                 adjList.put(edge[1],lis2);
//             }

//             int[] ans=new int[adjList.size()];


//             for(int i=0; i<ans.length; i++){
//                 for(int j=0; j<ans.length; j++){
//                     ans[i]+=dfs(adjList,i,j,0);
//                 }
//             }
//             return ans;
//     }


//     public int dfs( Map<Integer,List<Integer>> adjList, int src, int dest, int dis){
//         Stack<int[]> stack=new Stack<>();
//         Set<Integer> visited=new HashSet<>();

//         stack.push(new int[]{src,dis});
//         visited.add(src);

//         while(!stack.isEmpty()){
//         int[] pop =stack.pop();
         
//         for(int i : adjList.get(pop[0])){
//             if(!visited.contains(i)) {
//                stack.push(new int[]{i,pop[1]+1});
//                visited.add(i);
//                if(i==dest) return pop[1]+1;
//             }
//          }
      
//         }
//         return 0;
//     }


//     int N;
//     public int[] sumOfDistancesInTree(int n, int[][] edges) {
//             Map<Integer,List<Integer>> adjList=new HashMap<>();
//             this.N=n;
//             for(int[] edge: edges){

//                 List<Integer> lis1= adjList.getOrDefault(edge[0],new ArrayList<>());
//                 lis1.add(edge[1]);
//                 List<Integer> lis2= adjList.getOrDefault(edge[1],new ArrayList<>());
//                 lis1.add(edge[0]);

//                 adjList.put(edge[0],lis1);
//                 adjList.put(edge[1],lis2);
//             }

//             int[] ans=new int[n], count=new int[n];
//             Arrays.fill(count,1);

//             dfs(adjList,ans,count,0,-1);
//             dfs2(adjList,ans,count,0,-1);
//             return ans;
//     }

//     public void dfs(Map<Integer,List<Integer>> adjList,int[] ans, int[] count, int node, int parent ){
//         for(int child : adjList.getOrDefault(node,new ArrayList<>())){
//             if(child!=parent){
//               dfs(adjList,ans,count,child,node);
//               count[node] +=count[child];
//               ans[node] += ans[child] +count[child];
//             }
//         }
//     }

//     public void dfs2(Map<Integer,List<Integer>> adjList, int[] ans, int[] count, int node, int parent){
//         for(int child: adjList.getOrDefault(node,new ArrayList<>())){
//             if(child!=parent){
//                 ans[child] =ans[node]+N -2*count[child];
//             dfs2(adjList,ans,count,child,node);
//             }
//         }
//     }
// }

// /*
// 0 -> [0,1,1,2,2,2]
// 1 -> [1,0,2,3,3,3]
// 2 -> [1,2,0,1,1,1]
// 3 -> [2,3,1,0,2,2]
// 4 -> [2,3,1,2,0,2]
// 5 -> []

// */


class Solution {
    int[] ans, count;
    List<Set<Integer>> graph;
    int N;
    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        this.N = N;
        graph = new ArrayList<Set<Integer>>();
        ans = new int[N];
        count = new int[N];
        Arrays.fill(count, 1);

        for (int i = 0; i < N; ++i)
            graph.add(new HashSet<Integer>());
        for (int[] edge: edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        dfs(0, -1);
        dfs2(0, -1);
        return ans;
    }

    public void dfs(int node, int parent) {
        for (int child: graph.get(node))
            if (child != parent) {
                dfs(child, node);
                count[node] += count[child];
                ans[node] += ans[child] + count[child];
            }
    }

    public void dfs2(int node, int parent) {
        for (int child: graph.get(node))
            if (child != parent) {
                ans[child] = ans[node] - count[child] + N - count[child];
                dfs2(child, node);
            }
    }
}