//Link: https://leetcode.com/problems/merge-two-sorted-lists/

//Time & Space: O(max(N, M)) O(N+M)

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null) return list2;
        if(list2==null) return list1;
        ListNode head = null, p = head;
        while(list1!=null && list2!=null){
            if(list1.val <= list2.val){
                if(head == null){
                    head = new ListNode(list1.val);
                    p = head;
                }else{
                    p.next = new ListNode(list1.val);
                    p = p.next;
                }
                list1 = list1.next;
            }else{
                if(head == null){
                    head = new ListNode(list2.val);
                    p = head;
                }else{
                    p.next = new ListNode(list2.val);
                    p = p.next;
                }
                list2 = list2.next;
            }
        }
        while(list1!=null){
            p.next = new ListNode(list1.val);
            p = p.next;
            list1 = list1.next;
        }
        while(list2!=null){
            p.next = new ListNode(list2.val);
            p = p.next;
            list2 = list2.next;
        }
        return head;
    }
}
