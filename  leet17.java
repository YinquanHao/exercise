public class Solution {
    public List<String> letterCombinations(String digits) {
    	LinkedList<String> res = new LinkedList<String>();
        HashMap<String, String> hash = new HashMap<String,String>();
        if(digits.length()==0||digits.contains("1")||digits.contains("0")){
            return res;
        }
        hash.put("2","abc");
        hash.put("3","def");
        hash.put("4","ghi");
        hash.put("5","jkl");
        hash.put("6","mno");
        hash.put("7","pqrs");
        hash.put("8","tuv");
        hash.put("9","wxyz");
        res.add("");
        for(int i=0;i<digits.length();i++){
        	while(res.peek().length() == i){
        		String prefix = res.remove();
        		String str = hash.get(Character.toString(digits.charAt(i)));
        		//System.out.println(str);
        		for(int j=0;j<str.length();j++){
        			res.add(prefix+str.charAt(j));
        		}
        	}
        }
       	return res;
    }
}