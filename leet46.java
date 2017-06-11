public class Solution {
    public List<List<Integer>> permute(int[] nums) {
    	int num = nums[0];
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	if(nums.length==1){
    	    ArrayList<Integer> singleList = new ArrayList<Integer>();
            singleList.add(num);
            res.add(singleList);
            return res;
    	}else{
            int [] subArray = Arrays.copyOfRange(nums, 1, nums.length);
            res =  permute_helper(subArray,num,res);
        }
        return res;
    }
    public List<List<Integer>> permute_helper (int[] sub,int num,List<List<Integer>>res){
        res = permute(sub);
        List<List<Integer>> newres = new ArrayList<List<Integer>>();
        for(List<Integer> l :res){
            for(int i = 0;i<=l.size();i++){
                List<Integer> list1 = new ArrayList(l);
                list1.add(i,num);
                newres.add(list1);
            }
        }
    	return newres;
    }
    }