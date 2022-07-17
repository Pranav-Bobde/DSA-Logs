//Link: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/

//Time & Space Complexity: O(logN) O(1)

class Solution {
    public int findMin(int[] arr) {
        int n = arr.length;
        int s = 0, e = n-1;
        if(arr[0]<=arr[n-1]){
            return arr[0];
        }
        while(s<=e){
            int mid = s + (e-s)/2;
            if((mid < n-1 && arr[mid] <= arr[mid + 1]) && (mid >0 && arr[mid] <= arr[mid - 1]) || mid == n-1){
                return arr[mid];
            }
            if(arr[mid] >= arr[0]){
                s = mid + 1;
            }else{
                e = mid - 1;
            }
        }
        return -1;
    }
}
