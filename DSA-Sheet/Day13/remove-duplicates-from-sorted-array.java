//Link: https://leetcode.com/problems/remove-duplicates-from-sorted-array/

//Time & Space: O(NlogN) O(1)

class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int ans = 1;
        int k = 1;
        for(int i=1; i<n; i++){
            while(i<n && nums[i]==nums[i-1]) i++;
            if(i<n){
                nums[k++] = nums[i];
                ans++;
            }
        }
        return ans;
    }
}
