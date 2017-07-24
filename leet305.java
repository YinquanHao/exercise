public class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        Union union = new Union(m,n);
        List<Integer> res = new ArrayList();
        for(int i=0;i<positions.length;i++){
            //System.out.println(positions.length);
            int x =  positions[i][0];
            int y = positions[i][1];
            //System.out.println("xb "+x);
            //System.out.println("yb "+y);
            union.add(x,y);
            int index = union.getId(x+1,y);
            int index1 = union.getId(x-1,y);
            int index2 = union.getId(x,y-1);
            int index3 = union.getId(x,y+1);
            int index4 = union.getId(x,y);
            if(index>0 && !union.find(index4,index)){
                //System.out.println("index4 "+index4);
                //System.out.println("index "+index);
                //System.out.println("sfsdfsdf1");
                union.union(index4,index);
            }
            if(index3>0 &&!union.find(index3,index4)){
                //System.out.println("sfsdfsdf2");
                union.union(index3,index4);
            }
            if(index2>0 &&!union.find(index2,index4)){
                //System.out.println("sfsdfsdf3");
                union.union(index2,index4);
            }
            if(index1>0 &&!union.find(index1,index4)){
                //System.out.println("sfsdfsdf4");
                union.union(index1,index4);
            }
            res.add(union.size());
        }
        return res;
    }
    public class Union{
        private int [] id;
        private int [] size;
        private int m,n,count;
        public Union(int m,int n){
            this.m = m;
            this.n = n;
            this.count = 0;
            this.id = new int[m*n+1];
            this.size = new int[m*n+1];
        }
        public int size(){
            return this.count;
        }
 
    public int add(int x, int y) {
        int i = index(x, y);
        id[i] = i; size[i] = 1;
        ++count;
        return i;
    }
        private int root(int i) {
        for (;i != id[i]; i = id[i])
            id[i] = id[id[i]]; //path compression
        return i;
    }
        public void union(int p, int q) {
        int i = root(p), j = root(q);
        if (size[i] < size[j]) { //weighted quick union
            id[i] = j; size[j] += size[i];
        } else {
            id[j] = i; size[i] += size[j];
        }
        --count;
    }
          public int getId(int x, int y) {
        if (0 <= x && x < m && 0<= y && y < n)
            return id[index(x, y)];
        return 0;
    }
        public boolean find(int p, int q){
            return root(p) == root(q);
        }
        public int index(int x,int y){
            return x*n+y+1;
        }
    }
}