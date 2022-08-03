//Link: https://leetcode.com/contest/weekly-contest-302/problems/maximum-number-of-pairs-in-array/

//Time & Space Complexity: O(N) O(N)

class Solution {
    public int[] numberOfPairs(int[] nums) {
        int[] f = new int[101];
        for(int i : nums){
            f[i]++;
        }
        int pairs = 0, rem = 0;
        for(int i : f){
            if(i!=0){
                pairs += i/2;
                rem += i%2;
            }
        }
        return new int[]{pairs, rem};
    }
}
