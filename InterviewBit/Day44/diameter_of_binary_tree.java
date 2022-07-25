//Link: https://leetcode.com/problems/diameter-of-binary-tree/

//Time & Space Complexity: O(N) O(N)

class Solution {
    
    int dfs(TreeNode root, int[] res){
        if(root == null) return 0;
        int left = dfs(root.left, res);
        int right = dfs(root.right, res);
        int temp = 1 + Math.max(left, right);
        int ans = Math.max(temp, 1+left+right);
        res[0] = Math.max(res[0], ans);
        return temp;
    }
    
    public int diameterOfBinaryTree(TreeNode root) {
        int[] res = new int[]{Integer.MIN_VALUE};
        dfs(root, res);
        return res[0]-1; 
    }
}
