//Link: https://leetcode.com/problems/remove-nth-node-from-end-of-list/

//Time & Space: O(N) O(1)

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next == null) return null;
        int len = 0;
        ListNode temp = head;
        while(temp!=null){
            len++;
            temp = temp.next;
        }
        int jumps = len - n - 1;
        if(jumps==-1){
            head = head.next;
            return head;
        }
        temp = head;
        while(jumps-->0){
            System.out.println(temp.val);
            temp = temp.next;
        }
        ListNode next = temp.next.next;
        temp.next = next;
        return head;
    }
}
