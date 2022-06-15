//Link: https://leetcode.com/problems/find-the-duplicate-number/

//Time & Space: O(N) O(1)

class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        
        int s = 0, f = 0;
        
        do{
            s = nums[s];
            f = nums[nums[f]];
        }while(s!=f);
        
        int s1 = 0;
        
        while(s1!=s){
            s1 = nums[s1];
            s = nums[s];
        }
        return s;
    }
}
