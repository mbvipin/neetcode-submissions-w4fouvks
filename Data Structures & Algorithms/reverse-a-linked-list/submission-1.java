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
    public ListNode reverseList(ListNode head) {

        if( head == null)
        {
            return null;
        }

        ListNode first= head;
        ListNode second=first.next;
        ListNode back= null;
    

        while( second!=null)
        {

            ListNode temp= second.next;
            // temp > 2
            // temp > 3
            // temp > null
            //
            first.next=back;
            // 0 > null
            // 1 > 0
            // 2 > 1
            second.next=first;
            // 1 > 0
            // 2 > 1
            // 3 > 2

            back=first;
            // back >0
            // back > 1
            // back > 2

            first=second;
            // first > 1
            // first > 2
            // first > 3
          
            second=temp;
            //  second >2
            //  second > 3
            //  second > null
            
        }

        return first;
        
    }
}
