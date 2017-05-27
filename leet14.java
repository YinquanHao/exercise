public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){
        	return "";
        }
        String prefix = strs[0];
        for(int i=1;i<strs.length;i++){
            while(strs[i].indexOf(prefix)!=0){
                prefix = prefix.subString(0,prefix.length()-1);
                if(prefix==null){
                	return "";
                }
            }
        }
        return prefix;
    }
}