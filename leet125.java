public class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        s = s.trim();
        int length = s.length();
        int first = 0;
        int last = length-1;
        while (first <= last){
            while(first<=last&&Character.isLetter(s.charAt(first))==false&&Character.isDigit(s.charAt(first))==false){
                first++;
            }
            while(first<=last&&Character.isLetter(s.charAt(last))==false&&Character.isDigit(s.charAt(last))==false){
                last--;
            }
            if(first<=last&&s.charAt(first)!=s.charAt(last)){
                return false;
            }
            first++;
            last--;
        }
        return true;
    }
}