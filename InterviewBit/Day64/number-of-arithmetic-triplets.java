//Link: https://leetcode.com/contest/weekly-contest-305/problems/number-of-arithmetic-triplets/

//Time & Space Complexity: O(N^2) O(N)

class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
        int n = nums.length;
        int ans = 0;
        Set<Integer> set = new HashSet<>();
        for(int i : nums)
            set.add(i);
        for(int i=n-1; i>=0; i--){
            if(set.contains(nums[i]-diff) && set.contains(nums[i]-(diff*2)))
                ans++;
        }
        return ans;
    }
}
