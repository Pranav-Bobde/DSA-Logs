//Link https://leetcode.com/problems/minimum-size-subarray-sum/

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        
        int i=0, j = 0, ans = Integer.MAX_VALUE, sum =0;
        
        while(j<n){
            sum+=nums[j];
            if(sum >= target){
                while(i<n && sum>=target){
                    ans = Math.min(ans, j-i+1);
                    sum-=nums[i++];
                }
            }
            j++;
        }
        
        return ans==Integer.MAX_VALUE ? 0 : ans;
    }
}
