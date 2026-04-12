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

        if( lists == null || lists.length == 0)
        {
            return null;
        }

     

        while(lists.length > 1)
        {
          List<ListNode> mergedLists=new ArrayList<>();
          for(int i=0; i< lists.length ; i=i+2)
          {
            ListNode left= lists[i];
            ListNode right= i+1 < lists.length? lists[i+1]:null;

            ListNode result=merge(left,right);

            mergedLists.add(result);

          }
         
           lists= mergedLists.toArray(new ListNode[0]);

        }

       
       return lists[0];

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
        
    

    