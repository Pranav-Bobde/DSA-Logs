//Link: https://practice.geeksforgeeks.org/problems/minimum-number-of-deletions-and-insertions0209/1

//Time & Space Complexity: O(N*M) O(N*M)

class Solution
{
	public int minOperations(String s1, String s2) 
	{ 
	    int n = s1.length(), m = s2.length();
        int[][] dp = new int[n+1][m+1];
        for(int i=1; i<n+1; i++){
            for(int j=1; j<m+1; j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return m+n-2*dp[n][m];
	}
}
