//Link: https://leetcode.com/problems/maximum-width-of-binary-tree/

//Time & Space: O(N) O(N)
class Solution {
    class Node{
        TreeNode node;
        int pos;
        Node(TreeNode n, int p){
            node = n;
            pos = p;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(root, 0));
        int ans = 0;
        while(!q.isEmpty()){
            int l = 0, r = 0, min = 0;
            int s = q.size();
            for(int i=0; i<s; i++){
                Node node = q.poll();
                if(i==0){
                    l = node.pos;
                    min = node.pos;
                }
                if(i==s-1) r = node.pos;
                if(node.node.left!=null) q.add(new Node(node.node.left, 2*(node.pos-min)+1));
                if(node.node.right!=null) q.add(new Node(node.node.right, 2*(node.pos-min)+2));
            }
            ans = Math.max(ans, r-l+1);
        }
        return ans;
    }
}

//Time & Space: O(N) O(N)
class Solution {
    int ans = 0;
    Map<Integer, Integer> lp = new HashMap<>();
    public int widthOfBinaryTree(TreeNode root) {
        solve(root, 0, 0);
        return ans;
    }
    void solve(TreeNode root, int d, int p){
        if(root==null) return;
        lp.computeIfAbsent(d, x->p);
        ans = Math.max(ans, p-lp.get(d)+1);
        solve(root.left, d+1, 2*p);
        solve(root.right, d+1, 2*p+1);
    }
}
