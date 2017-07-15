public class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> ht = new HashSet<Integer>();
        for(int num:nums){
            if(ht.contains(num))
                return true;
            ht.add(num);
        }
        return false;
    }
}