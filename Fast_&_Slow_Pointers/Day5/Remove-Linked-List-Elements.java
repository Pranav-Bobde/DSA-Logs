//Link: https://leetcode.com/problems/remove-linked-list-elements/

//Time & Space: O(N) O(1)

class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null || (head.next == null && head.val == val)) return null;
        
        ListNode temp = head;
        
        while(head!=null && head.val==val)
            head = head.next;
        if(head==null) return null;
        while(temp!=null && temp.next!=null){
            if(temp.next.val == val){
                temp.next = temp.next.next;
            }else
                temp = temp.next;
        }
        if(head.next == null && head.val == val) return null;
        return head;
    }
}
