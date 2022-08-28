//Link: https://leetcode.com/problems/delete-node-in-a-linked-list/

//Time & Space: O(N) O(1)

class Solution {
    public void deleteNode(ListNode node) {
        ListNode temp = node;
        while(temp.next.next!=null){
            temp.val = temp.next.val;
            temp = temp.next;
        }
        temp.val = temp.next.val;
        temp.next = null;
    }
}
