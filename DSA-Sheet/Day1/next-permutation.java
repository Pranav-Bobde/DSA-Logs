//Link: https://leetcode.com/problems/next-permutation/

//Time & Space: O(N) O(1)

class Solution {
    void reverse(int[] arr, int i){
        int j = arr.length-1;
        while(i<j){
            swap(arr, i++, j--);
        }
    }
    void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void nextPermutation(int[] nums) {
        if(nums.length==1) return;
        int n = nums.length;
        int i = n-2;
        while(i>=0 && nums[i]>=nums[i+1]) i--;
        if(i>=0){
            int j = n-1;
            while(j>i && nums[j]<=nums[i]) j--;
            swap(nums, i, j);
        }
        reverse(nums, i+1);
    }
}
