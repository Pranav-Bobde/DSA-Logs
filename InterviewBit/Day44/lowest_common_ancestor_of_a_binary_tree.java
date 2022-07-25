//Link: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/

//Time & Space Complexity: O(N) O(N)

class Solution {
    boolean dfs(TreeNode root, TreeNode p, TreeNode q, TreeNode[] res){
        if(root == null) return false;
        boolean left = dfs(root.left, p, q, res);
        boolean right = dfs(root.right, p, q, res);
        boolean self = (root==p || root==q);
        if(res[0]==null){
            if((left & right) || ((left | right) & self)){
                res[0] = root;
            }
        }
        
        return (left | right | self);
    }
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode[] res = new TreeNode[]{null};
        dfs(root, p, q, res);
        return res[0];
    }
}
