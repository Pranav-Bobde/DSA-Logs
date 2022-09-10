//Link: https://leetcode.com/problems/trapping-rain-water/

//Time & Space: O(N) O(1)

class Solution {
    public int trap(int[] h) {
        int n = h.length;
        if(n<3) return 0;
        int ans = 0;
        int l=0, r = n-1, lmax = h[0], rmax = h[n-1];
        while(l<=r){
            if(lmax<=rmax){
                int water = lmax - h[l];
                ans += water;
                if(l<n-1)
                    lmax = Math.max(lmax, h[l+1]);
                l++;
            }else{
                int water = rmax - h[r];
                ans += water;
                if(r>0)
                    rmax = Math.max(rmax, h[r-1]);
                r--;
            }
        }
        return ans;
    }
}
