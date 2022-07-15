//Link: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

//Time & Space Complexity: O(logN) O(1)

class Solution {
    public int[] searchRange(int[] arr, int target) {
        if(arr.length == 0 || arr[0] > target || arr[n-1] < target) return new int[]{-1, -1};
        return new int[]{bs(arr, target, true), bs(arr, target, false)};   
    }
    
    int bs(int[] arr, int x, boolean first){
        int n = arr.length;
        if(first){
            if(arr[0] == x)
                return 0;
        }else{
            if(arr[n-1] == x)
                return n-1;
        }
        
        int s = 0, e = n-1;
        
        while(s<=e){
            int mid = s + (e-s)/2;
            
            if(first){
                if( arr[mid]==x && arr[mid-1]<x )
                    return mid;
            }else{
                if( arr[mid]==x && arr[mid+1]>x )
                    return mid;
            }
            
            if(first){
                if(arr[mid] < x){
                    s = mid + 1;
                }
                else{
                    e = mid - 1;
                }
            }else{
                if(arr[mid] <= x){
                    s = mid + 1;
                }
                else{
                    e = mid - 1;
                }
            }
        }
        
        return -1;
    }
}
