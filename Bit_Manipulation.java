//Link: https://leetcode.com/problems/single-number/

class Solution {
    public int singleNumber(int[] nums) {
        int n = 0;
        for(int i: nums)
            n^=i;
        return n;
    }
}
