//Link: https://leetcode.com/problems/remove-duplicates-from-sorted-list/

//Time & Space: O(N) O(1)

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode temp = head;
        
        while(temp!=null && temp.next!=null){
            if(temp.next.val == temp.val){
                temp.next = temp.next.next;
            }else{
                temp = temp.next;
            }
        }
        
        return head;
    }
}
