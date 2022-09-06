//Link: https://practice.geeksforgeeks.org/problems/flattening-a-linked-list/1

//Time & Space: O(N) O(N)

class GfG
{
    Node merge(Node l1, Node l2){
        Node temp = new Node(0);
        Node res = temp;
        while(l1!=null && l2!=null){
            if(l1.data <= l2.data){
                temp.bottom = l1;
                l1 = l1.bottom;
            }else{
                temp.bottom = l2;
                l2 = l2.bottom;
            }
            temp = temp.bottom;
        }
        if(l1!=null) temp.bottom = l1;
        else temp.bottom = l2;
        return res.bottom;
    }
    Node flatten(Node root)
    {
	    if(root == null || root.next == null) return root;
	    root.next = flatten(root.next);
	    root = merge(root, root.next);
	    return root;
    }
}
