//Link: https://leetcode.com/problems/palindrome-linked-list/

//Time & Space: O() O()

class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null) return false;
        if(head.next == null) return true;
        
        int n = 0;
        
        ListNode s = head, f = head;
        
        while(s!=null){
            s=s.next;
            n++;
        }
        
        s=head;
        ListNode prev = null, nxt = head.next;
        while(f!=null && f.next!=null){
            f=f.next.next;
            s.next = prev;
            prev = s;
            s = nxt;
            nxt=nxt.next;
        }
        
        if((n&1) == 1){
            s = s.next;
        }
        while(s!=null && prev!=null){
            if(s.val != prev.val) return false;
            s = s.next;
            prev = prev.next;
        }
        return true;
    }
}
