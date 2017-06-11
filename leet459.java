import java.util.ArrayList;
public class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int[] ht = new int[26];
        ArrayList<Integer> al = new ArrayList<Integer>(); 
        int slen = s.length();
        if(slen==1){
            return false;
        }
        for(int i=0;i<slen;i++){
            ht[s.charAt(i)-97]++;
        }
        for(int i=0;i<26;i++){
            if(ht[i]!=0){
                al.add(ht[i]);
            }
        }
        if(al.size()==1){
            return true;
        }
        int first = al.get(0);
        for(int i=1;i<al.size();i++){
            first = gcd(first,al.get(i));
        }
        if(first==1){
            char t = s.charAt(0);
            for(int i=1;i<slen;i++){
                if(t!=s.charAt(i)){
                    return false;
                }
            }
            return true;
        }
        boolean res = false;
        for(int k = first;k>1;k--){
            int length = slen/k;
            if(slen%length==0){
                String temp = s.substring(0,length);
        
                for(int i=length;i<slen;i=i+length){
                    String temp1 = s.substring(i,i+length);
                    if(!temp1.equals(temp)){
                        break;
                    }
                    if(i==slen-length){
                        res =true;
                    }
                }
            }
        }
        return res;
    }
    
    public int gcd(int a ,int b){
        if(b == 0){
            return a;
        }
        return gcd(b,a%b);
    }
}