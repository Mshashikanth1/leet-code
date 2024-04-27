class Solution {
    
    /**Time : O(n) Space :O(n) */
    static int[] dx=new int[]{0,1,0,-1},dy=new int[]{1,0,-1,0};
    public static int islandPerimeter(int[][] grid) {
        Set<String> visited =new HashSet<>();
        int islands=0,maxPeri=0;

        int r=grid.length, c=grid[0].length;
        for(int i=0; i<r; i++){
            for(int j=0;j <c; j++){
                int[] res=dfs(grid,visited,i,j,r,c);
                islands+=res[1];
                maxPeri=Math.max(res[0],maxPeri);
            }
        }
        return maxPeri;
    }


    public static int[] dfs(int[][] grid, Set<String> visited, int i, int j,int r,int c){
        String ij=i+","+j;
        if(grid[i][j]==0 || visited.contains(ij)) return new int[2];

        int peri=0;

        Stack<int[]> stack=new Stack<>();
        stack.push(new int[]{i,j});
        visited.add(i+","+j);


        while(!stack.isEmpty()){
            int[] p=stack.pop();
            peri+=findPeriCurrCell(p,grid,r,c);

            for(int ind=0; ind<4; ind++){
                int ix=p[0]+dx[ind], iy=p[1]+dy[ind];
                String ixiy = ix+","+iy;
                if(!visited.contains(ixiy) && (ix>=0 && ix<r) && (iy>=0 && iy<c) && grid[ix][iy]==1){
                    visited.add(ixiy);
                    stack.push(new int[]{ix,iy});
                }
            }

        }
        return new int[]{peri,1};
    }


    public static int findPeriCurrCell(int[] p, int[][] grind,int r, int c){
     int cc=4;
     for(int ind=0; ind<4; ind++) {
            int ix = p[0] + dx[ind],iy = p[1] + dy[ind];
            if ( (ix>=0 && ix<r) && (iy>=0 && iy<c) &&  grind[ix][iy] == 1) {
                    cc--;
            }
        }
     return cc;
    }


}


/**
463. Island Perimeter
Solved
Easy
Topics
Companies
You are given row x col grid representing a map where grid[i][j] = 1 represents land and grid[i][j] = 0 represents water.

Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).

The island doesn't have "lakes", meaning the water inside isn't connected to the water around the island. One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.

 

Example 1:


Input: grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
Output: 16
Explanation: The perimeter is the 16 yellow stripes in the image above.
Example 2:

Input: grid = [[1]]
Output: 4
Example 3:

Input: grid = [[1,0]]
Output: 4
 

Constraints:

row == grid.length
col == grid[i].length
1 <= row, col <= 100
grid[i][j] is 0 or 1.
There is exactly one island in grid.
 */
