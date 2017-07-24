public class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length==0||nums.length==1){
            return nums.length;
        }
        int [] dp = new int[nums.length];
        int len = 0;
        for(int i=0;i<nums.length;i++){
            if(len==0){
                dp[0] = nums[0];
                len++;
            }else{
                int index = Arrays.binarySearch(dp,0,len,nums[i]);
                if(index<0){
                    int insertion = index*(-1)-1;
                    if(insertion>=len){
                        dp[insertion] = nums[i];
                        len++;
                    }else{
                        dp[insertion] = nums[i];
                    }
                }
            }
        }
        return len;
    }
}