//Link: https://leetcode.com/problems/palindrome-linked-list/

//Time & Space: O(N) O(1)

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

// or modular code

class Solution {
    boolean isPalindrome(ListNode head) 
    {
        if(head == null || head.next == null) return true;
        //Your code here
        ListNode mHead = getMid(head);
        mHead = reverse(mHead);
        while(head!= null && mHead!=null)
        {
            if(head.val != mHead.val)
            {
                return false;
            }
            head = head.next;
            mHead = mHead.next;
        }
        return true;
        
    }    
    static ListNode getMid(ListNode head)
    {
        ListNode f = head;
        ListNode s = head;
        while(f!=null && f.next!=null)
        {
            s = s.next;
            f = f.next.next;
        }
        ListNode temp = head;
        while(temp.next != s)
            temp = temp.next;
        temp.next = null;
        return s;
    }
    static ListNode reverse(ListNode head)
    {
        if(head == null || head.next == null) return head;
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = head.next;
        while(curr!=null)
        {
            curr.next = prev;
            prev = curr;
            curr = next;
            if(next!=null)
                next = next.next;
        }
        return prev;
    }
}
