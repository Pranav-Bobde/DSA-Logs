//Link: https://leetcode.com/problems/max-consecutive-ones/

//Time & Space: O(N) O(1)

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int ans = 0, c=0;
        for(int i : nums){
            if(i==1){
                c++;
            }else{
                ans = Math.max(ans, c);
                c = 0;
            }
        }
        ans = Math.max(ans, c);
        return ans;
    }
}
