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

        if( list1== null && list2== null)
        {
            return null;
        }

        if(list1==null)
        {
            return list2;
        }

        if(list2==null)
        {
            return list1;
        }

          ListNode result=null;
          ListNode currFirst=list1;
          ListNode currSecond=list2;
          ListNode headResult=null;

          while( currFirst!=null && currSecond!=null)
          {

            if(currSecond.val <= currFirst.val)
            {
                if( result == null)
                {
                    // 1
                    result=currSecond;
                    headResult=currSecond;
                    
                }
                else
                {
                    result.next=currSecond;
                    result=result.next;
                }
                currSecond=currSecond.next;

            }
            else
            {
                if( result==null)
                {
                    result=currFirst;
                    headResult=currFirst;
                }
                else
                {
                    // 1->1
                    //
                   result.next=currFirst;
                   result=result.next;
                   
                }
               
                currFirst=currFirst.next;
            }


      
          }

          if(currFirst!=null)
          {
            result.next=currFirst;
          }
          else if( currSecond!=null)
          {
            result.next=currSecond;
          }

     return headResult;
        
    }
}