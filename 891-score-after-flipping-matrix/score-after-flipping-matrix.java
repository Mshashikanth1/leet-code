class Solution {
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