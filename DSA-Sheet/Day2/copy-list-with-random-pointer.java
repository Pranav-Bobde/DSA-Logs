//Link: https://leetcode.com/problems/copy-list-with-random-pointer/

//Time & Space: O(N) O(N)

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> oldNew = new HashMap<>();
        Node temp = head;
        while(temp != null){
            oldNew.put(temp, new Node(temp.val));
            temp = temp.next;
        }
        
        temp = head;
        while(temp!=null){
            if(temp.next!=null){
                Node node = oldNew.get(temp.next);
                oldNew.get(temp).next = node;
            }else{
                oldNew.get(temp).next = null;
            }
            if(temp.random!=null){
                Node node = oldNew.get(temp.random);
                oldNew.get(temp).random = node;
            }else{
                oldNew.get(temp).random = null;
            }
            
            temp = temp.next;
        }
        return oldNew.get(head);
    }
}
