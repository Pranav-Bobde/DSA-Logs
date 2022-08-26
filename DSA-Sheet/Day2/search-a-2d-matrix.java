//Link: https://leetcode.com/problems/search-a-2d-matrix/

//Time & Space: O(logM + logN) O(1)

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int s = 0, e = m-1;
        
        int row = 0;
        //bs in col 1
        while(s<=e){
            int mid = s + (e-s)/2;
            if((target >= matrix[mid][0] && target <= matrix[mid][n-1]) || s==e){
                row = mid;
                break;
            }
            if(target < matrix[mid][0]){
                e = mid - 1;
            }else{
                s = mid + 1;
            }
        }
        
        int[] arr = matrix[row];
        
        //bs in row
        s = 0;
        e = n-1;
        while(s<=e){
            int mid = s + (e-s)/2;
            if(arr[mid]==target){
                return true;
            }else if(arr[mid]<target){
                s = mid + 1;
            }else{
                e = mid - 1;
            }
        }
        return false;
    }
}
