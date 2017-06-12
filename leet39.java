public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList();
        backtrack(res,new ArrayList(), candidates, target, 0);
        return res;
    }
    public void backtrack(List<List<Integer>> res, List<Integer> temp, int [] candidates, int target, int start){
        if(getTempSum(temp)==target){
            res.add(new ArrayList(temp));
        }else if(getTempSum(temp)>target){
            return;
        }else{
        for(int i=start;i<candidates.length;i++){
            temp.add(candidates[i]);
            backtrack(res,temp,candidates,target,i);
            temp.remove(temp.size()-1);
            }
        }
    }
    public int getTempSum(List<Integer> temp){
        int res  = 0;
        for(int i=0;i<temp.size();i++){
            res+=temp.get(i);
        }
        return res;
    }
}