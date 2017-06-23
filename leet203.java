/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return null;
        }
        while(head!=null&&head.val==val){
            head = head.next;
        }
        ListNode cursor = head;
        while(cursor!=null&&cursor.next!=null){
            if(cursor.next.val == val ){
                cursor.next = cursor.next.next;
            }else{
                cursor = cursor.next;
            }
        }
        return head;
    }
}