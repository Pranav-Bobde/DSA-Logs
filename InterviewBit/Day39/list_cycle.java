//Link: https://www.interviewbit.com/problems/list-cycle/

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
	public ListNode detectCycle(ListNode a) {
        if(a==null || a.next == a) return a;
        if(a.next == null) return null;
        ListNode s = a, f = a;
        do{
            s = s.next;
            f = f.next.next;
        }
        while( (s!=f) && (f!=null && f.next!=null) );
        if(s==f){
            f = a;
            while(s!=f){
                f = f.next;
                s = s.next;
            }
            return s;
        }else{
            return null;
        }
	}
}
