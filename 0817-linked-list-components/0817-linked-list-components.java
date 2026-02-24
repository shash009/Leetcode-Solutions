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
    public int numComponents(ListNode head, int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int x : nums) set.add(x);
    ListNode curr = head;
    int count = 0;
    while (curr != null) {
        // If current node is in set and (it's the last node OR next node is not in set)
        if (set.contains(curr.val) && (curr.next == null || !set.contains(curr.next.val))) {
            count++;
        }
        curr = curr.next;
    }
    return count;
    }
}