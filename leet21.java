/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	ListNode res = null;
    	ListNode head = null;
        if(l1!=null && l2!=null){
        	if(l1.val<l2.val){
        		res = new ListNode(l1.val);
        		l1 = l1.next;
        	}else{
        		res = new ListNode(l2.val);
        		l2 = l2.next;
        	}
        	head = res;
        }else{
        	return (l1==null) ? l2 : l1;
        }
        while(l1!=null && l2!=null){
        	if(l1.val<l2.val){
        		res.next = new ListNode(l1.val);
        		l1 = l1.next;
        	}else{
        		res.next = new ListNode(l2.val);
        		l2 = l2.next;
        	}
        	res = res.next;
        }
        //System.out.println("this");
        if(l1==null&&l2!=null){
        	while(l2!=null){
        		res.next = new ListNode(l2.val);
        		res = res.next;
        		l2 = l2.next;
        	}
        }else if(l2==null&&l1!=null){
        	while(l1!=null){
        	   // System.out.println(l1.val);
        		res.next = new ListNode(l1.val);
        		res = res.next;
        		l1 = l1.next;
        	}
        }
        return head; 
    }
}