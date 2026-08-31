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

        ListNode curr= head;

        List<ListNode> arr= new ArrayList<>();

        while( curr != null)
        {
            arr.add(curr);
            curr= curr.next;

        }

        int i=0;
        int j= arr.size()-1;

        int res=Integer.MIN_VALUE;

        while( i < j)
        {
            res= Math.max(res, arr.get(i).val+arr.get(j).val);

            i++;
            j--;

        }

        return res;
        
    }
}