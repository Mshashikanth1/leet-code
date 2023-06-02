/*
2101. Detonate the Maximum Bombs
Medium
1.6K
99
Companies

You are given a list of bombs. The range of a bomb is defined as the area where its effect can be felt. This area is in the shape of a circle with the center as the location of the bomb.

The bombs are represented by a 0-indexed 2D integer array bombs where bombs[i] = [xi, yi, ri]. xi and yi denote the X-coordinate and Y-coordinate of the location of the ith bomb, whereas ri denotes the radius of its range.

You may choose to detonate a single bomb. When a bomb is detonated, it will detonate all bombs that lie in its range. These bombs will further detonate the bombs that lie in their ranges.

Given the list of bombs, return the maximum number of bombs that can be detonated if you are allowed to detonate only one bomb.

 

Example 1:

Input: bombs = [[2,1,3],[6,1,4]]
Output: 2
Explanation:
The above figure shows the positions and ranges of the 2 bombs.
If we detonate the left bomb, the right bomb will not be affected.
But if we detonate the right bomb, both bombs will be detonated.
So the maximum bombs that can be detonated is max(1, 2) = 2.

Example 2:

Input: bombs = [[1,1,5],[10,10,5]]
Output: 1
Explanation:
Detonating either bomb will not detonate the other bomb, so the maximum number of bombs that can be detonated is 1.

Example 3:

Input: bombs = [[1,2,3],[2,3,1],[3,4,2],[4,5,3],[5,6,4]]
Output: 5
Explanation:
The best bomb to detonate is bomb 0 because:
- Bomb 0 detonates bombs 1 and 2. The red circle denotes the range of bomb 0.
- Bomb 2 detonates bomb 3. The blue circle denotes the range of bomb 2.
- Bomb 3 detonates bomb 4. The green circle denotes the range of bomb 3.
Thus all 5 bombs are detonated.

 

Constraints:

    1 <= bombs.length <= 100
    bombs[i].length == 3
    1 <= xi, yi, ri <= 105


 */
class Solution {
    public int maximumDetonation(int[][] bombs) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int n = bombs.length;

        // Build the graph
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                int xi = bombs[i][0], yi = bombs[i][1], ri = bombs[i][2];
                int xj = bombs[j][0], yj = bombs[j][1];

                // Create a path from node i to node j, if bomb i detonates bomb j.
                if ((long)ri * ri >= (long)(xi - xj) * (xi - xj) + (long)(yi - yj) * (yi - yj)) {
                    graph.computeIfAbsent(i, k -> new ArrayList<>()).add(j);
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            int count = dfs(i, new HashSet<>(), graph);
            answer = Math.max(answer, count);
        }

        return answer;
    }

    // DFS to get the number of nodes reachable from a given node cur
    private int dfs(int cur, Set<Integer> visited, Map<Integer, List<Integer>> graph) {
        visited.add(cur);
        int count = 1;
        for (int neib : graph.getOrDefault(cur, new ArrayList<>())) {
            if (!visited.contains(neib)) {
                count += dfs(neib, visited, graph);
            }
        }
        return count;
    }
}

