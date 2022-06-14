//Link: https://leetcode.com/problems/middle-of-the-linked-list/

class Solution {
    public ListNode middleNode(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode s = head, f = head;
        
        do{
            s = s.next;
            f = f.next.next;
        }while(f!=null && f.next!=null);
        
        return s;
    }
}
