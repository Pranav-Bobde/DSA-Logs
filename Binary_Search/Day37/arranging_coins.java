//Link: https://leetcode.com/problems/arranging-coins/

//TIme & Space Complexity: O(logN) O(1)

class Solution {
    public int arrangeCoins(int n) {
        long s= 0, e = n;
        while(s<=e){
            long mid = s + (e-s)/2;
            long needed = (mid * (mid+1))/2;
            if(needed == n){
                return (int)mid;
            }else if(n < needed){
                e = mid - 1;
            }else{
                s = mid + 1;
            }
        }
        return (int)e;
    }
}
