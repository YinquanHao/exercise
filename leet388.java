public class Solution {
    public int lengthLongestPath(String input) {
        Stack<Integer> st = new Stack<Integer>();
        int max = 0;
        st.push(0);
        String [] strlist = input.split("\n");
        for(String str:strlist){
            int level = str.lastIndexOf("\t")+1;
            System.out.println(level);
            while(st.size()>level+1){
                System.out.println("poped");
                st.pop();
            }
            int templength = str.length()-level+st.peek()+1;
            st.push(templength);
            if(str.contains(".")){
                max = Math.max(templength-1,max);
            }
        }
        return max;
    }
    }