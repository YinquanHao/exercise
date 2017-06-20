public class Solution {
    public String licenseKeyFormatting(String S, int K) {
        Stack<Character> st = new Stack<Character>();
        for(int i=0;i<S.length();i++){
            if(S.charAt(i)!='-'){
                st.push(Character.toUpperCase(S.charAt(i)));
            }
        }
        int count=0;
        StringBuilder sb=new StringBuilder();
        while(!st.empty()){
            if(count==K){
                count = 0;
                sb.insert(0,'-');
            }else{
                sb.insert(0,st.pop());
                count++;
            }
        }
        return sb.toString();
    }
}