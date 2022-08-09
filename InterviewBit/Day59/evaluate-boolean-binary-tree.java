//Link: https://leetcode.com/contest/biweekly-contest-82/problems/evaluate-boolean-binary-tree/

//Time & Space Complexity: O(N) O(LogN)

class Solution {
    boolean dfs(TreeNode root){
        if(root.left == null && root.right == null){
            if(root.val == 0) return false;
            else return true;
        }
        
        if(root.val==2){
            return dfs(root.left) | dfs(root.right);
        }
        return dfs(root.left) & dfs(root.right);
        
    }
    public boolean evaluateTree(TreeNode root) {
        return dfs(root);
    }
}
