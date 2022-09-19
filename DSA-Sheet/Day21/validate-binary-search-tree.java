//Link: https://leetcode.com/problems/validate-binary-search-tree/

//Time & Space: O(N) O(N)

class Solution {
    boolean solve(TreeNode root, long min, long max){
        if(root == null) return true;
        if(root.val > min && root.val < max){
            if(solve(root.left, min, root.val) & solve(root.right, root.val, max)){
                return true;
            }
        }
        return false;
    }
    public boolean isValidBST(TreeNode root) {
        return solve(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}
