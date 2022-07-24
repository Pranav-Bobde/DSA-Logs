//Link: https://leetcode.com/problems/binary-tree-maximum-path-sum/

//Time & Space Complexity: O(N) O(N)

class Solution {
    int ans = -3001;
    int dfs(TreeNode root){
        if(root==null) return -3001;
        if(root.left == null && root.right == null) return root.val;
        int leftSum = dfs(root.left);
        int rightSum = dfs(root.right);
        int sum = root.val;
        if(leftSum!=-3001)
            sum+=leftSum;
        if(rightSum!=-3001)
            sum+=rightSum;
        ans = Math.max(
            ans,
            Math.max(
                root.val,
                Math.max(
                    sum,
                    Math.max(
                        leftSum,
                        rightSum
                    )
                )
            )
        );
        return Math.max(root.val, root.val + Math.max(leftSum, rightSum));
    }
    
    public int maxPathSum(TreeNode root) {
        if(root.left == null && root.right == null) return root.val;
        return Math.max(dfs(root), ans);
    }
}
