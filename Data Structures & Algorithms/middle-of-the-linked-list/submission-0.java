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
    public ListNode middleNode(ListNode head) {

        List<ListNode> arr= new ArrayList<>();

        ListNode curr= head;

        while(curr !=null)
        {
            arr.add(curr);
            curr= curr.next;
        }

        int mid= arr.size()/2;

        return arr.get(mid);
        
    }
}