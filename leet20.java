public class Solution {
    public static boolean isValid(String input){
	Stack<Character> s = new Stack<Character>();
	for(char c : input.toCharArray()){
		if(c=='{'||c=='['||c=='('){
			s.push(c);
		}else if(c=='}'||c==']'){
			if(s.isEmpty()||s.pop()!=c-2){
				return false;
			}
		}else if(c==')'){
		    if(s.isEmpty()||s.pop()!=c-1){
				return false;
			}
		}
	}
	return s.isEmpty();
}
}