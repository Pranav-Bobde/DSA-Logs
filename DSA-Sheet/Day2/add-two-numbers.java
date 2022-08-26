//Link: https://leetcode.com/problems/add-two-numbers/

//Time & Space: O(N) O(1); N->max of len(l1, l2)

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int c = 0;
        ListNode head = null, temp = head;
        while(l1!=null && l2!=null){
            int sum = l1.val + l2.val + c;
            c = sum/10;
            ListNode toAdd = new ListNode(sum%10);
            if(head == null){
                head = toAdd;
                temp = head;
            }else{
                temp.next = toAdd;
                temp = temp.next;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1!=null){
            int sum = l1.val + c;
            c = sum/10;
            ListNode toAdd = new ListNode(sum%10);
            temp.next = toAdd;
            temp = temp.next;
            l1 = l1.next;
        }
        while(l2!=null){
            int sum = l2.val + c;
            c = sum/10;
            ListNode toAdd = new ListNode(sum%10);
            temp.next = toAdd;
            temp = temp.next;
            l2 = l2.next;
        }
        if(c!=0){
            ListNode toAdd = new ListNode(c);
            temp.next = toAdd;
        }
        
        return head;
    }
}
