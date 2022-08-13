//Link: https://leetcode.com/contest/weekly-contest-299/problems/count-number-of-ways-to-place-houses/

//Time & Space Complexity: O(N) O(N)

class Solution {
    public int countHousePlacements(int n) {
        long mod = (int)1e9+7;
        long dp[] = new long[n+1];
        dp[0] = 1;
        dp[1] = 2;
        for(int i=2; i<=n; i++){
            dp[i] = (dp[i-1] + dp[i-2])%mod;
        }
        return (int)((dp[n]*dp[n])%mod);
    }
}

//Finbonacci Approach
class Solution {

    public int countHousePlacements(int n) {
        long mod = (int)1e9+7;
        long last = 1, lastlast = 1, ans = 1;
        for(int i=1; i<=n; i++){
            ans = (last + lastlast) % mod;
            lastlast = last;
            last = ans;
        }
        return (int)((ans*ans) % mod);
    }
}
