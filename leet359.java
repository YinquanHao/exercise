public class Logger {
    HashMap<String,Integer> hs;

    /** Initialize your data structure here. */
    public Logger() {
        hs = new HashMap<String,Integer>(); 
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(hs.containsKey(message)){
            int old = hs.get(message);
            if(timestamp-old>=10){
                hs.put(message,timestamp);
                return true;
            }else{
                return false;
            }
        }else{
            hs.put(message,timestamp);
            return true;
        }
    }
}
