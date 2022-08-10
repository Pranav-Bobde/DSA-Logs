//Link: https://leetcode.com/contest/weekly-contest-300/problems/spiral-matrix-iv/

//Time & Space Complexity: O(M*N) O(M*N)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] mat = new int[m][n];
        for(int[] arr : mat){
            Arrays.fill(arr, -1);
        }
        int rs = 0, re = m-1, cs = 0, ce = n-1;
        
        while(rs<=re && cs<=ce){
            // System.out.println("re: "+re+" rs: "+rs+" head: "+head.val);
            for(int i=cs; i<=ce && head!=null; i++) {
                mat[rs][i] = head.val;
                head = head.next;
            }
            if(head==null) break;
            rs++;
            for(int i=rs; i<=re  && head!=null; i++) {
                mat[i][ce] = head.val;
                head = head.next;
            }
            if(head==null) break;
            ce--;
            for(int i=ce; i>=cs  && head!=null; i--) {
                mat[re][i] = head.val;
                head = head.next;
            }
            if(head==null) break;
            re--;
            for(int i=re; i>=rs  && head!=null; i--) {
                mat[i][cs] = head.val;
                head = head.next;
            }
            if(head==null) break;
            cs++;
        }
        
        return mat;
    }
}
