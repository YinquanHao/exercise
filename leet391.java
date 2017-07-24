public class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        int area = 0;
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        HashSet<String> hs = new HashSet<String>();
        for(int[] rec: rectangles){
            minX = Math.min(minX,rec[0]);
            minY = Math.min(minY,rec[1]);
            maxX = Math.max(maxX,rec[2]);
            maxY = Math.max(maxY,rec[3]);
            area+= (rec[2]-rec[0])*(rec[3]-rec[1]);
            String pt1 = rec[0]+ " " + rec[1];
            String pt2 = rec[0]+ " " + rec[3];
            String pt3 = rec[2]+ " " + rec[3];
            String pt4 = rec[2]+ " " + rec[1];
            if(!hs.add(pt1)) hs.remove(pt1);
            if(!hs.add(pt2)) hs.remove(pt2);
            if(!hs.add(pt3)) hs.remove(pt3);
            if(!hs.add(pt4)) hs.remove(pt4);
        }
        int totalArea = (maxX-minX)*(maxY-minY);
        if(totalArea!=area||hs.size()!=4||!hs.contains(minX+" "+minY)||!hs.contains(minX+" "+maxY)||!hs.contains(maxX+" "+minY)||!hs.contains(maxX+" "+maxY)){
            return false;
        }
        return true;
    }
}