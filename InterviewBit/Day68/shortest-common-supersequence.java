//Link: https://practice.geeksforgeeks.org/problems/shortest-common-supersequence0322/1

//Time & Space Complexity: O(N*M) O(N*M)

class Solution
{
    //Function to find length of shortest common supersequence of two strings.
    public static int shortestCommonSupersequence(String s1,String s2,int n,int m)
    {
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
        return m+n-dp[n][m];
    }
}
