//Link: https://leetcode.com/problems/search-in-rotated-sorted-array/

//Time & Space Complexity: O(logN) O(1)

class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int s = 0, e = n-1;
        while(s<=e){
            int mid = s + (e-s)/2;
            if(nums[mid] == target)
                return mid;
            if(nums[mid] >= nums[s]){
                if(target > nums[mid] || target < nums[s]){
                    s = mid + 1;
                }else{
                    e = mid - 1;
                }
            }else{
                if(target < nums[mid] || target > nums[e]){
                    e = mid - 1;
                }else{
                    s = mid + 1;
                }
            }
        }
        return -1;
    }
}
