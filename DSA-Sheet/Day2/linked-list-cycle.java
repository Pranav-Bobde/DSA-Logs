//Link: https://leetcode.com/problems/linked-list-cycle/

//Time & Space: O(N) O(1)

public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head==null || head.next == null) return false;
        if(head.next == head) return true;
        ListNode s = head, f = head;
        do{
            s = s.next;
            f = f.next.next;
        }while(s!=f && f!=null && f.next!=null);
        return s==f;
    }
}
