//Link: https://leetcode.com/problems/rotate-list/

//Time & Space: O(N) O(1)

class Solution {
    ListNode reverse(ListNode head){
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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || k==0) return head;
        ListNode temp = head;
        int len = 0;
        while(temp!=null)
        {
            len++;
            temp = temp.next;
        }
        k%=len;
        if(k==0) return head;
        ListNode fullRev = reverse(head);
        int j = k-1;
        temp = fullRev;
        while(j-->0){
            temp = temp.next;
        }
        ListNode l2 = temp.next;
        temp.next = null;
        ListNode rl1 = reverse(fullRev);
        ListNode rl2 = reverse(l2);
        temp = rl1;
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next = rl2;
        return rl1;
    }
}
