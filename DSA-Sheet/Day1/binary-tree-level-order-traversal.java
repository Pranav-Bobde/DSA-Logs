//Link: https://leetcode.com/problems/binary-tree-level-order-traversal/

//Time & Space Complexity: O(N) O(W); W-> Max-Width

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(root==null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        List<Integer> list = new ArrayList<>();
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr!=null){
                list.add(curr.val);
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
            }else{
                ans.add(list);
                list = new ArrayList<>();
                if(!q.isEmpty())
                    q.add(null);
            }
        }
        return ans;
    }
}
