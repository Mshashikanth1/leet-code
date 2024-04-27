
class Solution {

    int numberOfEnclaves(int[][] grid) {

        // Your code here
        int n=grid.length, m=grid[0].length, count=0;
        
        for(int i=0;i<n;i++){
            if(grid[i][0]==1) dfs(grid,i,0,n,m);
            if(grid[i][m-1]==1) dfs(grid,i,m-1,n,m);
        }
        
        for(int j=0;j<m;j++){
            if(grid[0][j]==1) dfs(grid,0,j,n,m);
            if(grid[n-1][j]==1) dfs(grid,n-1,j,n,m);
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                count+=grid[i][j];
            }
        }
        
        return count;
    }
    
    int[] dx=new int[]{-1,0,0,1};
    int[] dy=new int[]{0,-1,1,0};
    void dfs(int[][] grid, int i, int j, int n, int m){
        grid[i][j]=0;
        for(int d=0;d<4;d++){
            int x=i+dx[d], y=j+dy[d];
            if(x>=0 && x<n && y>=0 && y<m && grid[x][y]==1){
                dfs(grid,x,y,n,m);
            }
        }
        
    }
}


/*

Number Of Enclaves
MediumAccuracy: 50.93%Submissions: 48K+Points: 4
Win 2X Geekbits, Get on the Leaderboard & Top the Coding Charts! Register for GFG Weekly Coding Contest

banner
You are given an n x m binary matrix grid, where 0 represents a sea cell and 1 represents a land cell.

A move consists of walking from one land cell to another adjacent (4-directionally) land cell or walking off the boundary of the grid.

Find the number of land cells in grid for which we cannot walk off the boundary of the grid in any number of moves.

Example 1:

Input:
grid[][] = {{0, 0, 0, 0},
            {1, 0, 1, 0},
            {0, 1, 1, 0},
            {0, 0, 0, 0}}
Output:
3
Explanation:
0 0 0 0
1 0 1 0
0 1 1 0
0 0 0 0
The highlighted cells represents the land cells.
Example 2:

Input:
grid[][] = {{0, 0, 0, 1},
            {0, 1, 1, 0},
            {0, 1, 1, 0},
            {0, 0, 0, 1},
            {0, 1, 1, 0}}
Output:
4
Explanation:
0 0 0 1
0 1 1 0
0 1 1 0
0 0 0 1
0 1 1 0
The highlighted cells represents the land cells.
Your Task:

You don't need to print or input anything. Complete the function numberOfEnclaves() which takes a 2D integer matrix grid as the input parameter and returns an integer, denoting the number of land cells.

Expected Time Complexity: O(n * m)

Expected Space Complexity: O(n * m)

Constraints:

1 <= n, m <= 500
grid[i][j] == 0 or 1

*/
