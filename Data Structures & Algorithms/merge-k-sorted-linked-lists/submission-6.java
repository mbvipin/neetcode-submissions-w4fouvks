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

        return merge(lists,0, lists.length-1);


    }

        public ListNode merge(ListNode [] lists, int start, int end)
        {
            if( start > end)
            {
                return null;
            }

            if( start == end)
            {
                return lists[start];
            }

            int mid= (start+end)/2;

            ListNode  left= merge(lists,start, mid);
            ListNode  right= merge(lists,mid+1,end);

            return merge(left,right);
        }

        public ListNode merge(ListNode left, ListNode right)
        {
            ListNode dummy=new ListNode(0);
            ListNode curr= dummy;

            while( left!= null && right!=null)
            {
                if( left.val <= right.val)
                {
                    curr.next=left;
                    left=left.next;
                }
                else
                {
                    curr.next=right;
                    right= right.next;
                
                }

                curr=curr.next;

            }

            if( left!=null)
            {
                curr.next=left;
            }

            if(right!=null)
            {
                curr.next=right;
            }

           return dummy.next;

        }

}
        
    

    