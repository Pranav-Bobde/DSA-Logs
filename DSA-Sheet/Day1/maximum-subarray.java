//Link: https://leetcode.com/problems/maximum-subarray/

//Time & Space: O(N) O(1)

class Solution {
    public int maxSubArray(int[] nums) {
        int curr = 0, max = nums[0];
        for(int i : nums){
            curr+=i;
            max = Math.max(curr, max);
            if(curr<0)
                curr = 0;
        }
        return max;
    }
}
