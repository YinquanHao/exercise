public class Solution {
    public int numberOfPatterns(int m, int n) {
        int[][] skip = new int[10][10];
        skip[1][3]=skip[3][1] = 2;
        skip[1][7]=skip[7][1] = 4;
        skip[7][9]=skip[9][7] = 8;
        skip[3][9]=skip[9][3] = 6;
        skip[2][8]=skip[8][2]=skip[4][6] = skip[6][4] =skip[7][3]=skip[3][7]=skip[1][9]=skip[9][1]=5;
        int res = 0;
        boolean [] vis = new boolean[10];
        for(int i=m;i<=n;i++){
            res+=recur(vis,skip,1,i-1)*4;
            res+=recur(vis,skip,2,i-1)*4;
            res+=recur(vis,skip,5,i-1)*1;
        }
        return res;
    }
    public int recur(boolean [] vis, int[][] skip,int cur,int remaining){
        if(remaining<0) return 0;
        if(remaining==0) return 1;
        vis[cur] = true;
        int res = 0;
        for(int i=1;i<=9;++i){
            if(skip[cur][i]==0 && vis[i]==false || vis[skip[cur][i]]==true && vis[i]==false){
                res+=recur(vis,skip,i,remaining-1);
            }
        }
        vis[cur] = false;
        return res;
    }
}