//Link: https://leetcode.com/problems/valid-perfect-square/

//Time & Space Complexity: O(logN) O(1)

class Solution {
    public boolean isPerfectSquare(int num) {
        int s = 1, e = (int) Math.floor(Math.sqrt(num));
        while(s<=e){
            int mid = s + (e-s)/2;
            if(mid*mid == num)
                return true;
            if(mid*mid < num){
                s = mid + 1;
            }else{
                e = mid - 1;
            }
        }
        
        return false;
    }
}
