//Link: https://www.interviewbit.com/problems/sort-binary-linked-list/

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
    void swap(ListNode p1, ListNode p2){
        int temp = p1.val;
        p1.val = p2.val;
        p2.val = temp;
    }
    public ListNode solve(ListNode A) {
        ListNode p1 = A, p2 = A;
        while(p2!=null){
            if(p2.val == 0){
                swap(p1, p2);
                p1 = p1.next;
            }
            p2 = p2.next;
        }
        return A;
    }
}
