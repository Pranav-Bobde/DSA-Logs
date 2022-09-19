//Link: https://leetcode.com/problems/balanced-binary-tree/

//Time & Space: O(N) O(N)
class Solution {
    boolean ans = true;
    int h(TreeNode root){
        if(root == null) return 0;
        int left = h(root.left);
        int right = h(root.right);
        if(Math.abs(left - right) > 1){
            ans = false;
        }
        return Math.max(left, right) + 1;
    }
    public boolean isBalanced(TreeNode root) {
        h(root);
        return ans;
    }
}

//Time & Space: O(N^2) O(N)
class Solution {
    int h(TreeNode root){
        if(root == null) return 0;
        int left = h(root.left);
        int right = h(root.right);
        return Math.max(left, right) + 1;
    }
    boolean solve(TreeNode root){
        if(root == null) return true;
        boolean left = solve(root.left);
        boolean right = solve(root.right);
        if(!(left & right)){
            return false;
        }
        if(Math.abs(h(root.left) - h(root.right)) > 1){
            return false;
        }
        return true;
    }
    public boolean isBalanced(TreeNode root) {
        return solve(root);
    }
}
