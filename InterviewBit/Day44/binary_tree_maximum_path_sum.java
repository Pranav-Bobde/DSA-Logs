//Link: https://leetcode.com/problems/binary-tree-maximum-path-sum/

//Time & Space Complexity: O(N) O(N)

class Solution {
    int dfs(TreeNode root, int[] res){
        if(root==null) return -3001;
        int left = dfs(root.left, res);
        int right = dfs(root.right, res);
        int temp = Math.max( Math.max(left, right) + root.val, root.val );
        res[0] = Math.max(res[0], (left<0?0:left)+(right<0?0:right)+root.val);
        return temp;
    }
    public int maxPathSum(TreeNode root) {
        int[] res = new int[]{-3001};
        dfs(root, res);
        return res[0];
    }
}
