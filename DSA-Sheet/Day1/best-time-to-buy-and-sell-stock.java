//Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

//Time & Space: O(N) O(1)

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int ans = 0;
        int i=0, j=1;
        while(j<n){
            if(prices[j]<prices[i]){
                i = j;
            }
            ans = Math.max(ans, prices[j]-prices[i]);
            j++;
        }
        return ans;
    }
}
