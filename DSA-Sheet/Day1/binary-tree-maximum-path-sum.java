//Link: https://leetcode.com/problems/binary-tree-maximum-path-sum/

//Time & Space Complexity: O(N) O(1)

class Solution {
    int ans = Integer.MIN_VALUE;
    int solve(TreeNode root){
        if(root==null) return 0;
        if(root.left==null && root.right==null) {
            ans = Math.max(ans, root.val);
            return root.val;
        }
        int left = solve(root.left);
        int right = solve(root.right);
        int curr = root.val;
        int all = left + right + curr;
        ans = Math.max(
            left + curr,
            Math.max(
                right + curr,
                Math.max(
                    curr,
                    Math.max(
                        ans,
                        all
                    )
                )
            )
        );
        
        return Math.max(left+curr, Math.max(curr, right+curr));
    }
    public int maxPathSum(TreeNode root) {
        solve(root);
        return ans;
    }
}
