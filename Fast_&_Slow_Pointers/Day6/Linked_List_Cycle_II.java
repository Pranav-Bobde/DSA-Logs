//Link: https://leetcode.com/problems/linked-list-cycle-ii/

//Time & Space: O(N) O(1)

public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null || (head.next == head)) return head;
        if(head.next == null) return null;
        
        ListNode s = head, f = head;
        
        do{
            s = s.next;
            f = f.next.next;
        }while(f!=null && f.next!=null && f!=s);
        
        if(f==null || f.next==null) return null;
        
        f = head;
        while(f!=s){
            f = f.next;
            s = s.next;
        }
        return f;
    }
}
