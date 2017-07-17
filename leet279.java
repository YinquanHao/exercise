public class Solution {
    public int numSquares(int n) {
        int dp[] = new int[n+1];
        dp[0] = 0;
        for(int i=1;i<=n;i++){
            int j=1;
            int min = i;
            while(i>=j*j){
                int temp = dp[i-j*j]+1;
                min = Math.min(min,temp);
                j++;
            }
            dp[i] = min;
        }
        return dp[n];
    }
}