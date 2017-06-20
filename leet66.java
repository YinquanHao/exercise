public class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 0;
        if(digits[digits.length-1]>=9){
            carry =1;
            digits[digits.length-1]=0;
        }else{
            digits[digits.length-1]=digits[digits.length-1]+1;
            return digits;
        }
        for(int i=digits.length-2;i>=0;i--){
            if(digits[i]+carry>=10){
                digits[i]=(digits[i]+carry)%10;
                carry = 1;
            }else{
                digits[i] = digits[i]+carry;
                return digits;
            }
        }
        if(carry==1){
            int [] res = new int[digits.length+1];
            res[0] = 1;
            for(int i=1;i<res.length;i++){
                res[i] = digits[i-1];
            }
            return res;
            
        }else{
            return digits;
        }
        
    }
}