public class Solution {
    public String reverseVowels(String s) {
        char [] ch = s.toCharArray();
        int end = ch.length-1;
        int start = 0;
        String vo = "aeiouAEIOU";
        while(start<end){
            while(start<end&&!vo.contains(Character.toString(ch[start]))){
                start++;
            }
            while(start<end&&!vo.contains(Character.toString(ch[end]))){
                end--;
            }
            char temp = ch[start];
            ch[start] = ch[end];
            ch[end] = temp;
            start++;
            end--;
        }
        return new String(ch);
    }
}