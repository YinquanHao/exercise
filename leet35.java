public class Solution {
    public int searchInsert(int[] nums, int target) {
        if(nums.length==1){
            if(target<=nums[0]){
                return 0;
            }else{
                return 1;
            }
        }
        int res = binarySearch(0,nums.length-1,nums,target);
        return res;
    }
    public int binarySearch(int start, int end, int[] nums , int target){
        int mid = (int)((start+end)/2);
        if(end-start ==1){
            if(target<=nums[start]){
                return start;
            }else if(target>nums[start]&&target<=nums[end]){
                return end;
            }else{
                return end +1;
            }
        }
        if(nums[mid]>target){
               return binarySearch(start,(int)(start+end)/2,nums,target);
        }else if(nums[mid]<target){
                return binarySearch(mid,end,nums,target);
        }else{
                return mid;
        }
    
    } 
}