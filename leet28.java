public class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack.length()<needle.length()){
            return -1;
        }
        int t = needle.length();
        for(int i=0;i<haystack.length()-t+1;i++){
            String s = haystack.substring(i,i+t);
            if(s.equals(needle))
                return i;
        }
        return -1;
    }
}