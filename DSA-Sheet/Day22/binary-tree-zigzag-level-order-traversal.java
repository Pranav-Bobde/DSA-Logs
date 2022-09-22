//Link: https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/

//Time & Space: O(N) O(N)

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(root==null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean rev = false;
        while(!q.isEmpty()){
            int n = q.size();
            List<Integer> al = new ArrayList<>();
            for(int i=0; i<n; i++){
                TreeNode node = q.poll();
                al.add(node.val);
                if(node.left!=null){
                    q.add(node.left);
                }
                if(node.right!=null){
                    q.add(node.right);
                }
            }
            if(rev){
                Collections.reverse(al);
            }
            ans.add(al);
            rev = !rev;
        }
        return ans;
    }
}
