//Link: https://leetcode.com/contest/weekly-contest-305/problems/longest-ideal-subsequence/

// Time & Space Complexity: O(K*N) O(1)

class Solution {
    public int longestIdealString(String s, int k) {
        int ans = 0;
        int[] dp = new int[26];
        for(int i=0; i<s.length(); i++){
            int curr = s.charAt(i)-'a';
            for(int j=curr; j>=0 && j>=curr-k; j--){
                if(j==curr && dp[curr]==0){
                    dp[j]=1;
                    ans = Math.max(ans, dp[curr]);
                    continue;
                }
                dp[curr] = Math.max(dp[curr], dp[j]+1);
            }
            
            for(int j=curr+1; j<26 && j<=curr+k; j++){
                dp[curr] = Math.max(dp[curr], dp[j]+1);
            }
            ans = Math.max(ans, dp[curr]);
        }
        return ans;
    }
}
