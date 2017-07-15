public class Solution {
    public List<String> findStrobogrammatic(int n) {
        List<String> finalRes =  helper(n,n);
        List<String> res = new ArrayList();
        for(String s : finalRes){
            if(s.charAt(0)!=('0')||s.length()==1){
             res.add(s);   
            }
        }
        return res;
    }
    public List<String> helper(int n, int m){
        if(n==0) return new ArrayList(Arrays.asList(""));
        if(n==1) return new ArrayList(Arrays.asList("0","8","1"));
        List<String> list = helper(n-2,m);
        List<String> res = new ArrayList();
        for(String s: list){
            StringBuilder sb  = new StringBuilder();
            res.add(sb.append('6').append(s).append('9').toString());
            sb.setLength(0);
            res.add(sb.append('9').append(s).append('6').toString());
            sb.setLength(0);
            res.add(sb.append('0').append(s).append('0').toString());
            sb.setLength(0);
            res.add(sb.append('8').append(s).append('8').toString());
            sb.setLength(0);
            res.add(sb.append('1').append(s).append('1').toString());
            sb.setLength(0);
        }
        
        return res;
        
    }

}