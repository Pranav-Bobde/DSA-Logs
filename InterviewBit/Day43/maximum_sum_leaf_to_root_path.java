//Link: https://practice.geeksforgeeks.org/problems/maximum-sum-leaf-to-root-path/1

//Time & Space Complexity: O(N) O(N)

class Solution
{
    static int dfs(Node root){
        if(root == null)
            return Integer.MIN_VALUE;
        if(root.left == null && root.right == null)
            return root.data;
        return root.data + Math.max(dfs(root.left), dfs(root.right));
    }
    
    public static int maxPathSum(Node root)
    {
        return dfs(root);
    }
}
