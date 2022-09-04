//Link: https://leetcode.com/problems/subarray-sum-equals-k/

//Time & Space: O(N) O(N)

class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int ans = 0, sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        
        for(int i : nums){
            sum+=i;
            ans += map.getOrDefault(sum - k, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        
        return ans;
    }
}
