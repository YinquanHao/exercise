public class ValidWordAbbr {
    HashMap<String,ArrayList> hs = new HashMap<String,ArrayList>();
    public ValidWordAbbr(String[] dictionary) {
        for(String s : dictionary){
            if(!s.equals("")){
            int len = s.length();
            String start = Character.toString(s.charAt(0));
            String end = Character.toString(s.charAt(s.length()-1));
            String lenstr = Integer.toString(len-2);
            String key = start+end+lenstr;
            if(hs.get(key)==null){
                ArrayList temp  = new ArrayList();
                hs.put(key,temp);
                hs.get(key).add(s);
            }else{
                hs.get(key).add(s);
            }
            }
        }
    }
    
    public boolean isUnique(String word) {
        int len = word.length();
        if(word.equals("")){
            return true;
        }
        String start = Character.toString(word.charAt(0));
        String end = Character.toString(word.charAt(word.length()-1));
        String lenstr = Integer.toString(len-2);
        String key = start+end+lenstr;
        ArrayList temp = hs.get(key);
        if(temp==null||temp.size()==1&&temp.get(0).equals(word)){
            return true;
        }
        for(int i=0;i<temp.size();i++){
            if(!temp.get(i).equals(word)){
                return false;
            }
        }
        return true;
    }
}