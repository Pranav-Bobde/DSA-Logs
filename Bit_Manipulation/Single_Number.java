//Link: https://leetcode.com/problems/single-number/

//Time & Space Complexity: O(N) O(1)

class Solution {
    public int singleNumber(int[] nums) {
        int n = 0;
        for(int i: nums)
            n^=i;
        return n;
    }
}
