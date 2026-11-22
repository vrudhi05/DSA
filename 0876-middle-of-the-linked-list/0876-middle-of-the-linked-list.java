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
        if(head == null){
            return null;
        }
        int cnt=1;
        ListNode curr = head;
        while(curr != null){
            cnt++;
            curr = curr.next;
        }
        int target = Math.ceilDiv(cnt, 2); 
        curr = head;
        cnt=1;
        while(cnt != target){
            curr = curr.next;
            cnt++;
        }
        return curr;
    }
}