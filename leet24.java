/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next == null){
            return head;
        }
        if(head.next.next==null){
            ListNode lastNode = head.next;
            ListNode secondLast  = head;
            lastNode.next = secondLast;
            secondLast.next = null;
            return lastNode;
            
        }
        ListNode first = head;
        ListNode second = head.next;
        ListNode res = swapPairs(first.next.next);
        first.next = res;
        second.next = first;
        return second;
        
        
    }
}