//Link: https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/

//Time & Space: O(N) O(logN)

class Solution {
    TreeNode solve(int i, int j, int[] arr){
        if(i>j) return null;
        int mid = (i+j)/2;
        TreeNode root = new TreeNode(arr[mid]);
        root.left = solve(i, mid-1, arr);
        root.right = solve(mid+1, j, arr);
        return root;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length;
        return solve(0, n-1, nums);
    }
}
