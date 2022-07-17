//Link: https://leetcode.com/problems/find-peak-element/

//Time & Space Complexity: O(logN) O(1)

//Mine
class Solution {
    public int findPeakElement(int[] arr) {
        int n = arr.length;
        int s = 0, e = n-1;
        if(n==1) return 0;
        if(n==2)
        {
            if(arr[0]>arr[1])
                return 0;
            return 1;
        }
        while(s<=e){
            int mid = s + (e-s)/2;
            if((mid>0 && arr[mid]>arr[mid-1]) && (mid<n-1 && arr[mid]>arr[mid+1]) || (mid==0 && arr[mid]>arr[mid+1]) || (mid==n-1 && arr[mid]>arr[mid-1])){
                return mid;
            }
            if(mid<n-1 && arr[mid]<arr[mid+1]){
                s = mid + 1;
            }else{
                e = mid - 1;
            }
        }
        return -1;
    }
}
