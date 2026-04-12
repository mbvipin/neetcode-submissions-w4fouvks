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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

         ListNode dummy=new ListNode(0);
         ListNode first=list1;
         ListNode second=list2;

         ListNode currResult=dummy;


          while(first!=null && second!=null)
          {
            if(first.val <= second.val){

              currResult.next= first;
              currResult=currResult.next;
              first=first.next;
            }
            else
            {
                currResult.next= second;
                currResult=currResult.next;
                second=second.next;
            }


          }

          if(first != null)
          {
            currResult.next=first;
          }

          if(second != null)
          {
            currResult.next=second;
          }


      return dummy.next;
        
    }
}