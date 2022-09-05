//Link: https://leetcode.com/problems/longest-consecutive-sequence/

//Time & Space: O(N) O(N)

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i: nums){
            set.add(i);
        }
        int ans = 0;
        for(int i : nums){
            if(!set.contains(i-1)){
                int t = i;
                while(set.contains(t+1)) t++;
                ans = Math.max(ans, t-i+1);
            }
        }
        return ans;
    }
}
