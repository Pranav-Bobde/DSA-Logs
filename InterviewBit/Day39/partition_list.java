//Link: https://www.interviewbit.com/problems/partition-list/

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
    public ListNode partition(ListNode A, int x) {
        if(A == null || A.next == null) return A;
        ListNode l1head = new ListNode(0), l1 = l1head;
        ListNode l2head = new ListNode(0), l2 = l2head;
        ListNode t = A;
        while(t!=null){
            if(t.val < x){
                l1.next = t;
                l1 = l1.next;
            }else{
                l2.next = t;
                l2 = l2.next;
            }
            t = t.next;
        }
        l1.next = l2head.next;
        l2.next = null;
        return l1head.next;
    }
}
