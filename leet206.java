public class Solution {
    public ListNode reverseList(ListNode head) {
        if(head.next == null)
            return head;
        ListNode nextNode = head.next;
        ListNode newHead = reverseList(nextNode);
        nextNode.next = head;
        head.next = null;
        return newHead;
    }
}


public ListNode reverseList(ListNode head){
	if(head.next == null){
		return head;
	}
	ListNode nextNode = head.next;
	ListNode res = reverseList(nextNode);
	nextNode.next = head;
	head.next = null;
	return res;
}