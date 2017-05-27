public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
    	Arrays.sort(nums);
    	List<List<Integer>> res = new ArrayList();
        if(nums.length<3){
        	return res;
        }
        for(int i=0;i<nums.length-2;i++){
        	if(i==0 || (i>0 && nums[i] != nums[i-1])){
        		int lo = i+1, high = nums.length-1, target = nums[i]*-1;
        		while(lo<high){
        			if(nums[lo]+nums[high] == target){
        				res.add(Arrays.asList(nums[lo],nums[i],nums[high]));
        				while(lo<high && nums[lo]==nums[lo+1]){
        					lo++;
        				}
        				while(lo<high && nums[high]==nums[high-1]){
        					high--;
        				}
        				lo++;high--;
        			}else if(nums[lo]+nums[high] < target){
        				lo++;
        			}else{
        				high--;
        			}
        		}
        	}
        }
        return res;
    }
}