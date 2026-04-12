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
            // temp -> null
            first.next=back;
            // 2-> 1
            second.next=first;
            // 3 -> 2

            back=first;
            // back->2

            first=second;
            // first-> 3
          
            second=temp;
            //  second->null
            
        }

        return first;
        
    }
}
