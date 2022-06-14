//Link: https://leetcode.com/problems/linked-list-cycle/

public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;
        
        ListNode s = head, f = head;
        
        do{
            s = s.next;
            f = f.next.next;
        }while(f!=null && f.next!=null && f!=s);
        
        if(f==null || f.next==null)
            return false;
        
        return true;
        
    }
}
