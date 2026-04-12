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
    public ListNode mergeKLists(ListNode[] lists) {

  
        int countOfNodes=0;

        for(ListNode head: lists)
        {
            ListNode curr= head;

            while(curr!=null)
            {
                countOfNodes++;
                curr= curr.next;
            }
        }

        int [] array= new int[countOfNodes];
        int i=0;

        for(ListNode head: lists)
        {
            ListNode curr= head;

            while( curr != null)
            {
                array[i++]=curr.val;
                curr=curr.next;
            }
        }

        Arrays.sort(array);

        ListNode dummy=new ListNode(0);
        ListNode curr=dummy;

        for( int j=0; j < array.length; j++)
        {
            ListNode next=new ListNode(array[j]);
            curr.next=next;
            curr= curr.next;
        }

        return dummy.next;

    }
}
