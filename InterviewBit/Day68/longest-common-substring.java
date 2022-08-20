//Link: https://practice.geeksforgeeks.org/problems/longest-common-substring1452/1

//Time & Space Complexity: O(N*M) O(N*M)

class Solution{
    int longestCommonSubstr(String S1, String S2, int m, int n){
        int[][] dp = new int[m+1][n+1];
        int max = 0;
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(S1.charAt(i-1)==S2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                    if(dp[i][j]>max){
                        max = dp[i][j];
                    }
                }
            }
        }
        return max;
    }
}
