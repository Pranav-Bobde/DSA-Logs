//Link: https://leetcode.com/problems/binary-tree-preorder-traversal/

//Time & Space: O(N) O(logN)

class Solution {
    List<Integer> ans = new ArrayList<>();
    void dfs(TreeNode root){
        if(root==null) return;
        ans.add(root.val);
        dfs(root.left);
        dfs(root.right);
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        dfs(root);
        return ans;
    }
}
