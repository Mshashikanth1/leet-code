class Solution {


    /**Time : O(n) Space O(n) */
    public int numIslands(char[][] grid) {
        int islands=0;
        Set<String> visited=new HashSet<>();
        int r=grid.length,c=grid[0].length;
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                islands+=dfs(grid, i,  j,  r,  c, visited);
            }
        }
        return islands;
    }

    static int[] dx=new int[]{0,1,0,-1} , dy=new int[]{1,0,-1,0};
    public int dfs(char[][] grid ,int i, int j, int r, int c,Set<String> visited ){
        String ij= i+","+j;
        if(visited.contains(ij) || grid[i][j]=='0') return 0;

        Stack<int[]> stack =new Stack<>();
        visited.add(ij);
        stack.push(new int[]{i,j});

        while(!stack.isEmpty()){
            int[] ijarr= stack.pop();

            for(int k=0; k<4; k++){
                int dxi=ijarr[0] + dx[k] ,dyj=ijarr[1]+dy[k];

                String dxij= dxi+","+dyj;
                if(!visited.contains(dxij) && (dxi >=0 && dxi<r) && (dyj>=0 && dyj<c) && grid[dxi][dyj]=='1'){
                   stack.push(new int[]{dxi,dyj});
                   visited.add(dxij);
                }
            }
        }

        return 1;
    }
}

/**

200. Number of Islands
Solved
Medium
Topics
Companies
Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

 

Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 300
grid[i][j] is '0' or '1'.
 */
