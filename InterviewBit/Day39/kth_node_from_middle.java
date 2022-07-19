//Link: https://www.interviewbit.com/problems/kth-node-from-middle/

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
    public int solve(ListNode A, int x) {
        if(A==null || A.next == null) return -1;
        int n = 0;
        ListNode temp = A;
        while(temp!=null){
            n++;
            temp = temp.next;
        }
        int mid = (n/2) + 1;
        if(x >= mid)
            return -1;
        temp = A;
        int j = mid - (x+1);
        while(j>0){
            j--;
            temp = temp.next;
        }
        return temp.val;
    }
}
