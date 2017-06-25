public class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        //odd
        if(fast != null){
            slow = slow.next;
        }
        ListNode reversed = reverse(slow);
        while(reversed!=null){
            if(reversed.val != head.val){
                return false;
            }
            reversed = reversed.next;
            head = head.next;
        }
        return true;
    }
    public ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode nextNode = head.next;
        ListNode res = reverse(nextNode);
        nextNode.next = head;
        head.next = null;
        return res;
    }
}