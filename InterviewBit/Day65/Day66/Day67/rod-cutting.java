//Link: https://practice.geeksforgeeks.org/problems/rod-cutting0840/1

//Time & Space Complexity: O(N*K) O(N*K)

class Solution{
    public int cutRod(int price[], int n) {
        int N = price.length;
        int[][] dp = new int[N+1][n+1];
        for(int i=1; i<=N; i++){
            for(int j=1; j<=n; j++){
                if(i<=j){
                    dp[i][j] = Math.max(dp[i-1][j], price[i-1]+dp[i][j-i]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[N][n];
    }
}
