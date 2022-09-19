//Link: https://leetcode.com/problems/maximum-width-of-binary-tree/

//Time & Space: O(N) O(W); W-> max width

class Node{
    int val;
    TreeNode node;
    Node(int v, TreeNode n){
        val = v;
        node = n;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        int ans = 0;
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, root));
        while(!q.isEmpty()){
            int n = q.size();
            int min = q.peek().val;
            int f = 0, l = 0;
            for(int i=0; i<n; i++){
                Node node = q.poll();
                int idx = node.val - min;
                TreeNode tnode = node.node;
                if(i==0){
                    f = idx;
                }
                if(i==n-1){
                    l = idx;
                }
                
                if(tnode.left!=null){
                    q.add(new Node(2*idx+1, tnode.left));
                }
                
                if(tnode.right!=null){
                    q.add(new Node(2*idx+2, tnode.right));
                }
                
            }
            ans = Math.max(ans, l-f+1);
        }
        return ans;
    }
}
