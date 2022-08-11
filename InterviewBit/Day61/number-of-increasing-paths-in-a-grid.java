//Link: https://leetcode.com/contest/weekly-contest-300/problems/number-of-increasing-paths-in-a-grid/

//Time & Space Complexity: O(3^(max(m, n))) => O(4*m*n); O(m*n)

class Solution {
	private long[][] dp;
	private int mod = (int)1e9+7;

	public int countPaths(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;

		dp = new long[m][n];

		long ans = 0L;
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				ans = (ans + dfs(grid,i,j,0)) % mod;
			}
		}
		return (int)ans;
	}
	private long dfs(int[][] grid,int i,int j,int previousVal){

		if(i<0||j<0||i>=grid.length||j>=grid[0].length||grid[i][j]<=previousVal) return 0;

		if(dp[i][j]>0) return dp[i][j];

		dp[i][j] = 1;

		long bottom = dfs(grid,i+1,j,grid[i][j]);
		long right = dfs(grid,i,j+1,grid[i][j]);
		long up = dfs(grid,i-1,j,grid[i][j]);
		long left = dfs(grid,i,j-1,grid[i][j]);

		dp[i][j] = (dp[i][j] + right + bottom + up + left)%mod;
		return dp[i][j];
	}
}
