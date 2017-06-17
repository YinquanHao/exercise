public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null) return null;
    return c(head,null);
}
    public TreeNode c(ListNode h,ListNode t) {
        ListNode a = h;
        ListNode b = h;
        if(h == t) return null;
        while(a!=t&&a.next!=t){
            b = b.next;
            a = a.next.next;
        }
        TreeNode e = new TreeNode(b.val); 
        e.left = c(h,b);
        e.right = c(b.next,t);
        return e;
        
    }
}