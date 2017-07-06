/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(n-m<1){
            return head;
        }
        ListNode preHead=head;
        ListNode mHead = head;
        ListNode nTail=head;
        ListNode afterTail = head;
        ListNode newHead = head;
        int i=1;
        while(head!=null){
            if(i==m-1){
                preHead = head;
                mHead = head.next;
            }
            if(i==n){
                nTail = head;
                afterTail = head.next;
            }
            i++;
            head = head.next;
        }
        nTail.next = null;
        mHead = reverseList(mHead);
        if(m==1){
            newHead = mHead; 
        }else{
        preHead.next  = mHead;
        }
        while(mHead.next!=null){
            mHead = mHead.next;
        }
        mHead.next = afterTail;
        return newHead;
        
    }
    public ListNode reverseList(ListNode head){
        if(head ==null || head.next == null)
            return head;
        ListNode nextNode = head.next;
        ListNode newHead = reverseList(nextNode);
        nextNode.next = head;
        head.next = null;
        return newHead;
    }
}