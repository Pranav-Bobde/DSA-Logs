//Link: https://www.interviewbit.com/problems/reverse-alternate-k-nodes/

//Time & Space Complexity: O(N) O(B)

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode solve(ListNode A, int B) {
        if(A==null || A.next==null) return A;
        ListNode head = A, t = A;
        Stack<Integer> s = new Stack<>();
        int k = B, c = 0;
        while(head!=null){
            k=B;
            if( (c&1) == 0 ){
                while(head!=null && k-->0){
                    s.push(head.val);
                    head = head.next;
                }
                while(t!=head){
                    t.val = s.pop();
                    t = t.next;
                }
            }else{
                while(head!=null && k-->0){
                    s.push(head.val);
                    head = head.next;
                }
                t = head;
            }
            c++;
        }
        return A;
    }
}
