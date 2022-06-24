//Link: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/

//Time & Space Complexity: O(logN) O(1)

class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        if(nums[0] < nums[n-1]) return nums[0];
        
        int peak = bs(nums);
        if(peak == -1)
            return nums[n-1];
        return nums[peak+1];
    }
    
    int bs(int[] arr){
        int n = arr.length;
        int s=0, e=n-1;
        
        while(s<=e){
            int i = s + (e-s)/2;
            int curr = arr[i];
            if( (i==0 && curr>arr[i+1]) || (i>0 && curr > arr[i-1]) && (i<n-1 && curr > arr[i+1]) ){
                return i;
            }else if( arr[s] > curr ){
                e = i - 1;
            }else{
                s = i + 1;
            }
        }
        return -1;
    }
    
}
