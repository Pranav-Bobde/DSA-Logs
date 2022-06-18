//Link: https://leetcode.com/problems/counting-bits/

//Time & Space Complexity: O(N) O(N)

class Solution {
    public int[] countBits(int n) {
        int[] dp = new int[n+1];
        int offset = 1;
        for(int i=1; i<=n; i++){
            if(offset * 2 == i){
                offset = i;
            }
            dp[i] = 1 + dp[i-offset];
        }
        return dp;
    }
}
