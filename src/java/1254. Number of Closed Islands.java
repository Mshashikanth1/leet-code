//1254. Number of Closed Islands.java
//prooblem :https://leetcode.com/problems/number-of-closed-islands/description/
class Solution {
    public boolean dfs(int[][] grid , int i, int j){
        int rows=grid.length, col=grid[0].length;
        if(i<0 || j<0 || i>=rows || j>=col ){
            return false;
        }
        if(grid[i][j]==1){return true;}
        grid[i][j]=1; //mark it as visited;
        
        boolean left=dfs(grid,i+1,j);
        boolean right=dfs(grid,i-1,j);
        boolean top=dfs(grid,i,j-1);
        boolean bottom=dfs(grid,i,j+1);

        return left && right && top && bottom;

    }
    public int closedIsland(int[][] grid) {
        int rows=grid.length, col=grid[0].length,count=0;

        //performing dfs on each cell
        for(int i=0;i<rows;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==0 && dfs(grid,i,j)){
                    count++;
                }
            }
        }
        return count;
    }
}
