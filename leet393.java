public class Solution {
    public boolean validUtf8(int[] data) {
        int seq = 0;
        for(int i=0;i<data.length;i++){
            if(seq == 0){
                seq = getNumberOfBytes(data[i]);
                if(seq == -1){
                    return false;
                }
                continue;
            }else{
                boolean valid = isFollower(data[i]);
                if(valid == false){
                    return false;
                }
                seq--;
            }
        }
        return seq==0?true:false;
    }
    public int getNumberOfBytes(int firstInt){
        int [] mask = {0xF8,0xF0,0xE0,0x80};
        int [] table = {240,224,192,0};
        int res = -1;
        for(int i=0;i<table.length;i++){
            int masked = firstInt & mask[i];
            if(masked == table[i]){
                return 3-i;
            }
        }
        return -1;
    }
    public boolean isFollower(int num){
        int masked = num & 192;
        return masked==128?true:false;
    }
}