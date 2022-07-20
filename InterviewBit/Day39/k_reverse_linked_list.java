//Link: https://www.interviewbit.com/problems/k-reverse-linked-list/

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
    ListNode getKth(ListNode curr, int k){
        while(curr!=null && k-->0){
            curr = curr.next;
        }
        return curr;
    }
    public ListNode reverseList(ListNode head, int k) {
        if(head==null || head.next == null) return head;
        ListNode dummy = new ListNode(0), grpPrev = dummy;
        dummy.next = head;
        while(true){
            ListNode kth = getKth(grpPrev, k);
            if(kth == null)
                break;
            ListNode grpNext = kth.next;
            ListNode curr = grpPrev.next, prev = grpNext;
            while(curr!=grpNext){
                ListNode nxt = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nxt;
            }
            ListNode temp = grpPrev.next;
            grpPrev.next = kth;
            grpPrev = temp;
        }
        return dummy.next;
    }
}


//Time & Space Complexity: O(N) O(N)
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode A, int B) {
        ListNode current = A;
        ListNode next = null;
        ListNode prev = null;
        
        int count = 0;

        while (count < B && current != null) {
           next = current.next;
           current.next = prev;
           prev = current;
           current = next;
           count++;
        }

        if (next != null) 
          A.next = reverseList(next, B);

        return prev;
    }
}
