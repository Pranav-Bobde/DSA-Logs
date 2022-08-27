//Link: https://leetcode.com/problems/diameter-of-binary-tree/

//Time & Space: O(N) O(1)

class Solution {
    int ans = 0;
    int solve(TreeNode root){
        if(root==null) return -1;
        if(root.left==null && root.right==null) return 0;
        int left = solve(root.left);
        int right = solve(root.right);
        ans = Math.max(
            ans,
            Math.max(
                left+1,
                Math.max(
                    right+1,
                    left+1+right+1
                )
            )
        );
        return Math.max(left, right)+1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        solve(root);
        return ans;
    }
}
