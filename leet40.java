public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList();
        Arrays.sort(candidates);
        backtrack(res, new ArrayList(), candidates, target, 0);
        return res;
    }
    public void backtrack(List<List<Integer>> res, List<Integer> temp, int[] candidates, int target, int start){
        if(getSum(temp)==target){
            res.add(new ArrayList(temp));
        }else if(getSum(temp)>target){
            return;
        }else{
            for(int i=start; i<candidates.length;i++){
                if(i>start&& candidates[i] == candidates[i-1]){
                    continue;
                }
                temp.add(candidates[i]);
                backtrack(res,temp,candidates,target,i+1);
                temp.remove(temp.size()-1);
            }
        }
    }
    public int getSum(List<Integer> sum){
        int res = 0;
        for(int num: sum){
            res+=num;
        }
        return res;
    }
}