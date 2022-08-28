//Link: https://leetcode.com/problems/copy-list-with-random-pointer/

//Time & Space: O(N) O(1)

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null) return head;
        Node temp = head;
        while(temp!=null){
            Node node = new Node(temp.val);
            Node nxt = temp.next;
            temp.next = node;
            node.next = nxt;
            temp = nxt;
        }
        
        temp = head;
        while(temp!=null){
            if(temp.random!=null)
                temp.next.random = temp.random.next;
            else
                temp.next.random = null;
            temp = temp.next.next;
        }
        
        temp = head;
        Node h1 = null, t1 = null, t3 = temp.next.next;
        while(temp!=null){
            if(h1==null){
                h1 = temp.next;
                t1 = h1;
            }else{
                t1.next = temp.next;
                t1 = t1.next;
            }
            temp.next = t3;
            temp = t3;
            if(temp == null) break;
            t3 = t3.next.next;
        }
        return h1;
    }
}