/**
    LeetCode Logo

Problem List
Premium
62
DCC Badge
4.81
(16 votes)
Solution
Overview

We can transform the map of bombs into a graph by representing each bomb i as a node i in the same location. The equivalent of bomb 1 detonating bomb 2 is a directed edge from node 1 to node 2.

img

To determine whether bomb 1 detonates bomb 2, we can compare the Euclidean distance between their centers and the radius of bomb 1. If the distance is less than or equal to the radius of bomb 1, then bomb 1 can detonate bomb 2. Note that this relationship is not commutative: bomb 1 detonating bomb 2 does not necessarily imply the converse is also true.

img

distance2=(x1−x2)2+(y1−y2)2\text{distance}^2 = (x_1 - x_2)^2 + (y_1 - y_2)^2distance2=(x1​−x2​)2+(y1​−y2​)2

Therefore, the original problem can be transformed into a graph traversal problem where we calculate the total number of reachable nodes from each node i.

Starting with building the graph, we need to traverse each pair of two distinct bombs (i, j) to check if bomb i detonates bomb j. If so, we create a directed edge from node i to node j. We consider all different pairs of nodes, and note that two pairs of the same bombs in different orders are considered to be different. In short, we consider both (i, j) and (j, i).

img

Each of the following methods begins with the building process above.
Approach 1: Depth-First Search, Recursive
Intuition

    If you are not familiar with depth-first (DFS) search, please refer to our explore cards Depth-First Search Explore Card. We will focus on the usage in this article and not the implementation details.

In DFS, we explore nodes as far as possible along each branch. Upon reaching the end of the current branch, we backtrack to the next possible branch and continue exploring. Once we encounter an unvisited node, we take one of its neighbor nodes (if it exists) as the next node on this branch. Recursively call the function to the next node and solve the subproblem. If we reach the end of this branch, we backtrack to the previous node and visit the next neighbor node (if it exists), and repeat the process.

We can use a hash set visited to keep track of all the visited nodes. Initially, visited is empty. When we find an unvisited neighbor node, we can add it to visited so it won't be visited anymore.

At the end of the DFS, we can return the size of visited as the number of visited nodes (detonated bombs).

img

We will perform the DFS from each node and update answer as the maximum number of reachable nodes starting from each node.

Algorithm

    Initialize answer as 0.

    Create hash map graph containing all directed edges corresponding to the detonation relationships between all bombs.

    Create an empty hash set visited.

    Define a recursive function dfs(cur) to recursively find all reachable nodes from node cur:
        Add cur to visited.
        Recursively call dfs(neib) on each unvisited neighbor of cur.

    Repeat from step 3 for each node i and update answer as the maximum size of visited after each DFS.

    Return answer when all DFS operations are complete.

Implementation
Complexity Analysis

Let nnn be the number of bombs, so there are nnn nodes and at most n2n^2n2 edges in the equivalence graph.

    Time complexity: O(n3)O(n^3)O(n3)
        Building the graph takes O(n2)O(n^2)O(n2) time.
        The time complexity of a typical DFS is O(V+E)O(V + E)O(V+E) where VVV represents the number of nodes, and EEE represents the number of edges. More specifically, there are nnn nodes and n2n^2n2 edges in this problem.
            Each node is only visited once, which takes O(n)O(n)O(n) time.
            For each node, we may need to explore up to n−1n - 1n−1 edges to find all its neighbors. Since there are nnn nodes, the total number of edges we explore is at most n(n−1)=O(n2)n(n - 1) = O(n^2)n(n−1)=O(n2).
        We need to perform nnn depth-first searches.

    Space complexity: O(n2)O(n^2)O(n2)
        The space complexity of DFS is (n2)(n^2)(n2):
            There are O(n2)O(n^2)O(n2) edges stored in graph.
            We need to maintain a hash set that contains at most nnn visited nodes
            The call stack of dfs contains also takes nnn space.


Approach 2: Depth-First Search, Iterative
Intuition

We can also implement DFS iteratively using a stack to replicate recursive self-calls to dfs. Since the operations on a stack are performed in First In, Last Out (FILO) order. Therefore, the top node on the stack always leads to the next branch: whenever we reach the end of the current branch, we can get the node on the top of the stack and move along the branch that starts from it.

A hash set visited is used to store all the visited nodes, so we don't need to take them into account. Once we add an unvisited node to the stack, we immediately add it to visited to prevent it from being revisited later.

img

Similarly, we will perform the DFS from each node i, and update answer as the maximum number of reachable nodes starting from each node.

Algorithm

    Initialize answer as 0.

    Create a hash map graph containing all directed edges corresponding to the detonation relationships between all bombs.

    Define a function dfs(i) that iteratively finds all reachable nodes from node i.
        Initialize an empty stack stack and an empty hash set visited.
        Add i to stack and visited.
        While stack is not empty, pop up the top element cur.
        Check if cur has any unvisited neighbor nodes, and if so, add them to visited and stack and repeat the previous step.
        When the iteration is complete, return the size of visited.

    Call dfs on every node i and update answer as the maximum size of visited.

    Return answer when all DFS operations are complete.

Implementation
Complexity Analysis

Let nnn be the number of bombs, so there are nnn nodes and at most n2n^2n2 edges in the equivalence graph.

    Time complexity: O(n3)O(n^3)O(n3)
        The time complexity of a typical DFS is O(V+E)O(V + E)O(V+E) where VVV represents the number of nodes, and EEE represents the number of edges. More specifically, there are nnn nodes and n2n^2n2 edges in this problem.
            Building graph takes O(n2)O(n^2)O(n2) time.
            For each node, we may need to explore up to n−1n - 1n−1 edges to find all its neighbors. Since there are nnn nodes, the total number of edges we explore is at most n(n−1)=O(n2)n(n - 1) = O(n^2)n(n−1)=O(n2).
        We need to perform nnn breadth-first searches.

    Space complexity: O(n2)O(n^2)O(n2)
        We use a hash map to store all edges, which requires O(n2)O(n^2)O(n2) space.
        We use a hash set visited to record all visited nodes, which takes O(n)O(n)O(n) space.
        We use a stack stack to store all the nodes to be visited, and in the worst-case scenario, there may be O(n)O(n)O(n) nodes in stack.
        To sum up, the space complexity is O(n2)O(n^2)O(n2).


Approach 3: Breadth-First Search
Intuition

    If you are not familiar with breadth-first search, please refer to our explore cards Breadth-First Search Explore Card. We will focus on the usage in this article and not the implementation details.

In BFS, we explore the nodes in the order of their depth. Assuming that the starting node has a depth of 0, we will explore all nodes at the present depth (d) before moving on to all nodes at the next depth (d + 1).

Back to this problem, we start with node i with depth = 0, then we mark all its unvisited neighbor nodes with depth = 1 to be visited soon, once we visit a node with depth = 1, we mark all its unvisited neighbor nodes with depth = 2 as well.

We can use a queue as a container to store all nodes to be visited without mixing the order, and a hash set visited to store all visited nodes. When we enqueue a node, we immediately add it to visited, which prevents it from being enqueued again by other nodes later.

Once the BFS is complete, the number of visited nodes (denoted bombs) is the size of visited.

img

We will perform BFS from each node i and update answer as the maximum number of reachable nodes starting from each node.

Algorithm

    Initialize answer as 0.

    Create hash map graph containing all directed edges corresponding to the detonation relationships between all bombs.

    Define a function bfs(i) that finds all the reachable nodes from node i.
        Initialize an empty queue queue and an empty hash set visited.
        Add i to both queue and visited.
        While the queue is not empty, dequeue the fisrt node cur.
        Check if cur has any unvisited neighbor nodes, if so, enqueue them into queue, add them to visited, and repeat the previous step.
        Return the size of visited when the iteration is complete.

    Call bfs on every node i and update answer as the maximum size of visited after each BFS.

    Return answer when the all BFS operations are complete.

Implementation
Complexity Analysis

Let nnn be the number of bombs.

    Time complexity: O(n3)O(n^3)O(n3)
        In a typical BFS search, the time complexity is O(V+E)O(V + E)O(V+E) where VVV is the number of nodes and EEE is the number of edges. There are nnn nodes and at most n2n^2n2 edges in this problem.
            Building graph takes O(n2)O(n^2)O(n2) time.
            Each node is enqueued and dequeued once, it takes O(n)O(n)O(n) to handle all nodes.
            For each node, we may need to explore up to n−1n - 1n−1 edges to find all its neighbors. Since there are nnn nodes, the total number of edges we explore is at most n(n−1)=O(n2)n(n - 1) = O(n^2)n(n−1)=O(n2).
        We need to perform nnn breadth-first searches.

    Space complexity: O(n2)O(n^2)O(n2)
        There are at O(n2)O(n^2)O(n2) edges stored in graph.
        queue can store up to nnn nodes.


Comments (12)
💡 Article Commenting Rules

1. This comment section is for questions and comments regarding this LeetCode article. All posts must respect our LeetCode Community Rules.

2. Concerns about errors or bugs in the article, problem description, or test cases should be posted on LeetCode Feedback, so that our team can address them.
jayxray
Mar LeetCoding Challenge
8 hours ago

It is possible to improve the complexity to O(n^2) by first running Tarjan's Algorithm to find all SCCs, then performing a Topological Sort and DP.

EDIT: I was mistaken; this is not O(n^2) as there is a bottleneck in the last step: as we are operating on a DAG and not a tree, finding the sum of descendant weights is O(VE) = O(n^3) for any practical algorithm.
9
Show 9 Replies
Reply
JerExplosion
50 Days Badge 2022
8 hours ago

This problem has amazing applications in real life 😂
9
Show 3 Replies
Reply
shk10
Annual Badge 2022
8 hours ago

I did not find any mention of this in top rated posts so I would like to outline an optimized approach (O(n^2)).

Step 1: Build a directed graph. There is an edge from node i to node j if bomb i's circle covers bomb j's center.

With (h, k) center and r radius, circle region is given by: (x - h)^2 + (y - k)^2 <= r^2
So, G[i][j] = true/false basis (x[j] - x[i])^2 + (y[j] - y[i])^2 <= r[i]^2

// O(n) nodes, O(n^2) edges

Step 2: Find Strongly Connected Components (SCC) using one of the algorithms.

// O(V + E) = O(n + n^2) = O(n^2)

Step 3: Condense the graph i.e. replace each SCC by a single node with result (or weight) equal to number of nodes in its SCC.

Key idea: If each SCC is contracted to a single vertex, the resulting condensed graph is a directed acyclic graph (DAG).

// O(n) nodes, O(n^2) edges

Step 4: Do a topological sort of the condensed graph (DAG) and update result for each node by adding sum of result of its children nodes.

The maximum of result of all nodes is the answer we're looking for.

// O(V + E) = O(n + n^2) = O(n^2)
Read more
5
Show 7 Replies
Reply
Leon-Guo
50 Days Badge 2022
7 hours ago

If bomb A can detonates bomb B, that doesn't means bomb B can detonates bomb A vice verse, because the shorter arm can't touch the long distance
3
Reply
bharatchandra01
100 Days Badge 2022
2 hours ago

Can someone explain why we cannot use DP to memoize the recursive DFS calls?
0
Show 2 Replies
Reply
alexey_salzi
50 Days Badge 2022
2 hours ago

no idle runs on the bomb graph building side:

    for i, bomb in enumerate(bombs):
        x, y, r = bomb
        for k in range(i + 1, n):
            x_, y_, r_ = bombs[k]
            dist = (x - x_)**2 + (y - y_)**2
            if dist <= r**2:
                graph[i].append(k)
            if dist <= r_**2:
                graph[k].append(i)

Read more
0
Reply
ManojKumarPatnaik
100 Days Badge 2022
5 hours ago

    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        var adj = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<=n;i++)adj.add(new ArrayList<Integer>());
        //build graph
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int x1=bombs[i][0],y1=bombs[i][1],r1=bombs[i][2];
                int x2=bombs[j][0],y2=bombs[j][1],r2=bombs[j][2];
                long dist = ((long)(x1-x2)*(x1-x2) +(long) (y1-y2)*(y1-y2));
                if(dist<=(long)r1*r1) adj.get(i).add(j);
                if(dist<=(long)r2*r2) adj.get(j).add(i);
            }
        }
        int res=1;
        for(int i=0;i<n;i++) res=Math.max(res,dfs(i,adj,new int[n]));
        return res;
    }
    int dfs(int node,ArrayList<ArrayList<Integer>> adj,int set[]){
        if(set[node]==1) return 0;
        set[node]=1;
        int c=1;
        for(var ch:adj.get(node))  if(set[ch]==0)   c+=dfs(ch,adj,set);
        return c;
    }
}

Read more
0
Reply
vicky_1812
100 Days Badge 2022
5 hours ago

class Solution {
   int maximum=0;
   boolean checker(int a[],int b[]){
       double val=Math.pow(b[0]-a[0],2)+Math.pow(b[1]-a[1],2)-Math.pow(a[2],2);
       if(val<=0){
           return true;
       }
       return false;
   }
   public int maximumDetonation(int[][] bombs) {
       HashMap<Integer,ArrayList<Integer>> map=new HashMap<Integer,ArrayList<Integer>>();
       for(int i=0;i<bombs.length;i++){
           for(int j=i+1;j<bombs.length;j++){
               // System.out.println(Arrays.toString(bombs[i]));
               // System.out.println(Arrays.toString(bombs[j]));
               if(checker(bombs[i],bombs[j])){
                   if(map.containsKey(i)){
                       ArrayList<Integer> a=map.get(i);
                       a.add(j);
                       map.put(i,a);
                   }
                   else{
                       ArrayList<Integer> a=new ArrayList<>();
                       a.add(j);
                       map.put(i,a);
                   }
               }
               if(checker(bombs[j],bombs[i])){
                   if(map.containsKey(j)){
                       ArrayList<Integer> a=map.get(j);
                       a.add(i);
                       map.put(j,a);
                   }
                   else{
                       ArrayList<Integer> a=new ArrayList<>();
                       a.add(i);
                       map.put(j,a);
                   }
               }
           }
       }
       if(map.keySet().size()==0){
           return 1;
       }
       for(int k: map.keySet()){
           int sum=0;
            boolean visited[]=new boolean[bombs.length];
            Queue<Integer> q=new LinkedList<>();
            q.add(k);
            visited[k]=true;
            while(q.size()>0){
               int s=q.poll();
               sum++;
               if(map.containsKey(s)){
                   ArrayList<Integer> ak=map.get(s);
                   System.out.println(ak);
                   for(int i=0;i<ak.size();i++){
                       if(!visited[ak.get(i)]){
                           visited[ak.get(i)]=true;
                           q.add(ak.get(i));
                       }
                   }
               }
           }
           maximum=Math.max(sum,maximum);
       }
       // System.out.println(map);
       return maximum;
   }
}

Its give tle error even though its similar as the solution!. Where did i went wrong?
Read more
0
Reply
IgorKudrin
100 Days Badge 2022
6 hours ago

A few ideas to improve the runtime and memory usage.

    The bombs can be sorted by x, which makes it possible to significantly reduce the number of bombs we need to check for detonation,
    A parallel array of flags can be used to keep track of whether a particular bomb has been detonated in any of the previous sequences so that such bombs can be skipped when starting a new sequence; they can't give a better count than a sequence that has detonated them.

As a result, much fewer attempts are needed to check all bombs and there is no need to create a separate representation of the graph at all.

Here is my solution:

use std::collections::HashSet;

impl Solution {
    pub fn maximum_detonation(mut bombs: Vec<Vec<i32>>) -> i32 {
        let n = bombs.len();
        bombs.sort_unstable_by_key(|b| b[0]);
        let mut flags = vec![false; n];

        let mut result = 0;
        for i in 0..n {
            if flags[i] { continue; }
            let mut wq = vec![i];
            let mut visited = HashSet::new();
            visited.insert(i);
            flags[i] = true;
            while let Some(b) = wq.pop() {
                let (x, y, r) = (bombs[b][0], bombs[b][1], bombs[b][2]);
                let begin = bombs.partition_point(|b| b[0] < x - r);
                let end = bombs.partition_point(|b| b[0] <= x + r);
                let (x, y, r) = (x as i64, y as i64, r as i64);
                let r2 = r * r;
                for nb in begin..end {
                    let (nx, ny) = (bombs[nb][0] as i64, bombs[nb][1] as i64);
                    let d2 = (nx - x) * (nx - x) + (ny - y) * (ny - y);
                    if d2 > r2 { continue; }
                    if !visited.insert(nb) { continue; }
                    flags[nb] = true;
                    wq.push(nb);
                }
            }
            result = result.max(visited.len());
        }
        result as i32
    }
}

Read more
0
Reply
hardcoredummmy
Apr LeetCoding Challenge
7 hours ago

It's amazing that the standard solution is just O(n3) lol - thought leetcode still got some magic tricks this time
0
Reply
42
43
44
45
46
47
48
49
50
51
52
53
54
55
56
57
58
59
60
61
62
63
64
65
66
67
68
69
70
71
72
73
74
75
76
77
78
79
80
81
82
83
84
85
86
87
88

Detonate the Maximum Bombs - LeetCode



class Solution {
    public int maximumDetonation(int[][] bombs) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int n = bombs.length;

        // Build the graph
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                int xi = bombs[i][0], yi = bombs[i][1], ri = bombs[i][2];
                int xj = bombs[j][0], yj = bombs[j][1];

                // Create a path from node i to node j, if bomb i detonates bomb j.
                if ((long)ri * ri >= (long)(xi - xj) * (xi - xj) + (long)(yi - yj) * (yi - yj)) {
                    graph.computeIfAbsent(i, k -> new ArrayList<>()).add(j);
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            int count = dfs(i, new HashSet<>(), graph);
            answer = Math.max(answer, count);
        }

        return answer;
    }

    // DFS to get the number of nodes reachable from a given node cur
    private int dfs(int cur, Set<Integer> visited, Map<Integer, List<Integer>> graph) {
        visited.add(cur);
        int count = 1;
        for (int neib : graph.getOrDefault(cur, new ArrayList<>())) {
            if (!visited.contains(neib)) {
                count += dfs(neib, visited, graph);
            }
        }
        return count;
    }
}
 */
