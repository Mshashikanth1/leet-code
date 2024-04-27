//64. Minimum Path Sum.java
//problem :https://leetcode.com/problems/minimum-path-sum/solutions/
class Solution {
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
       
        //first column minimumdistance
        for(int i=1;i<n;i++){
            grid[0][i]+=grid[0][i-1];
        }
 
        //first row minimumdistance
        for(int j=1;j<m;j++){
            grid[j][0]+=grid[j-1][0];
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                grid[i][j]+=Math.min(grid[i-1][j],grid[i][j-1]);
            }

        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                System.out.print(grid[i][j]+",");
            }
                            System.out.println();

        }
        return grid[m-1][n-1];
        
    }
}
