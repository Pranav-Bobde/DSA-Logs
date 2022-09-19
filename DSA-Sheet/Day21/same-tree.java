//Link: https://leetcode.com/problems/same-tree/

//Time & Space: O(N) O(N)
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null) return true;
        if(p==null || q==null) return false;
        if(p.val!=q.val) return false;
        return isSameTree(p.left, q.left) & isSameTree(p.right, q.right);
    }
}

//Time & Space: O(N) O(N)
class Solution {
    void solve(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append("null");
            return;
        }
        sb.append(root.val);
        solve(root.left, sb);
        solve(root.right, sb);
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        StringBuilder sb1 = new StringBuilder();
        solve(p, sb1);
        StringBuilder sb2 = new StringBuilder();
        solve(q, sb2);
        return sb1.toString().equals(sb2.toString());
    }
}
