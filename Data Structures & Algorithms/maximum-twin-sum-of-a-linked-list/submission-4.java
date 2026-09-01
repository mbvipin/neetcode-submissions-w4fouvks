/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int pairSum(ListNode head) {

        ListNode fast= head;
        ListNode slow= head;

        while(fast != null && fast.next !=null)
        {
            fast= fast.next.next;
            slow= slow.next;
        }

        ListNode prev= null;

        while( slow != null)
        {
            ListNode temp= slow.next;
            slow.next= prev;
            prev= slow;
            slow= temp;
        }

        ListNode first= head;
        ListNode second= prev;

        int res=0;

        while( second != null)
        {

            res= Math.max(res, first.val+ second.val);
            first= first.next;
            second= second.next;

        }

        return res;
        
    }
}