public class Solution {
    public int removeElement(int[] nums, int val) {
        int length = nums.length;
        if(length ==0){
            return 0;
        }
        Arrays.sort(nums);
        int count = 0;
        int index = Arrays.binarySearch(nums,val);
        if(index < 0){
            return length;
        }
        int i = index;
        while(i<length&&nums[i]==val ){
            nums[i] = Integer.MAX_VALUE;
            count++;
            i++;
        }
        int j = index-1;
        while(j>=0&&nums[j]==val){
            nums[j]=Integer.MAX_VALUE;
            count++;
            j--;
            
        }
        Arrays.sort(nums);
        return length-count;
    }
}