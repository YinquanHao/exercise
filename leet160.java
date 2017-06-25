/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null||headB ==null){
            return null;
        }
        int i =0;
        ListNode A = headA;
        ListNode B = headB;
        for(i=0;A.next!=null;i++)
            A = A.next;
        int j =0;
        for(j=0;B.next!=null;j++)
            B = B.next;
        int k = i-j;
        System.out.println(k);
        if(k>=0){
            while(k>0){
                headA = headA.next;
                k--;
            }
        }else{
            k = k*-1;
            while(k>0){
                headB = headB.next;
                k--;
            }
        }
        while(headA!=null&&headB!=null){
            if(headA == headB){
                return headA;
            }
            headA=headA.next;
            headB=headB.next;
        }
        if(headA==null||headB==null){
            return null;
        }
        return headA;
        
    }
}