public class Solution {
    public boolean isStrobogrammatic(String num) {
        if(num.length()%2==1&&(num.charAt((int)num.length()/2)!='1' && num.charAt((int)num.length()/2)!='8'&& num.charAt((int)num.length()/2)!='0')){
            return false;
        }
        for(int i=0;i<num.length();i++){
            if(i<num.length()-1-i){
                char head = num.charAt(i);
                char tail = num.charAt(num.length()-1-i);
                if(head !='6'&&head!='9'&&head!='1'&&head!='8'&&head!='0') return false;
                if(tail !='6'&&tail!='9'&&tail!='1'&&tail!='8'&&head!='0') return false;
                if(head == '6' && tail!= '9'||head == '9' && tail!='6'||head=='1' && tail!='1'||head=='8' && tail!='8'||head=='0'&&tail!='0'){
                    return false;
                }
            }
        }
        return true;
    }
}