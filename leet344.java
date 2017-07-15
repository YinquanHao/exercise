public class Solution {
    public String reverseString(String s) {
        char [] str = s.toCharArray();
        int length = str.length;
        int i=0, j = length-1;
        while(i<j){
            char temp = str[i];
            str[i] = str[j];
            str[j] = temp;
            i++;
            j--;
        }
        return new String(str);
    }
}