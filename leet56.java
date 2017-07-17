/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        int size = intervals.size();
        if(size<=1){
            return intervals;
        }
        List<Interval> res = new ArrayList<Interval>();
        intervals.sort(new Comparator<Interval>(){
            @Override
            public int compare(Interval v1, Interval v2){
                return v1.start - v2.start;
            }
        });
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for(int i=0;i<size;i++){
            int nextStart = intervals.get(i).start;
            int nextEnd = intervals.get(i).end;
            if(nextStart<=end){
                if(end>nextEnd){
                    //res.add(new Interval(start,end));
                }else{
                    //res.add(new Interval(start,nextEnd));
                    end = nextEnd;
                }
            }else{
                res.add(new Interval(start, end));
                start = nextStart;
                end = nextEnd;
            }
        }
        res.add(new Interval(start, end));
        return res;
    }
}