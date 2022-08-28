//Link: https://leetcode.com/problems/maximum-width-of-binary-tree/

//Time & Space: O(N) O(N)

class Solution {
    int ans = 0;
    Map<Integer, Integer> lp = new HashMap<>();
    public int widthOfBinaryTree(TreeNode root) {
        solve(root, 0, 0);
        return ans;
    }
    void solve(TreeNode root, int d, int p){
        if(root==null) return;
        lp.computeIfAbsent(d, x->p);
        ans = Math.max(ans, p-lp.get(d)+1);
        solve(root.left, d+1, 2*p);
        solve(root.right, d+1, 2*p+1);
    }
}
