//Link: https://leetcode.com/problems/search-insert-position/

//Time & Space Complexity: O(logN) O(1)

class Solution {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int s = 0, e = n-1;
        while(s<=e){
            int mid = s + (e-s)/2;
            if(nums[mid]==target)
                return mid;
            if(target < nums[mid])
                e = mid - 1;
            else 
                s = mid + 1;
        }
        return s;
    }
}
