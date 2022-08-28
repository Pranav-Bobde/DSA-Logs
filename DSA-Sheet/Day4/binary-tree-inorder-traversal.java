//Link: https://leetcode.com/problems/binary-tree-inorder-traversal/

//Time & Space: O(N) O(logN)

class Solution {
    List<Integer> ans = new ArrayList<>();
    void dfs(TreeNode root){
        if(root==null) return;
        dfs(root.left);
        ans.add(root.val);
        dfs(root.right);
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        dfs(root);
        return ans;
    }
}
