//Link: https://leetcode.com/problems/binary-tree-maximum-path-sum/

//Time & Space Complexity: O(N) O(N)

class Solution {
    int dfs(TreeNode root, int[] res){
        if(root==null) return 0;
        int left = dfs(root.left, res);
        int right = dfs(root.right, res);
        int temp = Math.max( Math.max(left, right) + root.val, root.val );
        int ans = Math.max(temp, left+right+root.val);
        res[0] = Math.max(res[0], ans);
        return temp;
    }
    public int maxPathSum(TreeNode root) {
        int[] res = new int[]{Integer.MIN_VALUE};
        dfs(root, res);
        return res[0];
    }
}
