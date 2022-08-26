//Link: https://leetcode.com/problems/intersection-of-two-linked-lists/

//Time & Space: O(N+M) O(1)
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode t1 = headA, t2 = headB;
        while(t1!=t2){
            t1 = t1==null ? headB : t1.next;
            t2 = t2==null ? headA : t2.next;
        }
        return t1;
    }
}

//Time & Space: O(N+M) O(N)
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Map<ListNode, Boolean> map = new HashMap<>();
        ListNode temp = headA;
        while(temp!=null){
            map.put(temp, true);
            temp = temp.next;
        }
        
        temp = headB;
        while(temp!=null){
            if(map.get(temp)!=null && map.get(temp)==true){
                return temp;
            }
            
            temp = temp.next;
        }
        return null;
    }
}
