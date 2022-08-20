//Link: https://practice.geeksforgeeks.org/problems/number-of-coins1824/1

//Time & Space Complexity: O(N*M) O(N*M)

class Solution{

	public int minCoins(int coins[], int M, int V) 
	{ 
	    int n = coins.length;
	    int[][] dp = new int[n+1][V+1];
	    for(int j=1; j<=V; j++) dp[0][j] = Integer.MAX_VALUE - 1;
	    for(int i=1; i<=n; i++){
	        for(int j=1; j<=V; j++){
	            if(coins[i-1]<=j){
	                dp[i][j] = Math.min(1+dp[i][j-coins[i-1]], dp[i-1][j]);
	            }else{
	                dp[i][j] = dp[i-1][j];
	            }
	        }
	    }
	    return dp[n][V]>V?-1:dp[n][V];
	} 
}
