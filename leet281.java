public class ZigzagIterator {
    LinkedList<Iterator> list;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        list = new LinkedList<Iterator>();
        if(!v1.isEmpty()) list.add(v1.iterator());
        if(!v2.isEmpty()) list.add(v2.iterator());
    }

    public int next() {
        Iterator temp = list.remove();
        int res = (Integer)temp.next();
        if(temp.hasNext()){
            list.add(temp);
        }
        return res;
    }

    public boolean hasNext() {
        return !list.isEmpty();
    }
}