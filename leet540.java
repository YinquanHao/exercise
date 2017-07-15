public class Solution {
    public int singleNonDuplicate(int[] nums) {
        int leng = nums.length;
        int lo = 0, hi = leng/2;
        while(lo<hi){
            int mid = (lo+hi)/2;
            if(nums[2*mid]!=nums[2*mid+1]){
                hi = mid;
            }else{
                lo = mid+1;
            }
        }
        return nums[lo*2];
    }
}