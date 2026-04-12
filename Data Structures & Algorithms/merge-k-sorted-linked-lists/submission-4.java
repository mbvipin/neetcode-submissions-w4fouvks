/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) {
 *         this.val = val;
 *     }
 *     ListNode(int val, ListNode next) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        Queue<ListNode> queue=new PriorityQueue<>(
            (a, b) -> Integer.compare(a.val, b.val));

        ListNode dummy=new ListNode(0);
        ListNode curr=dummy;

        for( ListNode head: lists)
        {
            if (head != null) {
                queue.offer(head);
            }
        }

        while( !queue.isEmpty())
        {
           ListNode currMin=queue.poll();

           curr.next=currMin;
           curr=curr.next;

          if( currMin.next!=null)
          {
           queue.offer(currMin.next);
          }
        }

        return dummy.next;
        
    }

    }