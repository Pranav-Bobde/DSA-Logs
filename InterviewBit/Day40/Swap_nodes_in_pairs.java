//Link: https://leetcode.com/problems/swap-nodes-in-pairs/

//Time & Space Complexity: O(N) O(1)

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
    ListNode getKth(ListNode curr, int k){
        while(curr!=null && k-->0){
            curr = curr.next;
        }
        return curr;
    }
    
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next == null) return head;
        ListNode dummy = new ListNode(0), grpPrev = dummy;
        dummy.next = head;
        while(true){
            ListNode kth = getKth(grpPrev, 2);
            if(kth == null)
                break;
            ListNode grpNext = kth.next;
            ListNode curr = grpPrev.next, prev = grpNext;
            while(curr!=grpNext){
                ListNode nxt = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nxt;
            }
            ListNode temp = grpPrev.next;
            grpPrev.next = kth;
            grpPrev = temp;
        }
        return dummy.next;
    }
}
