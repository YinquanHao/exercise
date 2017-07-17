public class Solution {
    public int shortestDistance(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int [][] res = new int[row][col];
        int [][] dis = new int [row][col];
        int num = 0;
        for(int m=0;m<row;m++){
            for(int n=0;n<col;n++){
                if(grid[m][n]==1){
                    num++;
                    Queue<int[]> queue = new LinkedList<int[]>();
                    boolean [][] vis = new boolean[row][col];
                    queue.offer(new int[]{m,n});
                    int val =1;
                    while(!queue.isEmpty()){
                        int queueSize = queue.size();
                            for(int k = queueSize;k>0;k--){
                                int[] removed = queue.poll();
                                int i = removed[0];
                                int j = removed[1];
                                if(j+1<col&&grid[i][j+1]==0&&vis[i][j+1]==false){
                                    queue.offer(new int[]{i,j+1});
                                    dis[i][j+1] += val;
                                    vis[i][j+1] = true;
                                    res[i][j+1]++;
                                }
                                if(i-1>=0&&grid[i-1][j]==0&&vis[i-1][j]==false){
                                    queue.offer(new int[]{i-1,j});
                                    dis[i-1][j] += val;
                                    vis[i-1][j] = true;
                                    res[i-1][j]++;
                                }
                                if(i+1<row&&grid[i+1][j]==0&&vis[i+1][j]==false){
                                    queue.offer(new int[]{i+1,j});
                                    dis[i+1][j] += val;
                                    vis[i+1][j] = true;
                                    res[i+1][j]++;
                                }
                                if(j-1>=0&&grid[i][j-1]==0&&vis[i][j-1]==false){
                                    queue.offer(new int[]{i,j-1});
                                    dis[i][j-1] += val;
                                    vis[i][j-1] = true;
                                    res[i][j-1]++;
                                }
                                }
                    val++;
                }
            }
        }
    }
        int shortest = Integer.MAX_VALUE;
        for(int i = 0 ;i<row;i++){
        for(int j=0;j<col;j++){
            if(grid[i][j]==0 && res[i][j]==num){
                shortest = Math.min(dis[i][j],shortest);
            }
        }
        }   
    return shortest!=Integer.MAX_VALUE ? shortest:-1;    
 
}
}