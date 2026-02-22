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
    int carry;
    public void helper(ListNode head){
        if(head == null){
            return;
        }
        // sum += head.val;
        helper(head.next);
        int value = head.val * 2;
        if(carry == 1){
            value++;
        }
        if(value >= 10){
            carry = 1;
            value = value % 10;
        }else{
            carry = 0;
        }
        head.val = value;
    }
    public ListNode doubleIt(ListNode head) {
        carry = 0;
        helper(head);
        if(carry == 1){
            ListNode newHead = new ListNode(1);
            newHead.next = head;
            return newHead;
        }
        return head;
    }
}