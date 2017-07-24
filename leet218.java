public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new ArrayList();
        List<int[]> sort = new ArrayList();
        for(int[] building: buildings){
            sort.add(new int[] {building[0],building[2]});
            sort.add(new int[] {building[1],-building[2]});
        }
        Collections.sort(sort, (a,b)->{
            if(a[0]!=b[0]){
                return a[0]-b[0];
            }else{
                return b[1]-a[1];
            }
        });
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>((a,b)->{
            return b-a;
        });
        heap.add(0);
        int tempMax = 0;
        for(int[] temp: sort){
            if(temp[1]>=0){
                heap.add(temp[1]);
            }else{
                heap.remove(-temp[1]);
            }
            System.out.println(tempMax);
            System.out.println(heap.peek());
            int current = heap.peek();
            if(current!=tempMax){
                res.add(new int[]{temp[0],current});
            }
            tempMax = current;
        }
        return res;
     
    }
}