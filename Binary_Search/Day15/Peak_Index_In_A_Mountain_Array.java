//Link: https://leetcode.com/problems/peak-index-in-a-mountain-array/

//Time & Space Complexity: O(logN) O(1)

class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;
        int ans = 0;
        int s = 0, e = n-1;
        while(s<=e){
            int i = s + (e-s)/2;
            int curr = arr[i];
            if( (i<n-1 && curr > arr[i+1]) && (i>0 && curr > arr[i-1]) ){
                return i;
            }else if( (i==0) || (i>0 && curr > arr[i-1]) ){
                s = i + 1;
            }else if ( i<n-1 && curr > arr[i+1] ) {
                e = i -1;
            }
        }
        return -1;
    }
}
