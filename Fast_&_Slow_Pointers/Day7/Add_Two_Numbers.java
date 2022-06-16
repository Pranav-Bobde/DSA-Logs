//Link: https://leetcode.com/problems/add-two-numbers/

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, t = head;
        
        int carry = 0;
        while(l1!=null && l2!=null){
            int x = (l1.val + l2.val + carry)%10;
            carry = (l1.val + l2.val + carry)/10;
            if(head == null){
                head = new ListNode(x);
                t = head;
            }else{
                t.next = new ListNode(x);
                t = t.next;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        
        while(l1!=null){
            int x = (l1.val + carry)%10;
            carry = (l1.val + carry)/10;
            t.next = new ListNode(x);
            t = t.next;
            l1 = l1.next;
        }
        
        while(l2!=null){
            int x = (l2.val + carry)%10;
            carry = (l2.val + carry)/10;
            t.next = new ListNode(x);
            t = t.next;
            l2 = l2.next;
        }
        if(carry!=0){
            t.next = new ListNode(carry);
            t = t.next;
        }
        return head;
    }
}
