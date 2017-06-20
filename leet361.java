public class Solution {
    public int maxKilledEnemies(char[][] grid) {
        if(grid == null || grid.length == 0 ||  grid[0].length == 0) return 0;
        int[] col = new int[grid[0].length];
        int max = 0;
        int row = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='W') continue;
                //new row
                if(j==0||grid[i][j-1]=='W'){
                    row = getRowKills(grid,i,j);
                }
                //new col
                if(i==0||grid[i-1][j]=='W'){
                    col[j] = getColKills(grid,i,j);
                }
                if(grid[i][j]=='0'){
                    max = Math.max(row+col[j],max);
                }
                
            }
        }
        return max;
    }
    public int getRowKills(char[][]grid,int i,int j){
        int res = 0;
        while(j<grid[0].length&&grid[i][j]!='W'){
            if(grid[i][j]=='E'){
                res++;
            }
            j++;
        }
        return res;
    }
    public int getColKills(char[][]grid,int i,int j){
        int res = 0;
        while(i<grid.length&&grid[i][j]!='W'){
            if(grid[i][j]=='E'){
                res++;
            }
            i++;
        }
        return res;
    }
}