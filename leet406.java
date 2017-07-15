public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,new Comparator<int []>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[0]!=o2[0]?o2[0]-o1[0]:o1[1]-o2[1];
            }
        });
        ArrayList res =  new ArrayList();
        for(int[] a: people)
              res.add(a[1],a);
        int[][] newres = new int[res.size()][2];
        res.toArray(newres);
        return newres;
    }
}