/** 
787. Cheapest Flights Within K Stops
Solved
Medium
Topics
Companies
There are n cities connected by some number of flights. You are given an array flights where flights[i] = [fromi, toi, pricei] indicates that there is a flight from city fromi to city toi with cost pricei.

You are also given three integers src, dst, and k, return the cheapest price from src to dst with at most k stops. If there is no such route, return -1.

 

Example 1:


Input: n = 4, flights = [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]], src = 0, dst = 3, k = 1
Output: 700
Explanation:
The graph is shown above.
The optimal path with at most 1 stop from city 0 to 3 is marked in red and has cost 100 + 600 = 700.
Note that the path through cities [0,1,2,3] is cheaper but is invalid because it uses 2 stops.
Example 2:


Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 1
Output: 200
Explanation:
The graph is shown above.
The optimal path with at most 1 stop from city 0 to 2 is marked in red and has cost 100 + 100 = 200.
Example 3:


Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 0
Output: 500
Explanation:
The graph is shown above.
The optimal path with no stops from city 0 to 2 is marked in red and has cost 500.
 

Constraints:

1 <= n <= 100
0 <= flights.length <= (n * (n - 1) / 2)
flights[i].length == 3
0 <= fromi, toi < n
fromi != toi
1 <= pricei <= 104
There will not be any multiple flights between two cities.
0 <= src, dst, k < n
src != dst
Seen this question in a real interview before?
1/4
Yes
No
Accepted
494.3K
Submissions
1.3M
Acceptance Rate
38.5%
Topics
Companies
Similar Questions
Discussion (118)
Type comment here... (Markdown supported)

Choose a type
Preview
Comment
💡 Discussion Rules
1. Please don't post any solutions in this discussion.

2. The problem discussion is for asking questions about the problem or for sharing tips - anything except for solutions.

3. If you'd like to share your solution for feedback and ideas, please head to the solutions tab and post it there.


Sort by:Best

code__HARD
Knight
11 hours ago
A good variation on dijkstra problem.
Here the first parameter is not the shortest dist its the less no of stops.
Unless you notice this you mess up around.
You can not stop when reaching the final_dest you need to keep on traversing until the queue is empty.

0
Reply

leeten__1500
50 Days Badge 2024
12 hours ago
acceptance rate less than 40 is always hard and gives headache

0
Reply

_UdayRaj_
50 Days Badge 2024
12 hours ago
streak breaker 😭

0
Reply

saket72
50 Days Badge 2023
12 hours ago
feels like dijkstra's but i haven't studied anything except bfs and dfs in graphs yet. about time, i guess.

0
Reply

raj_g07
50 Days Badge 2024
13 hours ago
Hint 🧠 BFS with some condition , nothing else
<<>>

0
Reply

Vansh_Rana_611
100 Days Badge 2023
13 hours ago
Got TLE on my Bruteforce Approach, PLZ HELP
https://leetcode.com/problems/cheapest-flights-within-k-stops/submissions/1183617207?envType=daily-question&envId=2024-02-23

Ask Question
0
Show 1 Replies
Reply

JiayingGao
Annual Badge 2023
14 hours ago
Just use bfs and queue to solve it. And then, the regular queue can be replaced to an priority queue to give an optimization (yes it is Dijkstra).

0
Reply

mslinCoder
Dec LeetCoding Challenge
14 hours ago
You can solve this problem using the Bellman-Ford algorithm.

Tip
0
Reply

vijayanvishnu
Knight
15 hours ago
Hint : With k no need to consider for graph cycle

Tip
0
Reply

PhilipSanM
100 Days Badge 2023
15 hours ago
lol my dfs just got TLE, hopping it passes...
*/
import java.util.*;

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int[] flight : flights) {
            adj.computeIfAbsent(flight[0], key -> new ArrayList<>()).add(new int[] {flight[1], flight[2]});
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {src, 0});
        int stops = 0;

        while (!q.isEmpty() && stops <= k) {
            int sz = q.size();
            while (sz-- > 0) {
                int[] curr = q.poll();
                int node = curr[0];
                int distance = curr[1];

                if (!adj.containsKey(node)) continue;

                for (int[] next : adj.get(node)) {
                    int neighbour = next[0];
                    int price = next[1];
                    if (price + distance >= dist[neighbour]) continue;
                    dist[neighbour] = price + distance;
                    q.offer(new int[] {neighbour, dist[neighbour]});
                }
            }
            stops++;
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}
