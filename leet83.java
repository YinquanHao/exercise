/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cursor = head;
        while(cursor!=null&&cursor.next!=null){
            if(cursor.val==cursor.next.val)
                cursor.next = cursor.next.next;
            else
                cursor = cursor.next;
        }
        return head;
        
    }
}