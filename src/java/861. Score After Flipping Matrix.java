class Solution {

    /**Time :  O(m*n)  Space :O(1)*/
    public int matrixScore(int[][] grid) {
        int r=grid.length, c= grid[0].length;

        for(int i=0; i<r; i++){
            if(grid[i][0]==0) flipRow(grid, i); 
        }

        for(int i=1; i<c; i++ ){
            int zc=0, oc=0;
            for(int j=0; j<r; j++){
                if(grid[j][i]==0) zc++;
                else oc++;
            }
            if(zc > oc)  flipCol(grid, i);
        }


        int ans=0;
        for(int[] row: grid){
            StringBuilder sb=new StringBuilder();
            for(int i: row) sb.append(i);
          ans+= Integer.parseInt(sb.toString(), 2);

        }
       return ans;

    }

    public void flipRow(int[][] grid, int r){
        for(int i=0; i<grid[0].length; i++){
           grid[r][i]= grid[r][i]==1? 0:1;  
        }
    }

    public void flipCol(int[][] grid, int c){
        for(int i=0; i<grid.length; i++){
           grid[i][c]= grid[i][c]==1? 0:1;  
        }
    }
}

/**
861. Score After Flipping Matrix
Solved
Medium
Topics
Companies
You are given an m x n binary matrix grid.

A move consists of choosing any row or column and toggling each value in that row or column (i.e., changing all 0's to 1's, and all 1's to 0's).

Every row of the matrix is interpreted as a binary number, and the score of the matrix is the sum of these numbers.

Return the highest possible score after making any number of moves (including zero moves).

 

Example 1:


Input: grid = [[0,0,1,1],[1,0,1,0],[1,1,0,0]]
Output: 39
Explanation: 0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39
Example 2:

Input: grid = [[0]]
Output: 1
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 20
grid[i][j] is either 0 or 1.
 */
