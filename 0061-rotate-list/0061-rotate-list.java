/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k < 0) {
            return null;
        }
        

        ListNode curr = head;
        int length = 1;
        while (curr.next != null) {
            curr = curr.next;
            length++;
        }
        curr.next = head;  
        curr = head;
        k %= length;   
        int offset = length - k - 1;  
        while (offset > 0) {
            curr = curr.next;
            offset--;
        }
        ListNode newHead = curr.next;
        curr.next = null;
        return newHead;
    }
}