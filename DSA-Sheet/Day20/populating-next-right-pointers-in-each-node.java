//Link: https://leetcode.com/problems/populating-next-right-pointers-in-each-node/

//Time & Space: O(N) O(W); W: max width

class Solution {
    public Node connect(Node root) {
        if(root == null || (root.left==null && root.right==null)) return root;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int n = q.size();
            while(n-->0){
                Node node = q.poll();
                if(node.left!=null){
                    q.add(node.left);
                }
                if(node.right!=null){
                    q.add(node.right);
                }
                if(n>0)
                    node.next = q.peek();
            }
        }
        return root;
    }
}
