///Link: https://www.hackerrank.com/challenges/tree-height-of-a-binary-tree/problem

//Time & Space Complexity: O(N) O(N)

static void dfs(Node root, int[] ans, int d){
        if(root==null) return;
        if(root.left==null && root.right==null){
            ans[0] = Math.max(ans[0], d);
            return;
        }
        dfs(root.left, ans,d+1);
        dfs(root.right, ans, d+1);
    }
	public static int height(Node root) {
      	// Write your code here.
        if(root==null) return 0;
        if(root.left==null && root.right==null) return 0;
        int[] ans = new int[]{0};
        dfs(root, ans, 0);
        return ans[0];
             
    }
