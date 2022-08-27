//Link: https://leetcode.com/problems/reverse-nodes-in-k-group/

//Time & Space: O(N) O(N/K)

class Solution {
    ListNode reverse(ListNode root){
        ListNode prev = null, curr = root, next = root.next;
        while(curr!=null){
            curr.next = prev;
            prev = curr;
            curr = next;
            if(curr==null) return prev;
            next = next.next;
        }
        return prev;
    }
    
    ListNode rev(ListNode root, int k){
        ListNode temp = root;
        int t = k;
        while(t-->1 && temp!=null){
            temp = temp.next;
        }
        if(temp==null) return root;
        if(temp.next==null) return reverse(root);
        ListNode ret = rev(temp.next, k);
        temp.next = null;
        ListNode rr = reverse(root);
        temp = rr;
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next = ret;
        return rr;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null || head.next==null) return head;
        return rev(head, k);
    }
}
