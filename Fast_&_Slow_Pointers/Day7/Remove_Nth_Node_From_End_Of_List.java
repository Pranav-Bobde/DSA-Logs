//Link: https://leetcode.com/problems/remove-nth-node-from-end-of-list/

//Time & Space: O(N) O(1)

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int k) {
        int n = 0;
        ListNode temp = head;
        while(temp != null) {temp = temp.next;n++;}
        
        if(k>n) return null;
        if(k==n) return head.next;
        
        temp = head;
        int c = 0;
        while(temp!=null && c<(n-k-1)){
            temp = temp.next;
            c++;
        }
        
        temp.next = temp.next.next;
        
        return head;
    }
}
