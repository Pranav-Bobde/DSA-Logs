//Link: https://leetcode.com/problems/reverse-linked-list/

//Time & Space: O(N) O(1)

class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode prev = null, curr = head, next = head.next;
        while(curr!=null){
            curr.next = prev;
            prev = curr;
            curr = next;
            if(curr == null) return prev;
            next = next.next;
        }
        return prev;
    }
}
