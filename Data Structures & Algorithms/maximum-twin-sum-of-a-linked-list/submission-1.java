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

        ListNode fast=head;
        ListNode slow= head;

        while( fast != null && fast.next != null)
        {
            fast= fast.next.next;
            slow= slow.next;
        }

        ListNode prev= null;
        ListNode curr= slow;

        while( curr!= null)
        {
            ListNode temp= curr.next;
            
            curr.next=prev;
            prev= curr;
            curr= temp;
        }

        int res=0;

        ListNode first= head;
        ListNode second= prev;

        while(second != null)
        {
            res= Math.max(res, first.val + second.val);
            first = first.next;
            second= second.next;

        }

        return res;
        
    }
}