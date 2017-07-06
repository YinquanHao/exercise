/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head==null)
            return null;
        ListNode dummy = new ListNode(0), dummyhd = dummy, dummy2 = new ListNode(0), dummyhead = dummy2;
        while(head!=null){
            if(head.val<x){
                dummy.next = head;
                dummy = dummy.next;
            }else{
                dummy2.next = head;
                dummy2 = dummy2.next;
            }
            head = head.next;
        }
        dummy2.next = null; 
        dummy.next = dummyhead.next;
        return dummyhd.next;
    }
}