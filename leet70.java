public class Solution {
    public int climbStairs(int n) {
        if(n<=0)
            return 0;
        if(n==1)
            return 1;
        if(n==2)
            return 2;
        int p1 = 1;
        int p2 = 2;
        int sum = 0;
        for(int i=2;i<n;i++){
            sum = p1+p2;
            p1 = p2;
            p2 = sum;
        }
        return sum;
    }
}