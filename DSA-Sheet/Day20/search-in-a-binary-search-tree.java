//Link: https://leetcode.com/problems/search-in-a-binary-search-tree/

//Time & Space: O(N) O(N)

class Solution {
    public TreeNode solve(TreeNode root, int val){
        if(root==null) return null;
        if(root.val == val) return root;
        if(val < root.val) return solve(root.left, val);
        
        return solve(root.right, val);
    }
    public TreeNode searchBST(TreeNode root, int val) {
        return solve(root, val);
    }
}
