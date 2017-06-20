public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int res = 0;
        int start = 0;
        int end = 0;
        int distinct = 0;
        int [] count  = new int [256];
        for(int i=0;i<s.length();i++){
            if(count[s.charAt(i)]==0){
                count[s.charAt(i)]++;
                end++;
                distinct++;
            }else if(count[s.charAt(i)]!=0){
                count[s.charAt(i)]++;
                end++;
            }
            if(distinct>k){
                while(distinct>k){
                    count[s.charAt(start)]--;
                    if(count[s.charAt(start)]==0){
                        distinct--;
                    }
                    start++;
                }
            }
            res = Math.max(end-start,res);
        }
        return res;
    }
}