//Link: https://leetcode.com/problems/populating-next-right-pointers-in-each-node/

//Time & Space: O(N) O(N)
class Solution {
    public Node connect(Node root) {
        if(root == null || (root.left==null && root.right==null)) return root;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        Node prevR = null;
        while(!q.isEmpty()){
            Node curr = q.poll();
            if(curr!=null){
                if(curr.left!=null){
                    q.add(curr.left);
                    curr.left.next = curr.right;
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
                if(prevR!=null) prevR.next = curr.left;
                prevR = curr.right;
            }else{
                if(!q.isEmpty()){
                    prevR = null;
                    q.add(null);
                }
            }
        }
        return root;
    }
}

//Time & Space: O(N) O(N)
class Solution {
    public Node connect(Node root) {
        if(root == null || (root.left==null && root.right==null)) return root;
        ArrayList<Node> al = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            Node curr = q.poll();
            al.add(curr);
            if(curr!=null){
                if(curr.left!=null){
                    q.add(curr.left);
                    curr.left.next = curr.right;
                }
                if(curr.right!=null)
                    q.add(curr.right);
            }else{
                if(!q.isEmpty()){
                    q.add(null);
                }
            }
        }
        for(int i=0; i<al.size()-1; i++){
            if(al.get(i)!=null){
                al.get(i).next=al.get(i+1);
            }
        }
        return root;
    }
}
