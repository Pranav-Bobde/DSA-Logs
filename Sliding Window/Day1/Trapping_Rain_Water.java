// Link: https://leetcode.com/problems/trapping-rain-water/

class Solution {
    public int trap(int[] height) {
        int n = height.length;
        
        int i = 0, j = n-1, lmax = height[i], rmax = height[j], ans = 0, curr = 0;
        
        while(i<=j){
            if(lmax <= rmax){
                curr = Math.min(lmax, rmax) - height[i];
                lmax = Math.max(lmax, height[i]);
                i++;
            }else{
                curr = Math.min(lmax, rmax) - height[j];
                rmax = Math.max(rmax, height[j]);
                j--;
            }
            if(curr > 0) ans += curr;
        }
        
        return ans;
    }
}
