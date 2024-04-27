//1020. Number of Enclaves.java
//problem : https://leetcode.com/problems/number-of-enclaves/editorial/
class Solution {
    public void dfs(int[][] grid, int i, int j,int rows,int cols,boolean[][] visited){

        if(i<0 || j<0 || i>=rows || j>=cols || grid[i][j]==0 || visited[i][j]){return;}


        visited[i][j]=true; //mark the cell as visited
        
        //top
        dfs(grid,i-1,j,rows,cols,visited);
        ///bottom
        dfs(grid,i+1,j,rows,cols,visited);
        //left
        dfs(grid,i,j-1,rows,cols,visited);
        //right
        dfs(grid,i,j+1,rows,cols,visited);

        return;
    }

    public int numEnclaves(int[][] grid) {
        int rows=grid.length, cols=grid[0].length, count=0;
        boolean[][] visited= new boolean [rows][cols];

        for(int i=0;i<rows;i++){
            //firstColumn 
            if(grid[i][0]==1 && !visited[i][0]){
                dfs(grid,i,0,rows,cols,visited);
            }
            //lastColumn
            if(grid[i][cols-1]==1 && !visited[i][cols-1]){
                dfs(grid,i, cols-1, rows,cols,visited);
            }
        }

        for(int i=0;i<cols;i++){
            //fisrt row
            if(grid[0][i]==1 && !visited[0][i]){
                dfs(grid,0,i,rows,cols,visited);
            }

            //last row
            if(grid[rows-1][i]==1 && !visited[rows-1][i]){
                dfs(grid,rows-1,i,rows,cols,visited);
            }

        }

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==1 && !visited[i][j]){
                    count++;
                }
            }
        }
        System.out.println(count);
        return count;
    }
}
