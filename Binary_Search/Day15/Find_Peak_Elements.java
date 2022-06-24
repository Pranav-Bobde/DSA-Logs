//Link: https://leetcode.com/problems/find-peak-element/

//Time & Space Complexity: O(logN) O(1)

class Solution {
    public int findPeakElement(int[] arr) {
        int n = arr.length;
        
        if(n==1) return 0;
        
        int s=0, e=n-1;
        
        while(s<=e){
            int i = s + (e-s)/2;
            int curr = arr[i];
            if( (i==0 && curr>arr[i+1]) || (i==n-1 && curr>arr[i-1]) || (i>0 && curr > arr[i-1]) && (i<n-1 && curr > arr[i+1]) ){
                return i;
            }else if( curr < arr[i+1] ){
                s = i + 1;
            }else{
                e = e - 1;
            }
        }
        return -1;
    }
}
