//Link: https://leetcode.com/problems/powx-n/

//Time & Space: O(logN) O(logN)

class Solution {
    double helper(double x, int n){
        if(x==0) return x;
        if(n==0) return 1;
        double res = helper(x, n/2);
        return ((n&1)==1) ? x * res * res : res*res;
    }
    public double myPow(double x, int n) {
        double ans = helper(x, Math.abs(n));
        return n>=0 ? ans : 1 / ans;
    }
}
