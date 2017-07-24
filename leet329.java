public class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length==0){
            return 0;
        }
        int m = matrix[0].length;
        int n = matrix.length;
        //System.out.println("m= "+m+"n= "+n);
        int[][] mark = new int[n][m];
        int maxLength = 0;
        int[][] direct = {{1,0},{-1,0},{0,1},{0,-1}};
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                maxLength = Math.max(maxLength,dfs(matrix,mark,i,j,direct));
            }
        }
        return maxLength;
    }
    public int dfs(int[][]matrix, int[][] mark, int x, int y, int[][] direct){
        int n = matrix.length;
        int m = matrix[0].length;
        int max = 1;
        //System.out.println("x= "+x+"y= "+y);
        if(mark[x][y]!=0){
            return mark[x][y];
        }
        for(int[] dir : direct){
            int current = matrix[x][y];
             //System.out.println("nexy x= "+(x+dir[0])+"y= "+(y+dir[1]));
            if(x+dir[0]<0||x+dir[0]>=n||y+dir[1]<0||y+dir[1]>=m||matrix[x+dir[0]][y+dir[1]]>=matrix[x][y]) continue;
            int len = 1 + dfs(matrix, mark, x+dir[0],y+dir[1],direct);
            max = Math.max(len,max);
        }
        mark[x][y] = max;
        return max;
    }
}