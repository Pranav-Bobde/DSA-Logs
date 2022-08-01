//Link: https://leetcode.com/contest/weekly-contest-304/problems/make-array-zero-by-subtracting-equal-amounts/

//Time & Space Complexity: O(N^2) O(1)

class Solution {
    public int minimumOperations(int[] nums) {
        int min = Integer.MAX_VALUE;
        int c = 0, n = nums.length;
        while(true){
            for(int i: nums){
                if(i>0)
                    min = Math.min(min, i);
            }
            if(min==Integer.MAX_VALUE) break;
            for(int i=0; i<n; i++){
                if(nums[i]>0)
                    nums[i]-=min;
            }
            min = Integer.MAX_VALUE;
            c++;
        }
        
        return c;
    }
}
