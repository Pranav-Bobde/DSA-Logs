//Link: https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/

//Time & Space: O(N) O(N)

class Solution {
    TreeNode solve(int i, int j, int[] arr, int n){
        if(i==j) return new TreeNode(arr[i]);
        if(i<n && i<j){
            TreeNode root = new TreeNode(arr[i]);
            if(arr[i+1] > arr[i]){
                
            }
            int s=i+1, e = i+1;
            while(e<n && arr[e] < root.val){
                e++;
            }
            root.left = solve(s, e-1, arr, n);
            root.right = solve(e, j, arr, n);
            return root;
        }
        return null;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        int n = preorder.length;
        return solve(0, n-1, preorder, n);
    }
}
