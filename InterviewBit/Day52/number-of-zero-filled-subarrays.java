//Link: https://leetcode.com/contest/biweekly-contest-83/problems/number-of-zero-filled-subarrays/

//Time & Space Complexity: O(N) O(1)

class Solution {
    public long zeroFilledSubarray(int[] nums) {
        int n = nums.length;
        int i=0, j=0;
        long ans = 0;
        while(j<n){
            if(nums[j]==0){
                i = j;
                while(j+1<n && nums[j+1]==0) j++; 
                long N = j-i+1;
                ans += ((N*(N+1))/2);
            }
            
            j++;
        }
        return ans;
    }
}
