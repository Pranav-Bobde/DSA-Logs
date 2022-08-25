//Link: https://leetcode.com/problems/maximum-depth-of-binary-tree/

//Time & Space Complexity: O(N) O(1)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int min = 0;
    void dfs(TreeNode root, int d){
        min = Math.max(min, d);
        if(root == null) return;
        dfs(root.left, d+1);
        dfs(root.right, d+1);
    }
    public int maxDepth(TreeNode root) {
        dfs(root, 0);
        return min;
    }
}
