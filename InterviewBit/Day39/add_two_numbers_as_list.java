//Link: https://www.interviewbit.com/problems/add-two-numbers-as-lists/

//Time & Space Complexity: O(N) O(1)

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode A, ListNode B) {
        if(A==null)
            return B; 
        int carry = 0;
        ListNode head = new ListNode(0), t = head;
        while(A!=null && B!=null){
            int sum = A.val + B.val + carry;
            int val = sum % 10;
            ListNode node = new ListNode(val);
            t.next = node;
            t = t.next;
            carry = sum/10;
            A = A.next;
            B = B.next;
        }
        while(A!=null){
            int sum = A.val + carry;
            int val = sum % 10;
            ListNode node = new ListNode(val);
            t.next = node;
            t = t.next;
            carry = sum/10;
            A = A.next;
        }
        while(B!=null){
            int sum = B.val + carry;
            int val = sum % 10;
            ListNode node = new ListNode(val);
            t.next = node;
            t = t.next;
            carry = sum/10;
            B = B.next;
        }
        if(carry != 0){
            ListNode node = new ListNode(carry);
            t.next = node;
            t = t.next;
        }
        return head.next;
    }
}
