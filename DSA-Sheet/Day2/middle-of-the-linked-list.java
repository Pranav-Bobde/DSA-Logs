//Link: https://leetcode.com/problems/middle-of-the-linked-list/

//Time & Space: O() O()

class Solution {
    public ListNode middleNode(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode s = head, f = head;
        while(f!=null && f.next!=null){
            s = s.next;
            f = f.next.next;
        }
        return s;
    }
}
