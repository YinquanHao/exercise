public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        Arrays.sort(nums);
        boolean[] contains = new boolean[nums.length];
        backtrack(res,new ArrayList(),nums,contains);
        return res;
    }
    public void backtrack(List<List<Integer>> res, List<Integer> temp, int[] nums,boolean[] contains){
        if(temp.size() == nums.length){
            res.add(new ArrayList<>(temp));
        }else{
            for(int i = 0;i<nums.length;i++){
                if(contains[i]==true){continue;}//the number already exists
                    if(i>0&&nums[i]==nums[i-1]&& !contains[i-1]){continue;}//two same number both not exist, skip one.
                    temp.add(nums[i]);
                    contains[i] = true;
                    backtrack(res,temp,nums,contains);
                    temp.remove(temp.size()-1);
                    contains[i] = false;
            }
        }
    }
}