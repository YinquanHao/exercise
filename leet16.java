public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0]+nums[1]+nums[nums.length-1];
        for(int i=0;i<nums.length-2;i++){
            int lo = i+1;
            int hi = nums.length-1;
            while(lo<hi){
                int currentRes = nums[lo]+nums[hi]+nums[i];
                if(target - currentRes>0){
                    lo++;
                }else if(target - currentRes<0){
                    hi--;
                }else{
                    return currentRes;
                }
                if(Math.abs(target - currentRes)<Math.abs(target - res)){
                    res = currentRes;
                }
            }
        }
        return res;
    }
}