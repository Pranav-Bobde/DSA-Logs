//Link: https://leetcode.com/problems/reorder-list/

//Time & Space: O(N) O(1)

class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        
        ListNode mid = middleNode(head);
        ListNode h2 = reverseList(mid);
        ListNode t11 = head, t12 = head.next;
        ListNode t21 = h2, t22 = h2.next;
        
        while(t11!=null){
            t11.next = t21;
            if(t12 == null && t22 != null){
                break;
            }
            t21.next = t12;
            t11 = t12;
            t21 = t22;
            if(t11 == null) break;
            t12 = t12.next;
            t22 = t22.next;
        }
        
    }
    
    public ListNode middleNode(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode s = head, f = head, prev = null;
        
        do{
            prev = s;
            s = s.next;
            f = f.next.next;
        }while(f!=null && f.next!=null);
        prev.next = null;
        return s;
    }
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        if(head == null || head.next == null) return head;
        ListNode nxt = head.next;
        
        while(curr != null){
            curr.next = prev;
            prev = curr;
            curr = nxt;
            if(curr == null) return prev;
            nxt = nxt.next;
        }
        
        return prev;
    }
}
