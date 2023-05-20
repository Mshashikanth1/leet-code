/*
399. Evaluate Division
Medium
7.1K
633
Companies

You are given an array of variable pairs equations and an array of real numbers values, where equations[i] = [Ai, Bi] and values[i] represent the equation Ai / Bi = values[i]. Each Ai or Bi is a string that represents a single variable.

You are also given some queries, where queries[j] = [Cj, Dj] represents the jth query where you must find the answer for Cj / Dj = ?.

Return the answers to all queries. If a single answer cannot be determined, return -1.0.

Note: The input is always valid. You may assume that evaluating the queries will not result in division by zero and that there is no contradiction.

 

Example 1:

Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
Explanation: 
Given: a / b = 2.0, b / c = 3.0
queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
return: [6.0, 0.5, -1.0, 1.0, -1.0 ]

Example 2:

Input: equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
Output: [3.75000,0.40000,5.00000,0.20000]

Example 3:

Input: equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["a","c"],["x","y"]]
Output: [0.50000,2.00000,-1.00000,-1.00000]

 

Constraints:

    1 <= equations.length <= 20
    equations[i].length == 2
    1 <= Ai.length, Bi.length <= 5
    values.length == equations.length
    0.0 < values[i] <= 20.0
    1 <= queries.length <= 20
    queries[i].length == 2
    1 <= Cj.length, Dj.length <= 5
    Ai, Bi, Cj, Dj consist of lower case English letters and digits.


 */
class Solution {
  Map<String, Map<String, Double>> map = new HashMap<>();
  Set<String> seen = new HashSet<>();

  private double dfs(String s, String target, double num) {
    if (!map.containsKey(s)) return -1.0;
    if (s.equals(target)) return num;
    seen.add(s);

    if (map.get(s).containsKey(target))
      return num * map.get(s).get(target);

    for (var div : map.get(s).entrySet()) {
      if (!seen.contains(div.getKey())) {
        var ans = dfs(div.getKey(), target, div.getValue());

        if (ans != -1) return num * ans;
      }
    }
    return -1.0;
  }

  public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
    var n = queries.size();
    var ans = new double[n];

    for (var i=0; i < equations.size(); i++) {
      if (!map.containsKey(equations.get(i).get(0)))
        map.put(equations.get(i).get(0), new HashMap<>());

      if (!map.containsKey(equations.get(i).get(1)))
        map.put(equations.get(i).get(1), new HashMap<>());

      map.get(equations.get(i).get(0)).put(equations.get(i).get(1), values[i]);
      map.get(equations.get(i).get(1)).put(equations.get(i).get(0), 1 / values[i]);
    }
    for (var i=0; i<n; i++) {
      seen.clear();
      ans[i] = dfs(queries.get(i).get(0), queries.get(i).get(1), 1.0);
    }
    return ans;
  }
}
