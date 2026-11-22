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
    public ListNode reverse(ListNode prev, ListNode curr){
        if(curr == null){
            return prev;
        }
        ListNode fut = curr.next;
        curr.next = prev;
        prev = curr;
        return reverse(curr,fut);
    }
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }
        return reverse(null, head);
    }
}