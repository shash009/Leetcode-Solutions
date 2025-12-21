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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode(0);
        ListNode l3 = temp;
        int carry = 0;
        int sum = 0;
        while(l1 != null || l2 != null || carry!= 0){
            sum = carry;
            if(l1 != null){
                sum = sum + l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                sum = sum + l2.val;
                l2 = l2.next;
            }
            int num = sum % 10;
            carry = sum / 10;
            // temp.val = num;
            // temp.next = new ListNode(0);
            // temp = temp.next;
            temp.next = new ListNode(num);
            temp = temp.next;
        }
        return l3.next;
    }
}