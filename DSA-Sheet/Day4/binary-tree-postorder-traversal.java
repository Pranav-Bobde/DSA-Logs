//Link: https://leetcode.com/problems/binary-tree-postorder-traversal/

//Time & Space: O() O()

class Solution {
    List<Integer> ans = new ArrayList<>();
    void dfs(TreeNode root){
        if(root==null) return;
        dfs(root.left);
        dfs(root.right);
        ans.add(root.val);
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        dfs(root);
        return ans;
    }
}
